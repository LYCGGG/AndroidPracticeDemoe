package com.lyc.kotlindemo.generics

// 泛型类
//为什么要使用泛型方法呢？因为泛型类要在实例化的时候就指明类型，如果想换一种类型，不得不重新new一次，可能不够灵活；而泛型方法可以在调用的时候指明类型，更加灵活。
//为什么使用泛型类呢？使用泛型类可以解决重复业务的代码的复用问题，也就是业务颗粒的复用，同时使用泛型
//类型在编译阶段就可以确定，并发现错误，类型的转换都是自动和隐士的，提高了代码的准确率和复用率。
class MyClass<T> {
    fun method(param : T) : T {
        return param
    }
}

class MyClass1 {
    // 泛型方法
    fun <T>method(param : T) {

    }
}