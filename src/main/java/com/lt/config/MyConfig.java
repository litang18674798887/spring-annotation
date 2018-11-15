package com.lt.config;


import com.lt.bean.Color;
import com.lt.bean.ColorFactoryBean;
import com.lt.bean.Person;
import com.lt.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类等于以前的配置文件
@Configuration  //告诉spring这是一个配置类

//excludeFilters 排除

/*
@ComponentScan(value ="com.lt",excludeFilters ={
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {
                Controller.class, Service.class
        })
} )*/

@ComponentScan(
        value = "com.lt",
        useDefaultFilters = false,
        includeFilters = {
                //ASSIGNABLE_TYPE   按照给定的类型
                //ANNOTATION        按照注解
                //ASPECTJ           使用ASPECTJ表达式
                //REGEX             使用正则表达式
                //CUSTOM            使用自定义规则
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes ={MyTypeFIlter.class} )
})
public class MyConfig {

    //给容器中注册一个Bean;
    // id 默认是用方法名作为id
    @Bean(value = "person2")
    public Person person01(){
        return new Person("lisi",20);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
