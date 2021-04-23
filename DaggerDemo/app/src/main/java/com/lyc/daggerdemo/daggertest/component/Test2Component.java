package com.lyc.daggerdemo.daggertest.component;

import com.lyc.daggerdemo.MainActivity;
import com.lyc.daggerdemo.daggertest.module.Test2Module;

import dagger.Component;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/16
 * @Version:
 * @Descrpition:
 */
@Component(modules = {
        Test2Module.class
})
public interface Test2Component {
//    void inject(MainActivity mainActivity);
//    着重说明的是，这里也已经说的很清楚，你创建的方法返回值类型和引用参数类型必须一致或者有一定关系
}
