package com.example.lcsbackend.service.impl;

import com.example.lcsbackend.entity.Reservation;
import com.example.lcsbackend.enumable.BookReservedStatus;
import com.example.lcsbackend.mapper.ReservationMapper;
import com.example.lcsbackend.service.ReservationService;
import com.example.lcsbackend.util.EntityHelper;
import org.springframework.stereotype.Service;

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
        return reservationMapper.queryReservationByIds(ids);
    }

    @Override
    public List<Reservation> queryReservations(Long realLibraryId, Long targetLibraryId) {
        return reservationMapper.queryReservations(realLibraryId, targetLibraryId);
    }

    @Override
    public Boolean addReservations(List<Reservation> reservations) {
        entityHelper.batchCheckEntities(reservations);
        reservations.forEach(reservation->reservation.setStatus(BookReservedStatus.ACCEPTED));
        return reservationMapper.addReservations(reservations) > 0;
    }

    @Override
    public Boolean updateStatusByIds(List<Long> ids, String status) {
        return reservationMapper.updateStatusByIds(ids, status) > 0;
    }
}
