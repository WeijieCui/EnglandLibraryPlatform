package com.example.lbsbackend.mapper;

import com.example.lbsbackend.entity.BookPrinting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookPrintingMapper {
    List<BookPrinting> queryBookPrintings(Long libraryId, Long bookId);

    List<BookPrinting> queryBookPrintingByIds(List<Long> ids);
    BookPrinting queryBookPrintingById(Long id);

    Integer addBookPrintings(List<BookPrinting> bookPrintings);

    Integer deleteBookPrintings(List<Long> ids);
}
