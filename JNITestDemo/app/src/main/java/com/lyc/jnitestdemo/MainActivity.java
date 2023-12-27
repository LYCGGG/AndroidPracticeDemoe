package com.lyc.jnitestdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.lyc.jnitestdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'jnitestdemo' library on application startup.
    static {
        System.loadLibrary("jnitestdemo");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());

        Test test = new Test();
        String str = test.getStringFromJNI();
        tv.setText(str);
    }

    /**
     * A native method that is implemented by the 'jnitestdemo' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}