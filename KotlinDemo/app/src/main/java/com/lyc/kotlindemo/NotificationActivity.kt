package com.lyc.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        takePhotoBtn.setOnClickListener {
            takePhoto()
        }
    }

    private fun takePhoto() {

    }
}