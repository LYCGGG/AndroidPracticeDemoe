package com.lyc.kotlindemo.basic

// only open class can be extended
// Kotlin中的类和Java一样，需要有构造函数，但是Kotlin有主构造函数和次构造函数
// 主构造函数可以没有函数体，如果不指明，那么默认就是不带参数的，类似Class1
open class Class1 {
    
}
// 带参数的主构造函数
open class Class2(val name : String, val age : Int) {

}
// 如果想要在主构造函数中加入一些逻辑
open class Class3(val name : String, val age: Int) {
//    constructor() : this("",0)

    init {
        println("name is $name")
        println("age is $age")
    }
}
// java中子类的构造函数必须要调用父类的构造函数
class Class4 : Class1() {
}
class Class5(name: String, age: Int) : Class2(name, age) {
}
// 当然可以在子类的构造函数中加入自己的参数
class Class6(val sno : String, name: String, age: Int) : Class3(name, age) {
    // 次构造函数,通过如下关键字定义
    constructor(name: String, age: Int) : this("", name, age) {
    }
    constructor() : this("",0){}
}

// 特殊情况:类中只有次构造函数，没有显式的的主构造函数
class  Class7 : Class3 {
    // 那么调用的就是默认的父类的主构造函数了
    constructor(name : String, age: Int) : super(name, age)
}

// 接口的继承和实现
class Student(name: String, age: Int) : Class3(name, age) , Study{
    override fun doHomeWork() {
        println("do Home Work ...")
        Thread.sleep(1000)
    }

}


