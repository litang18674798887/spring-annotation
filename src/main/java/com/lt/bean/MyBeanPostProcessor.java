package com.lt.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器：初始化前后进行处理工作
 * 将后置处理器加入容器
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * @param bean      刚创建的实例
     * @param beanName  实例在容器中创建的名字
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization............." + beanName + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization.............." + beanName + bean);
        return bean;
    }
}
