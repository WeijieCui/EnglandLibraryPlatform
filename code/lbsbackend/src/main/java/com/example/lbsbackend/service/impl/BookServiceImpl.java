package com.example.lbsbackend.service.impl;

import com.example.lbsbackend.entity.Book;
import com.example.lbsbackend.mapper.BookMapper;
import com.example.lbsbackend.service.BookService;
import com.example.lbsbackend.util.EntityHelper;
import com.example.lbsbackend.util.page.PageRequest;
import com.example.lbsbackend.util.page.PageResult;
import com.example.lbsbackend.util.page.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;
    private final EntityHelper entityHelper;

    public BookServiceImpl(BookMapper bookMapper, EntityHelper entityHelper) {
        this.bookMapper = bookMapper;
        this.entityHelper = entityHelper;
    }

    @Override
    public PageResult queryBooks(Long categoryId, Long libraryId, String keyword, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getCurrent(), pageRequest.getPageSize());
        List<Book> books = bookMapper.queryBooks(categoryId,libraryId, keyword);
        return PageUtil.convertPageResult(new PageInfo<>(books));
    }

    @Override
    public Book queryBookDetail(Long id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Book> queryBookByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        return bookMapper.queryBookByIds(ids);
    }

    @Override
    public Boolean addBooks(List<Book> books) {
        entityHelper.batchCheckEntity(books);
        return bookMapper.addBooks(books) > 0;
    }

    @Override
    public Boolean deleteBooks(List<Long> ids) {
        return bookMapper.deleteBooks(ids) > 0;
    }
}
