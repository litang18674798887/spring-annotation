package com.lt.service;


import com.lt.dao.BooKDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BookService {


//    @Qualifier("bookDao")
//    @Autowired(required = false)

//    @Resource
    @Inject
    private BooKDao booKDao;


    public void print(){
        System.out.println(booKDao);
    }
}
