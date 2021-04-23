package com.lyc.daggerdemo.daggertest.subtest;

import dagger.Module;
import dagger.Provides;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/23
 * @Version:
 * @Descrpition:
 */
@Module
public class PackageModule {
    @Provides
    Food ProvideFood(){
        return new Food();
    }
    @Provides
    Cloth ProvideCloth(){
        return new Cloth();
    }
}
