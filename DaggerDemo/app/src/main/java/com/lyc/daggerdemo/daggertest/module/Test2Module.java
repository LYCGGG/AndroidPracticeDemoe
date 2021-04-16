package com.lyc.daggerdemo.daggertest.module;

import com.lyc.daggerdemo.daggertest.object.Test2Object;

import dagger.Module;
import dagger.Provides;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/16
 * @Version:
 * @Descrpition:
 */
@Module
public class Test2Module {
//    这就是一个类了
    @Provides
    public Test2Object ProvideTest2Object(){
        return new Test2Object();
    }
}
