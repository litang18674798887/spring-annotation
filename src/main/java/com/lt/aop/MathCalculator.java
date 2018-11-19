package com.lt.aop;

public class MathCalculator {


    public int div (int i,int j){
        System.out.println("div ......");
        System.out.println(1/0);
        return  i / j;
    }

}
