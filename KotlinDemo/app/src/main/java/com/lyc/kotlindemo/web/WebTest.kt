package com.lyc.kotlindemo.web

import retrofit2.Call
import retrofit2.http.GET

class WebTest {
}

class App(val id : String, val name: String, val version : String)

interface AppService {
    @GET("get_data.json")
    fun getAppData() : Call<List<App>>

}