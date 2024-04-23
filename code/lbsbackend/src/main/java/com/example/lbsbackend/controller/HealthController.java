package com.example.lbsbackend.controller;

import com.example.lbsbackend.response.Result;
import com.example.lbsbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @Description: health check
 **/
@RestController
@RequestMapping("/api/health")
public class HealthController {
    @Autowired
    private BookService bookService;
    /**
     * init
     *
     * @Description: health check: init
     * @Param: null
     * @Return: Result
     **/
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public Result init() {
        return new Result();
    }
    /**
     * ready
     *
     * @Description: health check: ready, with db check
     * @Param: null
     * @Return: Result
     **/
    @RequestMapping(value = "/ready", method = RequestMethod.GET)
    public Result ready() {
        bookService.queryBookByIds(null);
        return new Result();
    }
}
