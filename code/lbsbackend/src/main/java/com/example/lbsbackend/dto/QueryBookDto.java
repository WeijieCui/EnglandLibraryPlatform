package com.example.lbsbackend.dto;

import com.example.lbsbackend.util.page.PageRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @ClassName QueryBookDto
 * @Description query book dto
 **/
@Data
public class QueryBookDto {
    private Long categoryId;
    private String keyword;
    @NotNull
    private PageRequest page;
}
