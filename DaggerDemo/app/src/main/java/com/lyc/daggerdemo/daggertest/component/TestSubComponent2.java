package com.lyc.daggerdemo.daggertest.component;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/21
 * @Version:
 * @Descrpition:
 */
//@Component(dependencies = TestSubComponent1.class, modules = TestSubModule2.class)
//@Component(modules = {TestSubModule2.class},dependencies = {TestSubComponent1.class})
//    用上面失败了，用下面成功了
//    @Subcomponent(modules = TestSubModule2.class)
public interface TestSubComponent2 {
//    void inject(TestMain testMain);
//    void inject(MainActivity mainActivity);
}
