package com.example.lbsbackend.entity;

import com.example.lbsbackend.enumable.BookRequestStatus;
import lombok.Data;

import java.util.Date;

@Data
public class BookRequest extends Entity {
    private Long libraryId;
    private String title;
    private String reason;
    private String image;
    private String author;
    private String subject;
    private String format;
    private String publisher;
    private Date publishedDate;
    private String language;
    private String country;
    private String isbn;
    private BookRequestStatus status;
    private String validated_by;
    private String validated_time;
}
