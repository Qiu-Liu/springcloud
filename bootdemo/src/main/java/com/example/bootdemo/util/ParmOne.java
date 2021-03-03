package com.example.bootdemo.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER,ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.TYPE_PARAMETER,
            ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParmOne {

}
