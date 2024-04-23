package com.example.lbsbackend.dto;

import com.example.lbsbackend.entity.Reservation;
import com.example.lbsbackend.enumable.BookRequestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AddReservationDto {
    @NotNull
    private Long targetLibraryId;
    @NotNull
    private Long bookPrintingId;
    @NotNull
    private Long userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expectedPickupTime;

    public static List<Reservation> batchConvertToReservation(List<AddReservationDto> dtos){
        List<Reservation> reservations = new ArrayList<>();
        dtos.forEach(dto->{
            Reservation reservation = new Reservation();
            BeanUtils.copyProperties(dto,reservation);
            reservations.add(reservation);
        });
        return reservations;
    }
}
