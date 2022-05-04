package com.lyc.kotlindemo.service

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    val TAG = "LYCGGG"

    private val mBinder = DownloadBinder()

    class DownloadBinder(): Binder() {
        fun startDownload() {
            Log.d("LYCGGG", "startDownload:  startDownload executed")
        }

        fun getProgress() : Int {
            Log.d("LYCGGG", "getProgress: executed")
            return 0
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }
}

// 该类已经被废弃
class MyIntentService(name: String?) : IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        TODO("Not yet implemented")
    }

}