package com.lt.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {


    public Dog() {
        System.out.println("dog 构造器");
    }

    //对象创建并复制之后调用
    @PostConstruct
    public void init(){
        System.out.println("dog  构造器执行之后");
    }

    //容器移除之前
    @PreDestroy
    public void detory(){
        System.out.println("dog 被销毁");

    }
}
