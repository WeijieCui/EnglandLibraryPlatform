package com.example.lbsbackend.dto;

import com.example.lbsbackend.util.page.PageRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @ClassName QueryReservationDto
 * @Description query reservation dto
 **/
@Data
public class QueryReservationDto {
    private Long libraryId;
    private Long userId;
    @NotNull
    private PageRequest page;
}
