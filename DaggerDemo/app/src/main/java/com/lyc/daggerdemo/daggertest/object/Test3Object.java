package com.lyc.daggerdemo.daggertest.object;

import javax.inject.Inject;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/20
 * @Version:
 * @Descrpition:
 */
public class Test3Object implements BaseTestObject {
    int x;
    String s;

    @Inject
    public Test3Object() {
    }

//    @Inject 这东西既不能加在有参数的构造方法上，也不能在一个类中写两次
    public Test3Object(int x, String s) {
        this.x = x;
        this.s = s;
    }

    @Override
    public void set(int x) {
        this.x = x;
    }

    @Override
    public int get() {
        return this.x;
    }

    @Override
    public void set(String s) {
        this.s = s;
    }

    @Override
    public String getString() {
        return this.s;
    }
}
