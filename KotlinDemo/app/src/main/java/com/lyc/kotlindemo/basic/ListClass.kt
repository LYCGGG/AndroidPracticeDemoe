   package com.lyc.kotlindemo.basic

   import com.lyc.kotlindemo.basic.Study
   import java.util.*
   import kotlin.collections.HashMap

class ListClass {
    // 该集合是不可变的，不能增进和删除元素
    val fruitList = listOf("Apple" , "Orange" , "Pear", "Grape")

    var fruitMutList = mutableListOf("Apple", "Orange", "Pear")

    fun addFruit() {
        fruitMutList.add("Watermelon")
    }

    fun printFruit() {
        for (fruit in fruitMutList) {
            println(fruit)
        }
    }

    // Set集合也是类似的，已经有成品的类和方法
    fun setFruitList() {
        val fruitList1 = setOf("Apple", "Orange", "Pear")
    }

    fun mapFruitList() {
        val fruitMap = HashMap<String,Int>()
        fruitMap["Apple"] = 1
        fruitMap["Banana"] = 2
        // 更方便的还有这样
        val map = mapOf("Apple" to 1, "Banana" to 2, "Pear" to 3)
    }

    // lambda API
    fun lambdaFunAPI() {
        val fruitList = listOf("Apple", "Banana", "Orange", "Pear")
        val maxLengthFruit = fruitList.maxBy { it.length }
        // lambda表达式的简化过程
        // ==
        val lambda = {fruit : String -> fruit.length}
        val max = fruitList.maxBy(lambda)
        // ==
        val max1 = fruitList.maxBy({fruit : String -> fruit.length})
        // ==
        val max2 = fruitList.maxBy() {fruit : String -> fruit.length}
        // ==
        val max3 = fruitList.maxBy{fruit -> fruit.length}
        // ==
        val max4 = fruitList.maxBy{ it.length }

        val newList = fruitList.map { it.toUpperCase(Locale.ROOT) }

        val newList1 = fruitList.filter { it.length <= 5 }
                .map { it.toUpperCase(Locale.ROOT) }
    }

    // java 函数式 API
    fun javaFunAPI() {
        Thread(object : Runnable {
            override fun run() {
                println("Thread is running")
            }
        }).start()

        // ==
        Thread(Runnable {
            println("Thread is running 2")
        }).start()

        // ==
        Thread {
            println("Thread is running")
        }.start()
    }

    // 空指针检查
    fun nullPointCheck() {
        // 如果参数可能为空，使用?操作符
        val str = "ABASES"
        println(str?.length)
        // ?: 运算符，用于判空
        val length = str.length ?: 0
        // 如果一个参数一定不为空，使用!!非空断言
        str!!.length
    }

    fun doStudy(study: Study?) {
        study?.doHomeWork()
        // ==
        study?.let { stu ->
            stu.doHomeWork()
        }
    }
}