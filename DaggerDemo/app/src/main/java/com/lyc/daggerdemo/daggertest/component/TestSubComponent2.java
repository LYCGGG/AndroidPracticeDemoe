package com.lyc.daggerdemo.daggertest.component;

import com.lyc.daggerdemo.MainActivity;
import com.lyc.daggerdemo.daggertest.TestMain;
import com.lyc.daggerdemo.daggertest.module.TestSubModule;
import com.lyc.daggerdemo.daggertest.module.TestSubModule2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/21
 * @Version:
 * @Descrpition:
 */
//@Component(dependencies = TestSubComponent1.class, modules = TestSubModule2.class)
@Component(modules = {TestSubModule2.class},dependencies = {TestSubComponent1.class})
public interface TestSubComponent2 {
    void inject(TestMain testMain);
}
