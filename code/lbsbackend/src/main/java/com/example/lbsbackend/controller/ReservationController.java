package com.example.lbsbackend.controller;

import com.example.lbsbackend.dto.AddReservationDto;
import com.example.lbsbackend.dto.QueryReservationDto;
import com.example.lbsbackend.entity.BookPrinting;
import com.example.lbsbackend.entity.Reservation;
import com.example.lbsbackend.enumable.BookPrintingStatus;
import com.example.lbsbackend.response.Result;
import com.example.lbsbackend.service.BookPrintingService;
import com.example.lbsbackend.service.ReservationService;
import com.example.lbsbackend.enumable.BookReservedStatus;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * ReservationController
 *
 * @description: ReservationController
 */
@RestController
@RequestMapping("/api/reservation")
@Transactional
public class ReservationController {
    private final ReservationService reservationService;
    private final BookPrintingService bookPrintingService;

    public ReservationController(ReservationService reservationService, BookPrintingService bookPrintingService) {
        this.reservationService = reservationService;
        this.bookPrintingService = bookPrintingService;
    }

    /**
     * addReservations
     *
     * @description: batch add reservations
     * @param: List<AddReservationDto>
     * @return: Result
     */
    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    public Result addReservations(@RequestBody @Valid List<AddReservationDto> reservationDtos) {
        List<Long> bookPrintingIds = reservationDtos.stream().map(AddReservationDto::getBookPrintingId).toList();
        List<BookPrinting> printings = bookPrintingService.queryBookPrintingByIds(bookPrintingIds);
        List<BookPrinting> filteredBookPrintings = printings.stream()
                .filter(printing -> BookPrintingStatus.AVAILABLE.equals(printing.getStatus())).toList();
        Map<Long, BookPrinting> printingMap = new HashMap<>();
        filteredBookPrintings.forEach(printing -> printingMap.put(printing.getId(), printing));
        List<Long> filteredPrintingIds = filteredBookPrintings.stream().map(BookPrinting::getId).toList();
        List<AddReservationDto> filteredReservationDtos = reservationDtos.stream()
                .filter(dto -> printingMap.containsKey(dto.getBookPrintingId())).toList();
        List<Reservation> reservations = AddReservationDto.batchConvertToReservation(filteredReservationDtos);
        reservations.forEach(r -> r.setBookId(printingMap.get(r.getBookPrintingId()).getBookId()));
        bookPrintingService.updateStatusByIds(filteredPrintingIds, BookPrintingStatus.RESERVING);
        return new Result(reservationService.addReservations(reservations));
    }

    /**
     * queryReservations
     *
     * @description: query reservations
     * @param: QueryReservationDto dto
     * @return: Result
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result queryReservations(@RequestBody @Valid QueryReservationDto dto) {
        return new Result(reservationService.queryReservations(dto.getLibraryId(), dto.getUserId(), dto.getPage()));
    }

    /**
     * transferBooks
     *
     * @description: transfer books to target library
     * @param: List<Long> reservationId
     * @return: Result
     */
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public Result transferBooks(@RequestBody List<Long> reservationId) {
        List<Reservation> reservations = reservationService.queryReservationByIds(reservationId);
        List<Long> filteredReservations = reservations.stream()
                .filter(reservation -> BookReservedStatus.APPLIED.equals(reservation.getStatus()))
                .map(Reservation::getId)
                .collect(Collectors.toList());
        return new Result(reservationService.updateStatusByIds(filteredReservations, BookReservedStatus.TRANSFERING));
    }

    /**
     * readyBooks
     *
     * @description: books were ready for picking up
     * @param: List<Long> reservationId
     * @return: Result
     */
    @RequestMapping(value = "/ready", method = RequestMethod.POST)
    public Result readyBooks(@RequestBody List<Long> reservationId) {
        List<Reservation> reservations = reservationService.queryReservationByIds(reservationId);
        List<Long> filteredReservations = reservations.stream()
                .filter(reservation -> BookReservedStatus.TRANSFERING.equals(reservation.getStatus()))
                .map(Reservation::getId)
                .collect(Collectors.toList());
        return new Result(reservationService.updateStatusByIds(filteredReservations, BookReservedStatus.READY));
    }

    /**
     * pickupBooks
     *
     * @description: users pick up books from self-service machine
     * @param: List<Long> reservationId
     * @return: Result
     */
    @RequestMapping(value = "/pickup", method = RequestMethod.POST)
    public Result pickupBooks(@RequestBody List<Long> reservationId) {
        List<Reservation> reservations = reservationService.queryReservationByIds(reservationId);
        List<Reservation> filteredReservations = reservations.stream()
                .filter(reservation -> BookReservedStatus.READY.equals(reservation.getStatus())).toList();
        List<Long> filteredIds = filteredReservations.stream().map(Reservation::getId).toList();
        List<Long> bookPrintingIds = filteredReservations.stream().map(Reservation::getBookPrintingId).toList();
        bookPrintingService.updateStatusByIds(bookPrintingIds, BookPrintingStatus.BRROWING);
        return new Result(reservationService.updateStatusByIds(filteredIds, BookReservedStatus.DONE));
    }
}
