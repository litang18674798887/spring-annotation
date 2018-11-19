package com.lt.test;

import com.lt.config.MyConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    @Test
    public void test01(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1.创建一个applicationContest
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        //3.注册主配置类
        applicationContext.register(MyConfigOfProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

    }
}
