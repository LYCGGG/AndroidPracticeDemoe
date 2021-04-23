package com.lyc.daggerdemo.daggertest;

import com.lyc.daggerdemo.daggertest.component.DaggerTest1Component;
import com.lyc.daggerdemo.daggertest.component.TestSubComponent1;
import com.lyc.daggerdemo.daggertest.module.TestSubModule;
import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object;
import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object3;

import javax.inject.Inject;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/23
 * @Version:
 * @Descrpition:
 */
public class TestMain {
    @Inject
    Test_Sub_Object test_sub_object;

    @Inject
    Test_Sub_Object3 test_sub_object3;
    public static void main(String[] args) {
        TestSubModule testSubModule = new TestSubModule();
    }
}
