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
    void inject(MainActivity mainActivity);
}
