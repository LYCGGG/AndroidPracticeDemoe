package com.lyc.kotlindemo.web

import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread

object HttpUtil {
    fun sendHttpRequest (address : String, callback : okhttp3.Callback) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(address)
            .build()
        client.newCall(request).enqueue(callback)
    }
}