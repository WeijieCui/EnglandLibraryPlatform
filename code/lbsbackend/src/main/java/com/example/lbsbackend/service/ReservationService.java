package com.example.lbsbackend.service;

import com.example.lbsbackend.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> queryReservations(Long libraryId, Long userId);
    List<Reservation> queryReservationByIds(List<Long> reservationIds);
    Boolean addReservations(List<Reservation> reservations);
    Boolean updateStatusByIds(List<Long> ids, String status);
}
