package com.example.bootdemo.util;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Collections;
import java.util.List;


@Aspect
@Component
public class TradeCheckAspectJ {

    @Pointcut("@annotation(com.example.bootdemo.util.TradeCheck)")
    public void ouAspect(){

    }

    @Before("ouAspect()")
    public void beforeMethod(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class[] classes = signature.getParameterTypes();

        //获取到入参
        Parameter[] parameters = method.getParameters();
        int length = parameters.length;
        for (int i = 0; i < length; i++) {
            Parameter parameter = parameters[i];
            ParmOne annotation = parameter.getAnnotation(ParmOne.class);
            if (annotation!=null){
                Class aClass = classes[i];
                System.out.println(getParmsVal(aClass,"id"));
                System.out.println(getParmsVal(aClass,"name"));
            }

        }

    }

    private Object getParmsVal(Class aClass,String key){
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String s = declaredField.getGenericType().toString();
            if (s.contains("java.lang.String")){
                try {
                    return declaredField.get(key);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private boolean getAnnotion(Method method){
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (Annotation[] parameterAnnotation : parameterAnnotations) {

            for (Annotation annotation : parameterAnnotation) {
                if (annotation instanceof ParmOne){
                    System.out.println("　　ａｓｓｓｘ　");
                }
            }

        }
        return false;
    }

}
