package com.lt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 告诉Spring当前类是一个切面类
 */
@Aspect
public class LogAspects {


    /**
     * 1.本类引用
     * 2.其他的切面类引用
     */
    @Pointcut("execution(public int com.lt.aop.MathCalculator.*(..))")
    public void PointCut(){

    }

    /**
     * @Before 在目标方法之前切入，切入点表达式（指定在哪个方法切入）
     */
    @Before("PointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println( joinPoint.getSignature().getName()+"参数列表{"+ Arrays.asList(args) +"}....@Before");
    }

    @After("PointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"除法结束........ @After");
    }

    /**
     * JoinPoint 这个参数一定要出现在参数表的第一位
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "PointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("除法正常返回{"+result +"}.........@AfterReturning");
    }

    @AfterThrowing(value = "PointCut()",throwing = "e")
    public void logException(Exception e){
        System.out.println("除法出现异常.....异常信息{"+ e.toString()+"}........@AfterThrowing");
    }



}
