package com.example.lbsbackend.service.impl;

import com.example.lbsbackend.entity.BookPrinting;
import com.example.lbsbackend.mapper.BookPrintingMapper;
import com.example.lbsbackend.service.BookPrintingService;
import com.example.lbsbackend.util.EntityHelper;
import com.example.lbsbackend.util.page.PageRequest;
import com.example.lbsbackend.util.page.PageResult;
import com.example.lbsbackend.util.page.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("BookPrintingService")
public class BookPrintingServiceImpl implements BookPrintingService {
    private final BookPrintingMapper bookPrintingMapper;
    private final EntityHelper entityHelper;

    public BookPrintingServiceImpl(BookPrintingMapper bookPrintingMapper, EntityHelper entityHelper) {
        this.bookPrintingMapper = bookPrintingMapper;
        this.entityHelper = entityHelper;
    }

    @Override
    public PageResult queryBookPrintings(Long libraryId,Long bookId, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getCurrent(), pageRequest.getPageSize());
        List<BookPrinting> bookPrintings = bookPrintingMapper.queryBookPrintings(libraryId, bookId);
        return PageUtil.convertPageResult(new PageInfo<>(bookPrintings));
    }

    @Override
    public BookPrinting queryBookPrintingDetail(Long id) {
        return bookPrintingMapper.queryBookPrintingById(id);
    }

    @Override
    public List<BookPrinting> queryBookPrintingByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        return bookPrintingMapper.queryBookPrintingByIds(ids);
    }

    @Override
    public Boolean addBookPrintings(List<BookPrinting> bookPrintings) {
        entityHelper.batchCheckEntity(bookPrintings);
        return bookPrintingMapper.addBookPrintings(bookPrintings) > 0;
    }

    @Override
    public Boolean deleteBookPrintings(List<Long> ids) {
        return bookPrintingMapper.deleteBookPrintings(ids) > 0;
    }
}
