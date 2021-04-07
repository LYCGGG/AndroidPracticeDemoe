package com.lyc.daggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lyc.daggerdemo.object.HttpObject;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LYCRA";

    @Inject
    HttpObject httpObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerMyComponent.create().injectMyActivity(this);
        DaggerMyComponent
                .builder()
                .httpModule(new HttpModule())
                .build()
                .injectMyActivity(this);
        Log.i(TAG, "onCreate: " + httpObject.hashCode());
    }
}