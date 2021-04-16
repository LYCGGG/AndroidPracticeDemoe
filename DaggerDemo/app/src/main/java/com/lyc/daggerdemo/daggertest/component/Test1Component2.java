package com.lyc.daggerdemo.daggertest.component;

import com.lyc.daggerdemo.MainActivity;

import dagger.Component;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/16
 * @Version:
 * @Descrpition:
 */
@Component
public abstract class Test1Component2 {
//    首先Component只能被声明成接口或者抽象类。
//    这是一个抽象类，对于这里面已经实现的方法，它是不会再实现的，对于没有实现的方法，也是没有实现的。
    int inject(MainActivity mainActivity) {
        return 1;
    }
}
