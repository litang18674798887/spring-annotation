package com.lt.test;

import com.lt.bean.Blue;
import com.lt.bean.Person;
import com.lt.config.MyConfig;
import com.lt.config.MyConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class IOCTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

    @Test
    public void testImport(){
        printBeans(context);

        //工厂Bean获取的时调用getObject创建对象
       /* Object bean = context.getBean("colorFactoryBean");
        Object bean2 = context.getBean("colorFactoryBean");
        Object bean3 = context.getBean("colorFactoryBean");
        System.out.println(bean == bean2);*/

        Object bean4 = context.getBean("&colorFactoryBean");
        System.out.println(bean4);
    }

    private void printBeans(ApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);

        }
    }

    @Test
    public void test01(){

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
//            System.out.println(name);

        }

        Person person = (Person) context.getBean("person");
//        Person person2 = (Person) context.getBean("person");
//        System.out.println(person == person2);
    }

    @Test
    public void test03(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("-------------- --");

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);

        System.out.println("----------------");

        Environment environment = context.getEnvironment();
        //获取环境变量的值
        String property = environment.getProperty("os.name");
        System.out.println(property);

    }
}
