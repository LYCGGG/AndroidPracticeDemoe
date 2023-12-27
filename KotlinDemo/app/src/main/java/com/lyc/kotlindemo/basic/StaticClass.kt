package com.lyc.kotlindemo.basic

import java.lang.StringBuilder

class StaticClass {
    // Kotlin中对于静态方法和静态类的概念非常弱，而取而代之的是companion这个伴生类的概念
    companion object {
        // 这样就可以直接调用 类名.doSomething方法，看上去非常像静态，而且只针对这一个方法
        fun doSomething(){
            println("Static do something")
        }

        @JvmStatic
        fun doSomething2() {
            // j这个注解表明这是真正的静态方法
            // 该注解只能加在单例类和companion方法中
        }
    }

    // 备注:如果是单例类，则所有方法都是类似于静态的方法
    // 备注:如果一定要使用真正的静态方法，可以使用注解和顶层的方法


    //标准函数
    // with方法有两个参数，第一个参数可以是任意对象，第二个是Lambda表达式，并且最后一行的结果作为返回值(这点和Kotlin的其他语法糖都一样)
    fun withFunction() {
        val result = with(StringBuilder()) {
            append("Test With Function")
            for (i in 1 .. 10) {
                append("value is $i").append("\n")
            }
            toString()
        }
        println(result)
    }

    // run方法和with差不多
    fun runFunction() {
        val  result = StringBuilder().run {
            append("Test With Function")
            for (i in 1 .. 10) {
                append("value is $i").append("\n")
            }
            toString()
        }
//        println(result)
//        println(result is String) // 此处提示就是true
    }

    // apply方法也是类似的，但不一样的是apply没有指定返回值，只是会自动返回调用对象本身
    fun applyFunction() {
        val result = StringBuilder().apply {
            append("Test With Function")
            for (i in 1 .. 10) {
                append("value is $i").append("\n")
            }
        }
        // 此时的result是个StringBuilder类型的对象
//        println(result.toString())
//        println(result is StringBuilder) // 此处提示就是true
    }
}

fun main() {
    val test = StaticClass()
//    test.withFunction()
    test.runFunction()
    test.applyFunction()
}

// 所谓顶层方法都是写在最外层的方法，也可以说是没有定义在任何类中的方法
// 这个方法就是顶层方法
fun doSomething3() {

}