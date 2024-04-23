package com.example.lbsbackend.dto;

import com.example.lbsbackend.entity.Book;
import com.example.lbsbackend.enumable.BookPrintingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AddBookDto {
    @NotNull
    private Long categoryId;
    @NotNull
    private Long libraryId;
    @NotNull
    private Long shelfId;
    private String title;
    private String summary;
    private String image;
    private String author;
    private String subject;
    private String format;
    private String publisher;
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishedDate;
    private String language;
    private String country;
    private String isbn;
    private BookPrintingStatus status;
    public static List<Book> batchConvertToBook(List<AddBookDto> dtos){
        List<Book> books = new ArrayList<>();
        dtos.forEach(dto->{
            Book book = new Book();
            BeanUtils.copyProperties(dto,book);
            books.add(book);
        });
        return books;
    }
}
