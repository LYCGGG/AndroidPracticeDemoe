package com.lyc.kotlindemo.generics

import kotlin.reflect.KProperty

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
    val y by lazy {
        val x = "abc"
        x
    }
    // 泛型方法
    fun <T>method(param : T) {

    }

    // 委托属性
    var p by Delegate()
}
// 委托属性的标准模板
class Delegate {
    var propValue : Any? = null
    operator fun getValue(myClass1: MyClass1, property: KProperty<*>): Any? {
        return propValue
    }

    operator fun setValue(myClass1: MyClass1, property: KProperty<*>, any: Any?) {
        propValue = any
    }

}

// 委托模式，就是一个对象将处理委托给另一个对象处理
interface Base {
    fun print()
}
class BaseImp(val x : Int) : Base{
    override fun print() {
        println(x)
    }
}
// 这就是委托模式的实现，借助于by关键字可以省略直接的委托代码
class Test(val base: Base) : Base by base{

}

// 如何自己实现lazy函数
class Later<T>(val  block: () -> T) {
    var value : Any? = null
    operator fun getValue(any: Any?, property: KProperty<*>) : T {
        if (value == null) {
            value = block()
        }
        return value as T
    }
}

fun <T> later(block: () -> T) = Later(block)
// 这样就相当于lazy， 可以val p by later { ... }