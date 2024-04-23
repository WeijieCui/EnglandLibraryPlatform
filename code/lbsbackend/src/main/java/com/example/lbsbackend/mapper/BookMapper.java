package com.example.lbsbackend.mapper;

import com.example.lbsbackend.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> queryBooks(Long categoryId, Long libraryId, String keyword);

    List<Book> queryBookByIds(List<Long> ids);

    Book queryBookById(Long id);

    Integer addBooks(List<Book> books);

    Integer deleteBooks(List<Long> ids);
}
