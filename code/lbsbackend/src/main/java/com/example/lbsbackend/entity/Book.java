package com.example.lbsbackend.entity;

import com.example.lbsbackend.enumable.BookStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Book extends Entity {
    private Long categoryId;
    private Long libraryId;
    private Long realLibraryId;
    private Long shelfId;
    private Long realShelfId;
    private String title;
    private String summary;
    private String image;
    private String author;
    private String subject;
    private String format;
    private String publisher;
    private Date publishedDate;
    private String language;
    private String country;
    private String isbn;
    private BookStatus status;
}
