package com.lyc.preferencedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MainActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        首先就要注意到使用的是xml文件夹,生成布局文件时选择xml文件夹才会有PreferenceScreen的提示，在layout文件夹中会显示错误
        addPreferencesFromResource(R.xml.preference_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}