package com.lyc.kotlindemo.basic

import com.lyc.kotlindemo.web.HttpUtil
import kotlinx.coroutines.*
import okhttp3.Call
import okhttp3.Response
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

// 学习协程的使用方法
class CoroutinesTest {

    // 将函数声明为挂机函数
    suspend fun printDot(){
        println(".")
        delay(1000)
    }

    // coroutineScope就是一个挂起函数，但是它可以继承外部的协程作用域并创建一个子作用域.
    // 同时它也会阻塞当前协程
    suspend fun printDot2() = coroutineScope {
        launch {
            println(".")
            delay(1000)
        }
    }

    // async可以获取协程内代码的返回值
    fun asyncTest() {
        runBlocking {
            val result = async {
                5+ 6
            }  .await()
            println(result)
        }
        // async就是创建一个协程并启动，并获取返回值
        // await则是在不阻塞线程的情况下等待该值的完成
    }

    fun awaitTest1() {
        runBlocking {
            val result1 = async {
                delay(1000)
                5+5
            }.await()
            val result2 = async {
                delay(1000)
                6+6
            }.await()
            println("result is ${result1} and ${result2}")
            // 这段则是串行
        }
    }

    fun awaitTest2() {
        runBlocking {
            val result1 = async {
                delay(1000)
                5+5
            }
            val result2 = async {
                delay(1000)
                6+6
            }
            println("result is ${result1.await()} and ${result2.await()}")
            // 这段是并行
        }
    }

    // withContext和async类似，但是不同之处在于它要求给出指定的线程，则该协程会运行在指定的线程中(协程不是线程，其本身还是属于主线程，因此类似网络请求的就必须要开启子线程)
    fun withContextTest() {
        runBlocking {
            val result = withContext(Dispatchers.Default) {
                5+5
            }
            println(result)
        }
    }
}

fun main() {
    launch() // 最基础的启动协程
    runBlock() // 协程运行完再结束
}

fun runBlock() {
    runBlocking {
        println("This code run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished.")
    }
    Thread.sleep(1000)
}

fun launch() {
    GlobalScope.launch {
        println("This code run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished.")
    }
    Thread.sleep(1000)
}

// 协程最大的用处:使得回调变得简单易懂
suspend fun request(address : String) : Response {
    val result = suspendCoroutine<Response> {
        continuation -> HttpUtil.sendHttpRequest(address, object : okhttp3.Callback{
            override fun onFailure(call: Call, e: IOException) {
                continuation.resumeWithException(e)
            }

            override fun onResponse(call: Call, response: Response) {
                continuation.resume(response)
            }
        })
    }
    return result
}
