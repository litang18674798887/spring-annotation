package com.lt.config;


import com.lt.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 使用@PropertySourc读取外部配置文件中的K/V保存到运行的环境变量中
 * 加载完外部配置文件以后使用${}取出配置文件中值
 */
@PropertySource(value = {"classpath:/Person.properties"})
@Configuration
public class MyConfigOfPrepertyValues {

    @Bean
    public Person person () {
        return new Person();
    }
}
