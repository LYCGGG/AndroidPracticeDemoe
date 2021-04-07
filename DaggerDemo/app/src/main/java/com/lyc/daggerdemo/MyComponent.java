package com.lyc.daggerdemo;

import dagger.Component;

/**
 * @author ：LYC
 * @date ：Created in 2021/4/7
 * @version:
 * @description：组件，用于注入对象到其他类中
 */
@Component(modules =
        {
                HttpModule.class
        })
public interface MyComponent {
//    参数不能用多态Object
    void injectMyActivity(MainActivity mainActivity);
}
