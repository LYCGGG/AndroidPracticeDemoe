package com.lyc.kotlindemo.web

import java.lang.Exception

interface HttpCallbackListener {
    fun onFinish(response : String)
    fun onError(e : Exception)
}