package com.lyc.daggerdemo.daggertest.module;

import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object3;

import dagger.Module;
import dagger.Provides;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/21
 * @Version:
 * @Descrpition:
 */
@Module
public class TestSubModule2 {
    @Provides
    Test_Sub_Object3 provideTestSubObject3(){
        return new Test_Sub_Object3();
    }
}
