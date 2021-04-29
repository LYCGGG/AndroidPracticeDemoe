package com.lyc.annotationdemo.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/29
 * @Version:
 * @Descrpition:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyInject {
    int value();
}
