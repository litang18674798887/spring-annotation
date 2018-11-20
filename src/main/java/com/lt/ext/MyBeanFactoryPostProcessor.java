package com.lt.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("MyBeanFactoryPostProcessor........postProcessBeanFactory");
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("当前beanFactory 中有几个bean。。。。" + count);
        String[] names = beanFactory.getBeanDefinitionNames();
        System.out.println(Arrays.asList(names));
    }
}
