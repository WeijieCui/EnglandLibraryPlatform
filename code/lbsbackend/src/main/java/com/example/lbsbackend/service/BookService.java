package com.example.lbsbackend.service;

import com.example.lbsbackend.entity.Book;

import java.util.List;

/**
 * BookService
 *
 * @description: book service
 */
public interface BookService {
    /**
     * query books
     *
     * @description: query books
     * @param: Long categoryId, String keyword
     * @return: List<Book>
     */
    List<Book> queryBooks(Long categoryId, String keyword);

    /**
     * query books by ids
     *
     * @description: query books by ids
     * @param: List<Long> ids
     * @return: List<Book>
     */
    List<Book> queryBookByIds(List<Long> ids);

    /**
     * batch add books
     *
     * @description: batch add books
     * @param: List<Book> books
     * @return: success
     */
    Boolean addBooks(List<Book> books);

    /**
     * batch delete books
     *
     * @description: batch delete books
     * @param: List<Long> ids
     * @return: success
     */
    Boolean deleteBooks(List<Long> ids);
}
