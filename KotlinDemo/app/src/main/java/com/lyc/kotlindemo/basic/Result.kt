package com.lyc.kotlindemo.basic

import java.lang.Exception
import java.lang.IllegalArgumentException

// 封闭类

sealed class Result {
}

class Success(val msg : String) : Result()
class Failure(val error : Exception) : Result()


fun getResultMsg(result: Result) = when(result) {
    is Success -> result.msg
    is Failure -> result.error.message
}