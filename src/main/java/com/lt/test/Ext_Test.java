package com.lt.test;

import com.lt.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ext_Test {

    @Test
    public void test01(){

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(ExtConfig.class);

        //发布事件
        annotationConfigApplicationContext.publishEvent(
                new ApplicationEvent(new String ("我发布的事件")) {
        });

        annotationConfigApplicationContext.close();
    }
}
