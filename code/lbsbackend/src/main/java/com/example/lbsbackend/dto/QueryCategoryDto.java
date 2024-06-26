package com.example.lbsbackend.dto;

import com.example.lbsbackend.util.page.PageRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @ClassName QueryCategoryDto
 * @Description query category dto
 **/
@Data
public class QueryCategoryDto {
    private Long libraryId;
    private Long parentId;
    @Valid
    @NotNull
    private PageRequest page;
}
