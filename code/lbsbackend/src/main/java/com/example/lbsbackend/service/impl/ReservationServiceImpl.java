package com.example.lbsbackend.service.impl;

import com.example.lbsbackend.entity.Reservation;
import com.example.lbsbackend.enumable.BookReservedStatus;
import com.example.lbsbackend.mapper.ReservationMapper;
import com.example.lbsbackend.service.ReservationService;
import com.example.lbsbackend.util.EntityHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ReservationService")
public class ReservationServiceImpl implements ReservationService {
    private final ReservationMapper reservationMapper;
    private final EntityHelper entityHelper;


    public ReservationServiceImpl(ReservationMapper reservationMapper, EntityHelper entityHelper) {
        this.reservationMapper = reservationMapper;
        this.entityHelper = entityHelper;
    }

    @Override
    public List<Reservation> queryReservationByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        return reservationMapper.queryReservationByIds(ids);
    }

    @Override
    public List<Reservation> queryReservations(Long libraryId, Long userId) {
        return reservationMapper.queryReservations(libraryId, userId);
    }

    @Override
    public Boolean addReservations(List<Reservation> reservations) {
        if (reservations == null || reservations.isEmpty()) {
            return false;
        }
        entityHelper.batchCheckEntity(reservations);
        reservations.forEach(reservation -> reservation.setStatus(BookReservedStatus.APPLIED));
        return reservationMapper.addReservations(reservations) > 0;
    }

    @Override
    public Boolean updateStatusByIds(List<Long> ids, String status) {
        if (ids == null || ids.isEmpty()) {
            return false;
        }
        return reservationMapper.updateStatusByIds(ids, status) > 0;
    }
}