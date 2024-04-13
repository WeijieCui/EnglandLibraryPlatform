package com.example.lbsbackend.controller;

import com.example.lbsbackend.dto.AddBookDto;
import com.example.lbsbackend.entity.Book;
import com.example.lbsbackend.service.BookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    public Boolean addBooks(@RequestBody @Validated List<AddBookDto> bookDtos){
        return bookService.addBooks(AddBookDto.batchConvertToBook(bookDtos));
    }
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    public Boolean deleteBooks(@RequestBody List<Long> bookIds){
        return bookService.deleteBooks(bookIds);
    }
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public List<Book> queryBooks(Long categoryId, String keyword){
        return bookService.queryBooks(categoryId, keyword);
    }
}
