package com.example.lbsbackend.service.impl;

import com.example.lbsbackend.entity.BookPrinting;
import com.example.lbsbackend.entity.Reservation;
import com.example.lbsbackend.enumable.BookReservedStatus;
import com.example.lbsbackend.mapper.BookMapper;
import com.example.lbsbackend.mapper.BookPrintingMapper;
import com.example.lbsbackend.mapper.ReservationMapper;
import com.example.lbsbackend.service.ReservationService;
import com.example.lbsbackend.util.EntityHelper;
import com.example.lbsbackend.util.page.PageRequest;
import com.example.lbsbackend.util.page.PageResult;
import com.example.lbsbackend.util.page.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ReservationService")
public class ReservationServiceImpl implements ReservationService {
    private final ReservationMapper reservationMapper;
    private final EntityHelper entityHelper;
    private final BookPrintingMapper bookPrintingMapper;


    public ReservationServiceImpl(ReservationMapper reservationMapper, EntityHelper entityHelper, BookPrintingMapper bookPrintingMapper) {
        this.reservationMapper = reservationMapper;
        this.entityHelper = entityHelper;
        this.bookPrintingMapper = bookPrintingMapper;
    }

    @Override
    public List<Reservation> queryReservationByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        return reservationMapper.queryReservationByIds(ids);
    }

    @Override
    public PageResult queryReservations(Long libraryId, Long userId, PageRequest page) {
        PageHelper.startPage(page.getCurrent(), page.getPageSize());
        return PageUtil.convertPageResult(new PageInfo<>(reservationMapper.queryReservations(libraryId, userId)));
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
    public Boolean updateStatusByIds(List<Long> ids, BookReservedStatus status) {
        if (ids == null || ids.isEmpty()) {
            return false;
        }
        return reservationMapper.updateStatusByIds(ids, status.name()) > 0;
    }
}
