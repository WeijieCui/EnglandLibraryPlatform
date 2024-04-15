package com.example.lbsbackend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Chapter extends Entity{
    private Long bookId;
    private Long parentId;
    private String title;
    private String audioLink;
    private String content;
}
