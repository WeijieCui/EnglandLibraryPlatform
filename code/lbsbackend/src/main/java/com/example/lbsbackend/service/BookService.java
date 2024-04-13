package com.example.lbsbackend.service;

import com.example.lbsbackend.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> queryBooks(Long categoryId, String keyword);

    List<Book> queryBookByIds(List<Long> bookIds);

    Boolean addBooks(List<Book> books);

    Boolean deleteBooks(List<Long> bookIds);
}
