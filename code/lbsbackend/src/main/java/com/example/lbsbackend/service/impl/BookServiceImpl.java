package com.example.lbsbackend.service.impl;

import com.example.lbsbackend.entity.Book;
import com.example.lbsbackend.mapper.BookMapper;
import com.example.lbsbackend.service.BookService;
import com.example.lbsbackend.util.EntityHelper;
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
    public List<Book> queryBooks(Long categoryId, String keyword) {
        return bookMapper.queryBooks(categoryId, keyword);
    }

    @Override
    public List<Book> queryBookByIds(List<Long> ids) {
        if (ids ==null || ids.isEmpty()){
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
    public Boolean deleteBooks(List<Long> ids){
        return bookMapper.deleteBooks(ids) > 0;
    }
}
