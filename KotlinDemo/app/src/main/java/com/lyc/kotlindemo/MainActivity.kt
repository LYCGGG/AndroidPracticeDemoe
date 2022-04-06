package com.lyc.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mehtodTest()
    }

    private fun mehtodTest() {
        var clazz = Class1("MainA1", 1)

    }
}