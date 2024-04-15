package com.example.lbsbackend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends Entity{
    private String userName;
}
