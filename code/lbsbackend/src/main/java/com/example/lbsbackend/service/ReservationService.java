package com.example.lbsbackend.service;

import com.example.lbsbackend.entity.Reservation;

import java.util.List;

/**
 * ReservationService
 *
 * @description: Reservation Service Interface
 */
public interface ReservationService {
    /**
     * queryReservations
     *
     * @description: query reservations
     * @param: Long libraryId, Long userId
     * @return: List<Reservation>
     */
    List<Reservation> queryReservations(Long libraryId, Long userId);

    /**
     * queryReservationByIds
     *
     * @description: query reservations
     * @param: List<Long> ids
     * @return: List<Reservation>
     */
    List<Reservation> queryReservationByIds(List<Long> ids);

    /**
     * addReservations
     *
     * @description: batch add reservations
     * @param: List<Reservation> reservations
     * @return: success
     */
    Boolean addReservations(List<Reservation> reservations);

    /**
     * updateStatusByIds
     *
     * @description: update reserved status by ids
     * @param: List<Long> ids, String status
     * @return: success
     */
    Boolean updateStatusByIds(List<Long> ids, String status);
}
