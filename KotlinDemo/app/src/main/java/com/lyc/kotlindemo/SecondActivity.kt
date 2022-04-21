package com.lyc.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        println("Second Activity")

        btn_return_first.setOnClickListener {
            val intent = Intent().putExtra("data_return", "Hello FirstActivity")
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}