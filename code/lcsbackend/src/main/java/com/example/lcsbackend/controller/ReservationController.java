package com.example.lcsbackend.controller;

import com.example.lcsbackend.dto.AddReservationDto;
import com.example.lcsbackend.entity.Reservation;
import com.example.lcsbackend.response.Result;
import com.example.lcsbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ReservationController
 *@Description: Reservation Controller
 **/
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * query reservations
     *
     * @Description: query all reservations
     * @Param: Long realLibraryId
     * @Param: Long targetLibraryId
     * @Return: Result
     **/
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result queryReservations(Long realLibraryId, Long targetLibraryId) {
        return new Result(reservationService.queryReservations(realLibraryId, targetLibraryId));
    }

    /**
     * reserve
     *
     * @Description: request reserve
     * @Param: List<AddReservationDto> reservationDtos
     * @Return: Result
     **/
    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public Result reserve(@RequestBody @Validated List<AddReservationDto> reservationDtos) {
        return new Result(reservationService.addReservations(AddReservationDto.batchConvertToBook(reservationDtos)));
    }
}
