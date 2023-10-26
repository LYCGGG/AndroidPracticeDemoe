package com.lyc.kotlindemo.service

import android.os.AsyncTask

class DownloadTask : AsyncTask<Unit, Int, Boolean>() {
    override fun doInBackground(vararg params: Unit?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
    }
}