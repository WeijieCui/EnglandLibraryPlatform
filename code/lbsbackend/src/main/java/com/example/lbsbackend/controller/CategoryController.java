package com.example.lbsbackend.controller;

import com.example.lbsbackend.dto.AddCategoryDto;
import com.example.lbsbackend.dto.QueryCategoryDto;
import com.example.lbsbackend.response.Result;
import com.example.lbsbackend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/api/category")
@Transactional
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
    public Result addCategories(@RequestBody @Valid List<AddCategoryDto> categoryDtos) {
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
    public Result deleteCategories(@RequestBody @Valid List<Long> categoryIds) {
        return new Result(categoryService.deleteCategories(categoryIds));
    }

    /**
     * query categories
     *
     * @description: query categories
     * @param: QueryBookDto dto
     * @return: Result
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result queryCategories(@RequestBody @Valid QueryCategoryDto dto) {
        return new Result(categoryService.queryCategories(dto.getLibraryId(), dto.getParentId(), dto.getPage()));
    }
}
