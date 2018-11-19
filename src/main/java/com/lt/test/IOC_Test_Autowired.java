package com.lt.test;

import com.lt.bean.Boss;
import com.lt.bean.Car;
import com.lt.config.MyConfigAutowireed;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC_Test_Autowired {


    @Test
    public void test01(){
        //创建IOC容器
        ApplicationContext context =new AnnotationConfigApplicationContext(MyConfigAutowireed.class);

        Boss bean = context.getBean(Boss.class);

        Car bean1 = context.getBean(Car.class);




    }
}
