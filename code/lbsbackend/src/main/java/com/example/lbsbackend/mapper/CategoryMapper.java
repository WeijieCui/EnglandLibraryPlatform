package com.example.lbsbackend.mapper;

import com.example.lbsbackend.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> queryCategories(@Param("libraryId") Long libraryId, @Param("parentId") Long parentId);
    Integer addCategories(List<Category> categories);
    Integer deleteCategories(List<Long> categoryIds);
}
