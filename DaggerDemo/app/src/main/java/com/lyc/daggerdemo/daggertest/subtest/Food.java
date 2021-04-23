package com.lyc.daggerdemo.daggertest.subtest;

import javax.inject.Inject;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/23
 * @Version:
 * @Descrpition:
 */
public class Food {
    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Inject
    public Food() {
    }
}
