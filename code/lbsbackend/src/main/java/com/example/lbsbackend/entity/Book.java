package com.example.lbsbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Book extends Entity {
    private Long categoryId;
    private String title;
    private String summary;
    private String image;
    private String author;
    private String subject;
    private String format;
    private String publisher;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedDate;
    private String language;
    private String country;
    private String isbn;
}
