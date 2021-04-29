package com.lyc.annotationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lyc.annotationdemo.inject.MyClick;
import com.lyc.annotationdemo.inject.MyInject;

public class MainActivity extends AppCompatActivity {

    @MyInject(R.id.ok)
    Button ok_Btn;
    @MyInject(R.id.cancel)
    Button cancel_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyViewUtils.inject(this);
    }

    @MyClick({R.id.ok, R.id.cancel})
    public void submit(View view){
        Toast.makeText(this, ((Button)view).getText(), Toast.LENGTH_SHORT).show();
    }

}