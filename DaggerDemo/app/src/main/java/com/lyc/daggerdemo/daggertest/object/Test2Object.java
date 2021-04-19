package com.lyc.daggerdemo.daggertest.object;

import javax.inject.Inject;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/16
 * @Version:
 * @Descrpition:
 */

//因为使用Module+Provide，就不需要Inject了
//    瞎扯，
public class Test2Object {
    @Inject
    public Test2Object() {
    }

    int x;

    public void setX(int X){
        this.x = X;
    }

    public int getX(){
        return this.x;
    }
}
