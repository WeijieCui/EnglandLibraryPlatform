package com.example.lbsbackend.entity;

import com.example.lbsbackend.enumable.BookReservedStatus;
import lombok.Data;

import java.util.Date;

@Data
public class Reservation extends Entity {
    private Long libraryId;
    private Long targetLibraryId;
    private Long bookId;
    private Long userId;
    private Date expectedPickupTime;
    private Date realPickupTime;
    private BookReservedStatus status;
}
