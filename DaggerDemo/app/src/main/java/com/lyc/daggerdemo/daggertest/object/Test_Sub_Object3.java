package com.lyc.daggerdemo.daggertest.object;

import javax.inject.Inject;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/21
 * @Version:
 * @Descrpition:
 */
public class Test_Sub_Object3 {
    private Test_Sub_Object test_sub_object;

    @Inject
    public Test_Sub_Object3(Test_Sub_Object test_sub_object) {
        this.test_sub_object = test_sub_object;
    }
}
