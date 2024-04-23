package com.example.lbsbackend.dto;

import com.example.lbsbackend.entity.BookPrinting;
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
public class AddBookPrintingDto {
    private Long bookId;
    @NotNull
    private Long libraryId;
    @NotNull
    private Long shelfId;
    @NotNull
    private Long realLibraryId;
    @NotNull
    private Long realShelfId;
    private BookPrintingStatus status;
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expAvailableDate;
    public static List<BookPrinting> batchConvertToEntity(List<AddBookPrintingDto> dtos){
        List<BookPrinting> books = new ArrayList<>();
        dtos.forEach(dto->{
            BookPrinting bookPrinting = new BookPrinting();
            BeanUtils.copyProperties(dto,bookPrinting);
            books.add(bookPrinting);
        });
        return books;
    }
}
