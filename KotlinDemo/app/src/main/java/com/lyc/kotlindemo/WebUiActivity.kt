package com.lyc.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import com.lyc.kotlindemo.web.App
import com.lyc.kotlindemo.web.AppService
import kotlinx.android.synthetic.main.activity_web_ui.*
import kotlinx.android.synthetic.main.activity_web_ui.view.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.thread

class WebUiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_ui)

//        webview.settings.javaScriptEnabled = true
//        webview.webViewClient = WebViewClient()
//        webview.loadUrl("https://www.baidu.com")

//        testOkHttp()

//        getData_btn.setOnClickListener {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("http://localhost/get_data.xml")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            val appService = retrofit.create(AppService::class.java)
//            appService.getAppData().enqueue(object : Callback<List<App>> {
//                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
//                    val list = response.body()
//                    if (list != null) {
//                        println(list.toString())
//                        for (app in list) {
//                            Log.i("LYCGGG", "onResponse: id is ${app.id}")
//                            Log.i("LYCGGG", "onResponse: id is ${app.name}")
//                            Log.i("LYCGGG", "onResponse: id is ${app.version}")
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<List<App>>, t: Throwable) {
//                    t.printStackTrace()
//                }
//            })
//        }

        getData_btn.setOnClickListener {
            // getWebDataByHttp() √
            // getWebDataByOkHttp() √
            getWebDataByRetrofit()
        }
    }

    private fun getWebDataByRetrofit() {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val appService = retrofit.create(AppService::class.java)
        appService.getAppData().enqueue(object : Callback<List<App>> {
            override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
                val list = response.body()
                if (list != null) {
                    for (app in list) {
                        println("id is ${app.id}")
                        println("name is ${app.name}")
                        println("version is ${app.version}")
                    }
                }
            }

            override fun onFailure(call: Call<List<App>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun getWebDataByOkHttp() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                        .url("http://10.0.2.2/get_data.xml")
//                        .url("https://www.lycgg.xyz")
                        .build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                if (responseData != null) {
//                    showResponse(responseData)
                    parseXMLWithPull(responseData)
                }
            } catch ( e : Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun parseXMLWithPull(xmlData: String) {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val xmlPullParser = factory.newPullParser()
            xmlPullParser.setInput(StringReader(xmlData))
            var eventType = xmlPullParser.eventType
            var id = ""
            var name = ""
            var version = ""
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val nodeName = xmlPullParser.name
                when(eventType) {
                    XmlPullParser.START_TAG -> {
                        when(nodeName) {
                            "id" -> id = xmlPullParser.nextText()
                            "name" -> name = xmlPullParser.nextText()
                            "version" -> version = xmlPullParser.nextText()
                        }
                    }
                    XmlPullParser.END_TAG -> {
                        if ("app" == nodeName) {
                            println("id is $id")
                            println("name is $name")
                            println("version is $version")

                        }
                    }
                }
                eventType = xmlPullParser.next()
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    private fun getWebDataByHttp(){
        thread {
            var connection : HttpsURLConnection? = null
            try {
                val response = StringBuilder()
                val url = URL("http://localhost/get_data.xml")
                connection = url.openConnection() as HttpsURLConnection
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                val input = connection.inputStream
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine { response.append(it) }
                }
                showResponse(response.toString())
            } catch (e : Exception) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }
        }
    }

    private fun showResponse(responseData: String) {
        Log.i("LYCGGGG", "showResponse:  " + responseData.toString())
    }

    private fun testOkHttp() {
        thread {
            val client = OkHttpClient()
            val builder = Request.Builder()
                .url("https://www.lycgg.xyz")
            val request = builder.build()
            val response = client.newCall(request).execute()
            val responseData = response.body?.string()
            println("$responseData")
        }
    }
}