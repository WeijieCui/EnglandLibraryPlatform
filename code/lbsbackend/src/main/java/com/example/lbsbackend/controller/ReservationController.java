package com.example.lbsbackend.controller;

import com.example.lbsbackend.dto.AddReservationDto;
import com.example.lbsbackend.entity.Book;
import com.example.lbsbackend.entity.Reservation;
import com.example.lbsbackend.enumable.BookReservedStatus;
import com.example.lbsbackend.enumable.BookStatus;
import com.example.lbsbackend.service.ReservationService;
import com.example.lbsbackend.service.BookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final BookService bookService;

    public ReservationController(ReservationService reservationService, BookService bookService) {
        this.reservationService = reservationService;
        this.bookService = bookService;
    }

    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    public Boolean addReservations(@RequestBody @Validated List<AddReservationDto> reservationDtos) {
        List<Long> bookIds = reservationDtos.stream().map(AddReservationDto::getBookId).toList();
        List<Book> books = bookService.queryBookByIds(bookIds);
        List<Book> filteredBooks = books.stream().filter(book -> BookStatus.AVAILABLE.equals(book.getStatus())).toList();
        Set<Long> filteredBookIds = filteredBooks.stream().map(Book::getId).collect(Collectors.toSet());
        List<AddReservationDto> filteredReservationDtos = reservationDtos.stream()
                .filter(dto -> filteredBookIds.contains(dto.getBookId())).toList();
        List<Reservation> reservations = AddReservationDto.batchConvertToReservation(filteredReservationDtos);
        return reservationService.addReservations(reservations);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public List<Reservation> queryReservations(Long libraryId, Long userId) {
        return reservationService.queryReservations(libraryId, userId);
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public Boolean transferBooks(@RequestBody List<Long> reservationId) {
        List<Reservation> reservations = reservationService.queryReservationByIds(reservationId);
        List<Long> filteredReservations = reservations.stream()
                .filter(reservation -> BookReservedStatus.APPLIED.equals(reservation.getStatus()))
                .map(Reservation::getId)
                .collect(Collectors.toList());
        return reservationService.updateStatusByIds(filteredReservations, BookReservedStatus.TRANSFERING.name());
    }
}
