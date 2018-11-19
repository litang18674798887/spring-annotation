package com.lt.test;

import com.lt.aop.MathCalculator;
import com.lt.config.MyConfigAop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC_Test_AOP {


    @Test
    public void test01(){
        //创建IOC容器
        ApplicationContext context =new AnnotationConfigApplicationContext(MyConfigAop.class);

        MathCalculator mathCalculator = context.getBean(MathCalculator.class);

        mathCalculator.div(10,2);
    }
}
