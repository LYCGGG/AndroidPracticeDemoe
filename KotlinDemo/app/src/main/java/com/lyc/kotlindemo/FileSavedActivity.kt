package com.lyc.kotlindemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_file_saved.*
import java.io.BufferedWriter
import java.io.OutputStreamWriter

class FileSavedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_saved)

        button.setOnClickListener {
            val str = editText.text.toString()
            if (!str.isEmpty()) {
                println(str)
                val output = openFileOutput("data", Context.MODE_PRIVATE)
                val writer = BufferedWriter(OutputStreamWriter(output))
                writer.use {
                    it.write(str)
                }
            }
        }
    }
}