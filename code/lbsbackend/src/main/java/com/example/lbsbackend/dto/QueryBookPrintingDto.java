package com.example.lbsbackend.dto;

import com.example.lbsbackend.util.page.PageRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @ClassName QueryBookPrintingDto
 * @Description query book printing dto
 **/
@Data
public class QueryBookPrintingDto {
    private Long libraryId;
    private Long bookId;
    @NotNull
    private PageRequest page;
}
