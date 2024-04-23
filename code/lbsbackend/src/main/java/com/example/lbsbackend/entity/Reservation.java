package com.example.lbsbackend.entity;

import com.example.lbsbackend.enumable.BookReservedStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Reservation extends Entity {
    private Long libraryId;
    private Long targetLibraryId;
    private Long bookId;
    private Book book;
    private Long bookPrintingId;
    private BookPrinting bookPrinting;
    private Long userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expectedPickupTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date realPickupTime;
    private BookReservedStatus status;
}
