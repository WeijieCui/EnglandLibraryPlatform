package com.example.lbsbackend.util.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName PageResult
 * @Description page data result
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    private int pageNum;
    private int pageSize;
    private int totalPages;
    private Long totalSize;
    private List<?> data;
}
