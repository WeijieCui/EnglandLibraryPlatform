package com.example.lbsbackend.service;

import com.example.lbsbackend.entity.Category;

import java.util.List;

/**
 * CategoryService
 *
 * @description: CategoryService
 */
public interface CategoryService {
    /**
     * query categories
     *
     * @description: query categories
     * @param: Long libraryId,Long parentId
     * @return: List<Category>
     */
    List<Category> queryCategories(Long libraryId, Long parentId);

    /**
     * batch add categories
     *
     * @description: batch add categories
     * @param: List<Category> Categories
     * @return: success
     */
    Boolean addCategories(List<Category> Categories);

    /**
     * batch delete categories
     *
     * @description: batch delete categories
     * @param: List<Long> ids
     * @return: success
     */
    Boolean deleteCategories(List<Long> ids);
}
