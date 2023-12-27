package com.lyc.kotlindemo.basic

// Kotlin直接提供一个数据类
data class BookData(val name :  String, val price : Double) {
}
// 也直接提供一个单例模式，都是可以直接使用
object Singleton {}
