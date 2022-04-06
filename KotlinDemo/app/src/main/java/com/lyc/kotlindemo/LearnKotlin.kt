package com.lyc.kotlindemo

import kotlin.math.max

class LearnKotlin {

//    Kotlin Syntactic Sugar 1 : to test fun and if sentence
    fun largerNumber(num1 : Int, num2 : Int) = max(num1,num2)
//    If Statement has return value
    fun largerNumber2(num1 : Int, num2: Int) : Int {
        return if (num1 > num2) {
            num1
        } else {
            num2
        }
    }

    // to test when
    fun getScore(name : String) : Int {
        return when (name) {
            "TOM" -> 86
            "Jim" -> 77
            "Jack" -> 95
            else -> -1
        }
    }
    // to test TypeMatch
    fun checkNumber(num: Number) {
        when(num) {
            is Int -> println("number is Int")
            is Double -> println("number is Double")
            else -> println("number not support")
        }
    }

    // to test for-in
    fun testForIn() {
        val range = 0..10
        val range1 = 0 until 10
        for (i in 0 until 10) {
            println(i)
        }
        for (i in 0 until 10 step 2) {
            println(i)
        }
        for (i in 10 downTo 1) {
            println(i)
        }
    }
}