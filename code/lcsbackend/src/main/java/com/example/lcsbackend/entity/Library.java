package com.example.lcsbackend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Library extends Entity{
    private String name;
}
