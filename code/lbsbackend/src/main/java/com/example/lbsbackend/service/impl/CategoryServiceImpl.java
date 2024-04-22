package com.example.lbsbackend.service.impl;

import com.example.lbsbackend.entity.Category;
import com.example.lbsbackend.mapper.CategoryMapper;
import com.example.lbsbackend.service.CategoryService;
import com.example.lbsbackend.util.EntityHelper;
import com.example.lbsbackend.util.page.PageRequest;
import com.example.lbsbackend.util.page.PageResult;
import com.example.lbsbackend.util.page.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageResult queryCategories(Long libraryId, Long parentId, PageRequest page) {
        PageHelper.startPage(page.getCurrent(),page.getPageSize());
        return PageUtil.convertPageResult(new PageInfo<>(categoryMapper.queryCategories(libraryId, parentId)));
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
