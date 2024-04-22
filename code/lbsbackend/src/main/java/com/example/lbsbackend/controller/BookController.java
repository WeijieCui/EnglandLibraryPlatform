package com.example.lbsbackend.controller;

import com.example.lbsbackend.dto.AddBookDto;
import com.example.lbsbackend.dto.QueryBookDto;
import com.example.lbsbackend.response.Result;
import com.example.lbsbackend.service.BookService;
import jakarta.websocket.server.PathParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BookController
 *
 * @description: BookController
 */
@RestController
@RequestMapping("/api/book")
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
    public Result addBooks(@RequestBody @Validated List<AddBookDto> bookDtos) {
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
    public Result deleteBooks(@RequestBody List<Long> bookIds) {
        return new Result(bookService.deleteBooks(bookIds));
    }

    /**
     * query books
     *
     * @description: query books by categoryId, libraryId and keyword
     * @param: QueryBookDto dto
     * @return: Result
     */
    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public Result queryBooks(@RequestBody QueryBookDto dto) {
        return new Result(bookService.queryBooks(dto.getCategoryId(), dto.getLibraryId(), dto.getKeyword(), dto.getPage()));
    }
    /**
     * query book detail
     *
     * @description: query book detail by categoryId and keyword
     * @param: Long id
     * @return: Result
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Result queryBookDetail(@PathVariable("id") Long id) {
        return new Result(bookService.queryBookDetail(id));
    }
}
