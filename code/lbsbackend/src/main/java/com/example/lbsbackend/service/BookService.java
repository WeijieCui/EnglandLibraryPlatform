package com.example.lbsbackend.service;

import com.example.lbsbackend.entity.Book;
import com.example.lbsbackend.util.page.PageRequest;
import com.example.lbsbackend.util.page.PageResult;

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
     * @param: Long categoryId, Long libraryId, String keyword, PageRequest
     * @return: List<Book>
     */
    PageResult queryBooks(Long categoryId, Long libraryId, String keyword, PageRequest pageRequest);
    /**
     * queryBookDetail
     *
     * @description: queryBookDetail
     * @param: Long id
     * @return: Book
     */
    Book queryBookDetail(Long id);

    /**
     * query books by ids
     *
     * @description: query books by ids
     * @param: List<Long> ids, PageRequest pageRequest
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
