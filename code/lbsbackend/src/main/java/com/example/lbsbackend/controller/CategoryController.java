package com.example.lbsbackend.controller;

import com.example.lbsbackend.dto.AddCategoryDto;
import com.example.lbsbackend.entity.Category;
import com.example.lbsbackend.response.Result;
import com.example.lbsbackend.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CategoryController
 *
 * @description: category controller
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * batch add categories
     *
     * @description: batch add categories
     * @param: List<category> categories
     * @return: Result
     */
    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    public Result addCategories(@RequestBody @Validated List<AddCategoryDto> categoryDtos){
        return new Result(categoryService.addCategories(AddCategoryDto.batchConvertToCategory(categoryDtos)));
    }
    /**
     * batch delete categories
     *
     * @description: batch delete categories
     * @param: List<Long> categoryIds
     * @return: Result
     */
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    public Result deleteCategories(@RequestBody @Validated List<Long> categoryIds){
        return new Result(categoryService.deleteCategories(categoryIds));
    }
    /**
     * query categories
     *
     * @description: query categories
     * @param: Long libraryId,Long parentId
     * @return: Result
     */
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Result queryCategories(Long libraryId,Long parentId){
        return new Result(categoryService.queryCategories(libraryId, parentId));
    }
}
