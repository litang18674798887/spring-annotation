package com.lt.bean;

import org.springframework.stereotype.Component;


@Component
public class Car {

    public Car() {
        System.out.println("car 构造器方法调用");
    }

    public void init (){
        System.out.println("car.....init");
    }

    public void detory(){
        System.out.println("car.....detory");
    }
}
