package com.example.lbsbackend.service.impl;

import com.example.lbsbackend.entity.Category;
import com.example.lbsbackend.mapper.CategoryMapper;
import com.example.lbsbackend.service.CategoryService;
import com.example.lbsbackend.util.EntityHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final EntityHelper entityHelper;

    public CategoryServiceImpl(CategoryMapper categoryMapper, EntityHelper entityHelper) {
        this.categoryMapper = categoryMapper;
        this.entityHelper = entityHelper;
    }

    @Override
    public List<Category> queryCategories(Long libraryId, Long parentId) {
        return categoryMapper.queryCategories(libraryId, parentId);
    }

    @Override
    public Boolean addCategories(List<Category> categories) {
        if (categories == null || categories.isEmpty()) {
            return false;
        }
        entityHelper.batchCheckEntity(categories);
        return categoryMapper.addCategories(categories) > 0;
    }

    @Override
    public Boolean deleteCategories(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return false;
        }
        return categoryMapper.deleteCategories(ids) > 0;
    }
}
