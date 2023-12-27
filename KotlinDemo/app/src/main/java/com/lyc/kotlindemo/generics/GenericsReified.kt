package com.lyc.kotlindemo.generics

class GenericsReified {
    // Java的泛型功能是通过类型擦除机制来实现的(之前是这样)
    // Kotlin支持泛型实化功能
    inline fun <reified T> getGenericsType() = T::class.java

    fun test(person: Person) {

    }

    fun test2(persons : List<Person>) {

    }
}

fun main() {
//    val generics = GenericsReified()
//    val result = generics.getGenericsType<String>()
//    println("result is $result")

    val generics = GenericsReified()
    generics.test(Student("Tom",10))// 这样没问题，可以正常转换


    val student = Student("Tom", 20)
    val data = SimpleData<Student>()
    data.set(student)
//    handleSimpleData(data) //此处必然报错，尽管Student是Person的子类，但是data是SimpleData<Student>它不是SimpleData<Person>的子类，更不用说和Student没有直接关系的Teacher了

    val data2 = SimpleData2<Student>(student) // 此处依旧可以采用构造函数的写法
    handleMyData(data2)

    generics.test2(listOf(Student("Tom", 20))) // 这样也没问题，因为Kotlin给很多加了协变
    // public interface List<out E> : Collection<E> {
    // 看源码，此处正是加了out
    // override fun containsAll(elements: Collection<@UnsafeVariance E>): Boolean
    // 最牛的是这里，加入了UnsafeVariance注解，主动声明此处可以引用

    // 逆变
    val trans = object : Transformer<Person> {
        override fun transform(t: Person): String { // 实现
            return "${t.name} ${t.age}"
        }
    }
//    handleTransformer(trans) // 此处报错，错误类型和上面是一样的
    // 但是逻辑上本身是没有问题，逆变就可以解决这个问题
    handleTransformer(trans)
}

fun handleMyData(data2: SimpleData2<Person>) {
    val person = data2.get()
}

fun handleSimpleData(data: SimpleData<Person>) {
    val teacher = Teacher("Jack", 35)
    data.set(teacher)
}

// 协变
open class Person(val name: String, val age : Int)
class Student(name : String, age: Int) : Person(name, age)
class Teacher(name : String, age: Int) : Person(name, age)

class SimpleData<T> {
    private var data : T ?= null
    fun set(t: T?) {
        data = t
    }

    fun get() : T? = data
}

// 这种out声明就是协变的实现，它指明这个只能读取，不能写入，因而也不会有安全隐患
// 但是不能写入不意味着真的不能写入，它可以使用构造函数的方式写入,因而只能声明成val形式
class SimpleData2<out T>(val data : T?) {
    fun get() : T? = data
}


// 泛型的逆变
//interface Transformer<T> {
interface Transformer<in T>{
    fun transform(t: T) : String
}

fun handleTransformer(trans : Transformer<Student>) {
    val student = Student("Jack", 35)
    val result = trans.transform(student)
}


