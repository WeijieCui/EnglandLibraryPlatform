package com.example.lcsbackend.mapper;

import com.example.lcsbackend.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    List<Reservation> queryReservations(Long realLibraryId, Long targetLibraryId);
    List<Reservation> queryReservationByIds(List<Long> ids);
    Integer addReservations(List<Reservation> reservations);
    Integer updateStatusByIds(List<Long> ids, String status);
}
