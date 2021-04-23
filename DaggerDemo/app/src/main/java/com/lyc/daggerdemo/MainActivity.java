package com.lyc.daggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.lyc.daggerdemo.daggertest.component.TestSubComponent1;
import com.lyc.daggerdemo.daggertest.component.TestSubComponent2;
import com.lyc.daggerdemo.daggertest.module.TestSubModule;
import com.lyc.daggerdemo.daggertest.module.TestSubModule2;
import com.lyc.daggerdemo.daggertest.object.Test2Object;
import com.lyc.daggerdemo.daggertest.object.Test3Object;
import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object;
import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object2;
import com.lyc.daggerdemo.daggertest.object.Test_Sub_Object3;
import com.lyc.daggerdemo.daggertest.subtest.Cloth;
import com.lyc.daggerdemo.daggertest.subtest.DaggerPackageComponent;
import com.lyc.daggerdemo.daggertest.subtest.Food;
import com.lyc.daggerdemo.daggertest.subtest.PackageComponent;
import com.lyc.daggerdemo.daggertest.subtest.User;
import com.lyc.daggerdemo.daggertest.subtest.UserModule;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LYCRA";

//    @Inject
//    Test1Object test1Object;
//  通过声明这个注入对象，下面的Dagger就可以将MainActivity注入进去了

//    @Inject
//    Test2Object test2Object;

//    @Inject
//    Test3Object test3Object;
//
//    @Inject
//    Test3Object test3Object2;

//    @Inject
//    Test_Sub_Object test_sub_object;

    @Inject
    Cloth mCloth;

    @Inject
    Food mFood;

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerTest1Component.builder().build().inject(this);
//        需要注意这里是无论如何也实现不了inject方法的，那么问题来了，这里有什么用呢？
//        有用，请看上面的@Inject,之前是缺少了注入的目标，
//        查询inject方法发现，它最终会在DaggerTest1Component中调用MainActivity_MembersInjector.injectTest1Object(instance, new Test1Object());
//        这种来将MainActivity中的Test1Object赋值。

//        DaggerTest2Component.builder().build().inject(this);
//        经过上面的注入之后，就可以正常的调用其中的方法了
//        test2Object.setX(10);
//        Log.i(TAG, "onCreate: " + test2Object.getX());
//        对于Binds绑定注解，是这样用的。

//        DaggerTest2Component.builder().build().inject(this);
//        test3Object.set(10);
//        Log.i(TAG, "onCreate: " + test3Object.get());
//        test3Object.set("what");
//        Log.i(TAG, "onCreate: "+ test3Object.getString());
//        test3Object2.set("sss");
//        Log.i(TAG, "onCreate: " + test3Object2.getString());
//        Log.i(TAG, "onCreate: "+ test3Object.getString());

//        SubComponent用法学习，但是这样创建毫无意义的类太累了，不如设定情景吧。重新再来一个
        UserModule userModule = new UserModule();
        PackageComponent packageComponent = DaggerPackageComponent.builder().build();
        packageComponent.getUserComponent(userModule).inject(this);
        mCloth.setPrice(100);
//        NB成功了
        Log.i(TAG, "onCreate: " + mCloth.getPrice());

    }
}