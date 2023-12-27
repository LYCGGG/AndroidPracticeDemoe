package com.lyc.kotlindemo.basic

// infix函数是Kotlin的一种语法糖特性，mapOf中使用的to写法就是利用了这个函数
class InfixLearning {
    val a = mapOf(
            1 to "A"
    )
    // public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
    infix fun String.beginsWith(prefix : String) = startsWith(prefix)
    infix fun <T> Collection<T>.has(element : T) = contains(element)
    fun test() {
        // 注意这里的beginsWith正是和to的用法是一致的
        if ("AAA" beginsWith  "BBB") {
            // ...
        }

        val list = listOf("Banana")
        if (list.contains("Banana")) {
            println("OK")
        }
        // ===
        if (list has "Banana") {
            println("OK2")
        }
    }

    // infix有一些限制:
    // 不能定义成顶层函数，可以使用拓展函数的方式将其定义到某个类中(上面就是String的拓展函数，只不过拓展函数的实现还是使用的String类的startWith方法而已)
    // infix函数必须且只能接收一个参数，但是对于参数类型没有限制
}
// 总结，infix也只是把函数调用的语法规则进行了调整，使其更符合阅读习惯而已