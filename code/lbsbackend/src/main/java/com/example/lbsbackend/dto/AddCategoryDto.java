package com.example.lbsbackend.dto;

import com.example.lbsbackend.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class AddCategoryDto {
    @NotNull
    private Long categoryId;
    @NotNull
    private Long libraryId;
    private Long parentId;
    private String name;
    public static List<Category> batchConvertToCategory(List<AddCategoryDto> dtos){
        List<Category> books = new ArrayList<>();
        dtos.forEach(dto->{
            Category category = new Category();
            BeanUtils.copyProperties(dto,category);
            books.add(category);
        });
        return books;
    }
}
