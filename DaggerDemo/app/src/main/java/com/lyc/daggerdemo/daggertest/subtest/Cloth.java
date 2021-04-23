package com.lyc.daggerdemo.daggertest.subtest;

import javax.inject.Inject;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/23
 * @Version:
 * @Descrpition:
 */
public class Cloth {
    int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Inject
    public Cloth() {
    }
}
