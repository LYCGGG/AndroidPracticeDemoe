package com.lyc.annotationdemo;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/4/29
 * @Version:
 * @Descrpition:
 */

import android.app.Activity;
import android.view.View;

import com.lyc.annotationdemo.inject.MyClick;
import com.lyc.annotationdemo.inject.MyInject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/***********注解处理器***************/
public class MyViewUtils {
    public static void inject(final Activity activity){
        //反射属性
        Field[] declaredFields = activity.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            MyInject annotation = field.getAnnotation(MyInject.class);
            if (annotation!=null) {
                int id = annotation.value();
                View view = activity.findViewById(id);
                try {
                    field.set(activity, view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //反射方法
        Method[] declaredMethods = activity.getClass().getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            final Method method = declaredMethods[i];
            method.setAccessible(true);
            MyClick annotation = method.getAnnotation(MyClick.class);
            if (annotation!=null) {
                int[] value = annotation.value();
                for (int j : value) {
                    int id = j;
                    final View btn = activity.findViewById(id);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.invoke(activity, btn);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }
}
