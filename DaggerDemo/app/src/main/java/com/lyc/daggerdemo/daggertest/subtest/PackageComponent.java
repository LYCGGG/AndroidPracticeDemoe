package com.lyc.daggerdemo.daggertest.subtest;

import dagger.Component;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/23
 * @Version:
 * @Descrpition:
 */
@Component(modules = PackageModule.class)
public interface PackageComponent {
//    注意是谁依赖谁，这里是提供UserComponent,所以最后生成的也是DaggerPackageComponent
    UserComponent getUserComponent(UserModule userModule);
}
