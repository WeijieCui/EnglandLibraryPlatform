package com.example.lbsbackend.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Category extends Entity{
    private Long libraryId;
    private Long parentId;
    private String name;
}
