package com.example.lbsbackend.entity;

import com.example.lbsbackend.enumable.BorrowAction;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BorrowingRecord extends Entity {
    private Long libraryId;
    private Long bookId;
    private BorrowAction action;
}
