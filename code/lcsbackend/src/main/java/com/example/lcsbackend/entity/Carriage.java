package com.example.lcsbackend.entity;

import com.example.lcsbackend.enumable.CarriageType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Carriage extends Entity {
    private String name;
    private CarriageType type;
    private Long libraryId;
    private Long positionId;
    private Long realPositionId;
}
