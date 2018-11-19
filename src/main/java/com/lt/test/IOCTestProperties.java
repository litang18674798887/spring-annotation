package com.lt.test;

import com.lt.bean.Person;
import com.lt.config.MyConfigOfProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class IOCTestProperties {




    /**
     * 1.使用命令行动态参数:在虚拟机参数位置加载 -Dspring.profiles.active=test
     * 2.
     */
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

        printBeans(applicationContext);

        Person person = (Person) applicationContext.getBean("person");

        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println("property = " +property );
        System.out.println(person);


    }

    private void printBeans(ApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);

        }
    }

}
