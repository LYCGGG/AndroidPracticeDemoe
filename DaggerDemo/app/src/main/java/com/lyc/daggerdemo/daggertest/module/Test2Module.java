package com.lyc.daggerdemo.daggertest.module;

import com.lyc.daggerdemo.daggertest.object.BaseTestObject;
import com.lyc.daggerdemo.daggertest.object.Test2Object;
import com.lyc.daggerdemo.daggertest.object.Test3Object;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/16
 * @Version:
 * @Descrpition:
 */
@Module
public abstract class Test2Module {
//    这就是一个类了
//    @Provides
//    public static Test2Object ProvideTest2Object(){
//        return new Test2Object();
//    }

//    看样子Binds和Provides是不能共存的

    @Binds
    public abstract BaseTestObject BindsTestObject(Test3Object test3Object);
//    注意传入参数和返回值的关系
}
