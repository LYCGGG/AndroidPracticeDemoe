package com.lyc.daggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lyc.daggerdemo.daggertest.component.DaggerTest2Component;
import com.lyc.daggerdemo.daggertest.object.Test2Object;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LYCRA";

//    @Inject
//    Test1Object test1Object;
//  通过声明这个注入对象，下面的Dagger就可以将MainActivity注入进去了

    @Inject
    Test2Object test2Object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerTest1Component.builder().build().inject(this);
//        需要注意这里是无论如何也实现不了inject方法的，那么问题来了，这里有什么用呢？
//        有用，请看上面的@Inject,之前是缺少了注入的目标，
//        查询inject方法发现，它最终会在DaggerTest1Component中调用MainActivity_MembersInjector.injectTest1Object(instance, new Test1Object());
//        这种来将MainActivity中的Test1Object赋值。

        DaggerTest2Component.builder().build().inject(this);
//        经过上面的注入之后，就可以正常的调用其中的方法了
        test2Object.setX(10);
        Log.i(TAG, "onCreate: " + test2Object.getX());
    }
}