package com.lt.test;

import com.lt.service.UserService;
import com.lt.tx.TxConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tx_Test {

    @Test
    public void test01(){

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService bean = annotationConfigApplicationContext.getBean(UserService.class);
        bean.inser();
        annotationConfigApplicationContext.close();
    }
}
