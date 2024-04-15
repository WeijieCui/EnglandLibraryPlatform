package com.example.lcsbackend.service;

import com.example.lcsbackend.entity.Reservation;

import java.util.List;

/**
 * ReservationService
 *
 * @description: ReservationService
 */
public interface ReservationService {
    /**
     * queryReservations
     *
     * @description: query reservations
     * @param: Long realLibraryId, Long targetLibraryId
     * @return: List<Reservation>
     */
    List<Reservation> queryReservations(Long realLibraryId, Long targetLibraryId);

    /**
     * queryReservationByIds
     *
     * @description: query reservation by ids
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
