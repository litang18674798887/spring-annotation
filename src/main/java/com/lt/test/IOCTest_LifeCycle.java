package com.lt.test;

import com.lt.config.MyConfigLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    @Test
    public void test01(){

        //1.创建IOC容器
        ApplicationContext context =new AnnotationConfigApplicationContext(MyConfigLifeCycle.class);
        System.out.println("容器创建完成.....");


//        Object car = context.getBean("car");

        ((AnnotationConfigApplicationContext) context).close();

    }

}
