package com.lyc.kotlindemo.basic

import java.lang.StringBuilder

// 高阶函数，即一个方法作为另一个方法的参数
// fun(x,y, fun1())
class HighLevelFun {
    fun num1AndNum2(num1 : Int, num2 : Int, operation : (Int, Int) -> Int) : Int {
        val value = operation(num1,num2)
        return value
    }

    fun plus(num1: Int, num2: Int) : Int {
        return num1 + num2
    }

    fun StringBuilder.build(block : StringBuilder.() -> Unit ) : StringBuilder {
        block()
        return this
    }

    // 内联函数
    // 一般的函数在调用前会创建一些堆栈寄存器等，就会产生一些开销，因此用内联函数就不会有这种问题
    inline fun addNumber(num1: Int, num2: Int, operation: (Int, Int) -> Int) : Int {
        return operation(num1, num2)
    }

    // 再进一步，一个高阶函数接收了多个函数类型的参数，但是只想内联一个参数，那么就需要对其他参数使用noinline表达式
    inline fun inlineTest(block1 : () -> Unit, noinline block2 : () -> Unit) {

    }

    // 但是非内联函数只能进行局部返回
    fun printString(Str : String, block : (String) -> Unit) {
        println("begin")
        block(Str)
        println("end")
    }

    // 但如果是内联函数，则会直接返回
}

fun main() {
    val highLevelFun = HighLevelFun()
    val result = highLevelFun.num1AndNum2(1, 2, highLevelFun::plus)
    println(result)

    highLevelFun.printString("") {
        println("lambda start")
        if (it.isEmpty()) return@printString
        println("OK") // 此处不会被打印，但是printString的end会被打印
    }
}