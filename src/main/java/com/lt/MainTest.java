package com.lt;

import com.lt.bean.Person;
import com.lt.config.MyConfig;
import com.lt.config.MyConfig2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {
       /* ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person persn = (Person) context.getBean("person");
        System.out.println(persn);*/

       ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig2.class);
        Person bean = context.getBean(Person.class);
        System.out.println(bean);

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

    }
}
