package com.lt.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    //返回一个Color 对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean.....getObject");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是单例吗？
    //true  单实例，在容器中保存一份
    //false 多实例，每次获取都会创建一个新的实例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
