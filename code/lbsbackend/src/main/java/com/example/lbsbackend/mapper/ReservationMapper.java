package com.example.lbsbackend.mapper;

import com.example.lbsbackend.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    List<Reservation> queryReservations(Long libraryId, Long userId);
    List<Reservation> queryReservationByIds(List<Long> reservationIds);
    Integer addReservations(List<Reservation> reservations);
    Integer updateStatusByIds(List<Long> ids, String status);
}
