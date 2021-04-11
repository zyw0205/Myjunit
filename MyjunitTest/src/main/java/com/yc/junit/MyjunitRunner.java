package com.yc.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: reflectionAndAnnotation2
 * @description:
 * @author: 汤僖龙
 * @create: 2021-03-31 20:37
 */
public class MyjunitRunner {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class cls=Class.forName("com.yc.CalculatorTest");
        Method[]ms=cls.getDeclaredMethods();
        List<Method>testMethods=new ArrayList<Method>();
        Method beforMethod=null;
        Method afterMethod=null;
        Method berforeClassMethod=null;
        Method afterClassMethod=null;
        for (Method m:ms){
            if(m.isAnnotationPresent(MyTest.class)){
                testMethods.add(m);
            }
            if (m.isAnnotationPresent(Mybefore.class)){
                beforMethod=m;
            }
            if (m.isAnnotationPresent(MyAfter.class)){
                afterMethod=m;
            }
            if (m.isAnnotationPresent(MyAfterClass.class)){
                afterClassMethod=m;
            }
            if (m.isAnnotationPresent(MyBeforeClass.class)){
                berforeClassMethod=m;
            }
        }
        if (testMethods==null||testMethods.size()<=0){
            throw new RuntimeException("没有测试的方法");
        }
        Object o=cls.newInstance();
        berforeClassMethod.invoke(o,null);
        for (Method m:testMethods){
            if(beforMethod!=null){
                beforMethod.invoke(o,null);
            }
            m.invoke(o,null);
            if (afterMethod!=null){
                afterMethod.invoke(o,null);
            }
        }
       afterClassMethod.invoke(o,null);
    }
}
