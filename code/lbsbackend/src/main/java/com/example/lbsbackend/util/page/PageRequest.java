package com.example.lbsbackend.util.page;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @ClassName PageRequest
 * @Description page request data
 **/
@Data
public class PageRequest {
    @NotNull
    private int current; // current page number
    @NotNull
    private int pageSize; // the number of items per page
}
