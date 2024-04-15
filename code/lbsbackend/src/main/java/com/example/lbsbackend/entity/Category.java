package com.example.lbsbackend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Category extends Entity{
    private Long libraryId;
    private Long parentId;
    private String name;
}
