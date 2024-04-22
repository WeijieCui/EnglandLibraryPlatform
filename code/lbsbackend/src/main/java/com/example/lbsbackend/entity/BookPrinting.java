package com.example.lbsbackend.entity;

import com.example.lbsbackend.enumable.BookStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookPrinting extends Entity {
    private Long bookId;
    private Long libraryId;
    private Library library;
    private Long realLibraryId;
    private Library realLibrary;
    private Long shelfId;
    private Long realShelfId;
    private BookStatus status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expAvailableDate;
}
