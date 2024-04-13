package com.example.lbsbackend.service;

import com.example.lbsbackend.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategories(Long libraryId,Long parentId);

    Boolean addCategories(List<Category> Categories);
    Boolean deleteCategories(List<Long> CategoryIds);
}
