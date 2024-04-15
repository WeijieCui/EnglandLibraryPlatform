package com.example.lcsbackend.entity;

import com.example.lcsbackend.enumable.BookReservedStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Reservation extends Entity {
    private Long sourceId;
    private Long realLibraryId;
    private Long realSpotId;
    private Long realShelfId;
    private Long targetLibraryId;
    private Long targetSpotId;
    private Long targetShelfId;
    private Long userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expectedPickupTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date realPickupTime;
    private BookReservedStatus status;
    private Long bookId;
    private Long bookLibraryId;
    private String bookTitle;
    private String bookImage;
    private String bookAuthor;
    private String bookFormat;
    private String bookIsbn;
}
