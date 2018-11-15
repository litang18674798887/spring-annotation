package com.lt.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar  implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata   当前类的注解信息
     * BeanDefinitionRegistry   BeanDefinition注册类
     *          把所有需要添加到容器中的bean:调用
     *          BeanDefinitionRegistry.registerBeanDefinition
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean red = registry.containsBeanDefinition("com.lt.bean.Red");

        boolean blue = registry.containsBeanDefinition("com.lt.bean.Blue");

        if (red && blue) {
            //指定Bean的定义信息（Bean的类型。。。。等等）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
            //注册一个Bean 指定Bean名
            registry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }


    }
}
