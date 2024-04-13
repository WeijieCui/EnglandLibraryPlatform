package com.example.lbsbackend.entity;

import com.example.lbsbackend.enumable.BorrowAction;
import lombok.Data;

@Data
public class BorrowingRecord extends Entity {
    private Long libraryId;
    private Long bookId;
    private BorrowAction action;
}
