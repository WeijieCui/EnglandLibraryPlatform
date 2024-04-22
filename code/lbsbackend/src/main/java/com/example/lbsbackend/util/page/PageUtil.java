package com.example.lbsbackend.util.page;

import com.github.pagehelper.PageInfo;

/**
 * @ClassName PageUtil
 * @Description page util
 **/
public class PageUtil {

    /**
     * getPageResult
     *
     * @description: convert result to page result
     * @param: PageRequest request, PageInfo<?> pageInfo
     * @return: PageResult
     */
    public static PageResult convertPageResult(PageInfo<?> pageInfo) {
        PageResult result = new PageResult();
        result.setCurrent(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotalSize(pageInfo.getTotal());
        result.setTotalPages(pageInfo.getPages());
        result.setData(pageInfo.getList());
        return result;
    }

}