package com.example.lcsbackend.entity;

import com.example.lcsbackend.enumable.CarriageType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class TransferAction extends Entity{
    private Long sourceLibraryId;
    private Long targetLibraryId;
    private Long sourceSpotId;
    private Long targetSpotId;
    private Long sourceShelfId;
    private Long targetShelfId;
    private Date expectedPickupTime;
    private Date expectedFinishedTime;
    private Date realPickupTime;
    private Date realFinishedTime;
    private Long carriageId;
    private CarriageType carriageType;
}
