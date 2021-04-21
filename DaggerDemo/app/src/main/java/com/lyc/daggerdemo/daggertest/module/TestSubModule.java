package com.lyc.daggerdemo.daggertest.module;

import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object;
import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object2;

import dagger.Module;
import dagger.Provides;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/21
 * @Version:
 * @Descrpition:
 */
@Module
public class TestSubModule {
    @Provides
    Test_Sub_Object provideSubObject(){
        return new Test_Sub_Object();
    }

    @Provides
    Test_Sub_Object2 provideSubObject2(){
        return new Test_Sub_Object2();
    }
}
