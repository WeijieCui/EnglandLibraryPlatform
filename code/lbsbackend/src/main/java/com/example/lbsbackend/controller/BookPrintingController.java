package com.example.lbsbackend.controller;

import com.example.lbsbackend.dto.AddBookPrintingDto;
import com.example.lbsbackend.dto.QueryBookPrintingDto;
import com.example.lbsbackend.response.Result;
import com.example.lbsbackend.service.BookPrintingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BookPrintingController
 *
 * @description: BookPrintingController
 */
@RestController
@RequestMapping("/api/bookPrinting")
public class BookPrintingController {
    private final BookPrintingService bookPrintingService;

    public BookPrintingController(BookPrintingService bookPrintingService) {
        this.bookPrintingService = bookPrintingService;
    }

    /**
     * batch add bookPrintings
     *
     * @description: batch add bookPrintings
     * @param: List<BookPrinting>
     * @return: Result
     */
    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    public Result addBookPrintings(@RequestBody @Validated List<AddBookPrintingDto> bookPrintingDtos) {
        return new Result(bookPrintingService.addBookPrintings(AddBookPrintingDto.batchConvertToEntity(bookPrintingDtos)));
    }

    /**
     * batch delete bookPrintings
     *
     * @description: batch delete bookPrintings
     * @param: List<Long> bookPrintingIds
     * @return: Result
     */
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    public Result deleteBookPrintings(@RequestBody List<Long> bookPrintingIds) {
        return new Result(bookPrintingService.deleteBookPrintings(bookPrintingIds));
    }

    /**
     * query bookPrintings
     *
     * @description: query bookPrintings by categoryId and keyword
     * @param: QueryBookPrintingDto dto
     * @return: Result
     */
    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public Result queryBookPrintings(@RequestBody QueryBookPrintingDto dto) {
        return new Result(bookPrintingService.queryBookPrintings(dto.getLibraryId(), dto.getBookId(), dto.getPage()));
    }

    /**
     * query book printing detail
     *
     * @description: query detail by id
     * @param: Long id
     * @return: Result
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Result queryBookPrintingDetail(@PathVariable("id") Long id) {
        return new Result(bookPrintingService.queryBookPrintingDetail(id));
    }
}
