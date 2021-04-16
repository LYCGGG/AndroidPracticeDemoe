package com.lyc.daggerdemo.daggertest.component;

import com.lyc.daggerdemo.MainActivity;

import dagger.Component;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/16
 * @Version: 0.1
 * @Descrpition:
 */
@Component
public interface Test1Component {
    //    这里是第一个最简单的Component,它的目的是将类A注入到类B中
//    这是没有@Module的
    void inject(MainActivity mainActivity);
//    这里的结果是创建了两个类：一个是DaggerTest1Component，它继承了这个类，但是对于这个接口中的方法并没有真正实现
//    并且DaggerTest1Component中有一个内部类Builder，有一个方法builder用于创建Builder，然后在这个内部类中创建Test1Component
}
