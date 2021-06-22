package com.lyc.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LYC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,ServiceTest.class);
        Bundle bundle1 = new Bundle();
        bundle1.putString("test1","test-service");
        intent.putExtras(bundle1);
        startService(intent);


        Intent intent1 = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("test","test-value");
        intent1.putExtras(bundle);
        Log.i(TAG, "onCreate: intent test " + intent1.getExtras());
        Log.i(TAG, "onCreate: " + Thread.currentThread().getName());

        ParcelTest parcelTest = new ParcelTest("test",1, 1.223f,true,"wc");
    }
}