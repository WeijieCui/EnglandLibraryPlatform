package com.example.lcsbackend.dto;

import com.example.lcsbackend.entity.Reservation;
import com.example.lcsbackend.enumable.BookReservedStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AddReservationDto {
    @NotNull
    private Long id;
    @NotNull
    private Long realLibraryId;
    @NotNull
    private Long realSpotId;
    @NotNull
    private Long realShelfId;
    @NotNull
    private Long targetLibraryId;
    @NotNull
    private Long targetSpotId;
    @NotNull
    private Long targetShelfId;
    @NotNull
    private Long userId;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expectedPickupTime;
    @NotNull
    private BookReservedStatus status;
    @NotNull
    private Long bookId;
    @NotNull
    private Long bookLibraryId;
    @NotNull
    private String bookTitle;
    private String bookImage;
    @NotNull
    private String bookAuthor;
    @NotNull
    private String bookFormat;
    private String bookIsbn;

    public static List<Reservation> batchConvertToBook(List<AddReservationDto> dtos) {
        List<Reservation> reservations = new ArrayList<>();
        dtos.forEach(dto -> {
            Reservation reservation = new Reservation();
            BeanUtils.copyProperties(dto, reservation);
            reservation.setSourceId(reservation.getId());
            reservation.setId(null);
            reservations.add(reservation);
        });
        return reservations;
    }
}
