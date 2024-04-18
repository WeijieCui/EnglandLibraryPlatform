package com.example.lbsbackend.util.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PageRequest
 * @Description page request data
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {
    private int pageNum; // current page number
    private int pageSize; // the number of items per page
}
