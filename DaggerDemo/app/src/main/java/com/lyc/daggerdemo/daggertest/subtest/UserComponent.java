package com.lyc.daggerdemo.daggertest.subtest;

import com.lyc.daggerdemo.MainActivity;

import dagger.Component;
import dagger.Subcomponent;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/23
 * @Version:
 * @Descrpition:
 */
//@Component(dependencies = PackageComponent.class,modules = UserModule.class)
//    上面这一套还是不行，就说明这有问题。而下面这Subcomponent就可以,果然是因为Component有问题或者说不是这样用的.
    @Subcomponent(modules = UserModule.class)
public interface UserComponent {
    void inject(MainActivity mainActivity);
}
