package com.lyc.kotlindemo.basic


// 学习拓展函数
// 拓展函数的意思是在不修改某个类(如String)的源码的情况下，对这个类添加新的函数，使得调用时就像调用这个类的方法一样
class SpreadFun(var value: Int) {

    // 运算符重载
    operator fun plus(spreadFun: SpreadFun) : SpreadFun {
        this.value = spreadFun.value + this.value
        return this
    }

    // 也可以和其他类型做运算
    operator fun plus(value: Int) : SpreadFun {
        this.value = value + this.value
        return this
    }
}

// 给String添加拓展方法，计算字母的数量
fun String.letterCount() : Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}