package com.lyc.daggerdemo.daggertest.module;

import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object;
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
    Test_Sub_Object3 provideTestSubObject3(Test_Sub_Object test_sub_object){
        return new Test_Sub_Object3(test_sub_object);
    }
}
