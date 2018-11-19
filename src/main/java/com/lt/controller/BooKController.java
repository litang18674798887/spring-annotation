package com.lt.controller;


import com.lt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BooKController {

    @Autowired
    private BookService bookService;
}
