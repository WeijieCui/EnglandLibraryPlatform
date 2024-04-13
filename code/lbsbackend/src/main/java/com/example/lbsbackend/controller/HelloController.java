package com.example.lbsbackend.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(value = "/sayHello/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name) {
        return String.format("hello, %s", name);
    }
}
