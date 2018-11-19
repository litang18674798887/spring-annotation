package com.lt.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加载ioc容器中，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Component
public class Boss {


    private Car car;

    /**
     * 构造器
     * @param car
     */
    @Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss的有参构造器");
    }

    public Car getCar() {
        return car;
    }

    @Autowired //标注在方法：Spring容器在创建对象，就会调用方法，完成赋值
    //方法使用的参数，自定义类型的值从IOC容器中进行获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
