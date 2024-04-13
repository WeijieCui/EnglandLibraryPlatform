package com.example.lbsbackend.controller;

import com.example.lbsbackend.dto.AddCategoryDto;
import com.example.lbsbackend.entity.Category;
import com.example.lbsbackend.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    public Boolean addCategories(@RequestBody @Validated List<AddCategoryDto> categoryDtos){
        return categoryService.addCategories(AddCategoryDto.batchConvertToCategory(categoryDtos));
    }
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    public Boolean deleteCategories(@RequestBody @Validated List<Long> categoryIds){
        return categoryService.deleteCategories(categoryIds);
    }
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public List<Category> queryCategories(Long libraryId,Long parentId){
        return categoryService.queryCategories(libraryId, parentId);
    }
}
