package com.example.lbsbackend.controller;

import com.example.lbsbackend.dto.AddBookDto;
import com.example.lbsbackend.entity.Book;
import com.example.lbsbackend.response.Result;
import com.example.lbsbackend.service.BookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * BookController
 *
 * @description: BookController
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * batch add books
     *
     * @description: batch add books
     * @param: List<Book>
     * @return: Result
     */
    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    public Result addBooks(@RequestBody @Validated List<AddBookDto> bookDtos){
        return new Result(bookService.addBooks(AddBookDto.batchConvertToBook(bookDtos)));
    }
    /**
     * batch delete books
     *
     * @description: batch delete books
     * @param: List<Long> bookIds
     * @return: Result
     */
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    public Result deleteBooks(@RequestBody List<Long> bookIds){
        return new Result(bookService.deleteBooks(bookIds));
    }
    /**
     * query books
     *
     * @description: query books by categoryId and keyword
     * @param: Long categoryId, String keyword
     * @return: Result
     */
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Result queryBooks(Long categoryId, String keyword){
        return new Result(bookService.queryBooks(categoryId, keyword));
    }
}
