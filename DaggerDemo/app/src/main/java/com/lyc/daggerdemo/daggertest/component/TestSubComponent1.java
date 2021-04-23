package com.lyc.daggerdemo.daggertest.component;

import com.lyc.daggerdemo.MainActivity;
import com.lyc.daggerdemo.daggertest.module.TestSubModule;
import com.lyc.daggerdemo.daggertest.module.TestSubModule2;
import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object;

import dagger.Component;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/21
 * @Version:
 * @Descrpition:
 */
@Component(modules = {
        TestSubModule.class
})
public interface  TestSubComponent1 {
//    TestSubComponent2 addSub(TestSubModule2 testSubModule2);
}
