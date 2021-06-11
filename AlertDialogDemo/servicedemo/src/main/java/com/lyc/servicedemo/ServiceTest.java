package com.lyc.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

public class ServiceTest extends Service implements Runnable{
    private static final String TAG = "LYC Service";
    static Looper mServiceLooper;

    public ServiceTest() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Thread serviceThread = new Thread(null,this,"APP Service");

        serviceThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "onCreate: " + Thread.currentThread().getName());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(TAG, "onStart: " + Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        Log.i(TAG, "onStartCommand: " + intent.getExtras());
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {
        Looper.prepare();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("TAG", "onCreate: " + Thread.currentThread().getName());
        mServiceLooper = Looper.myLooper();

        Looper.loop();
    }
}