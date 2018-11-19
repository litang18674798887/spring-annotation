package com.lt.service;

import com.lt.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void inser(){
        userDao.inser();
        System.out.println("插入完成");
    }
}
