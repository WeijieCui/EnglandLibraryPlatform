package com.example.lbsbackend.entity;

import lombok.Data;

@Data
public class Chapter extends Entity{
    private Long bookId;
    private Long parentId;
    private String title;
    private String audioLink;
    private String content;
}
