package com.lyc.activitytestdemo;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.lyc.activitytestdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //    居然忘记了这个必须要写的，新手必备的AndroidDemo----用来确认Android生命周期的
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: before super onCreate");
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: after super onCreate");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
//        以上都是系统自动生成，与目前的Demo的作用无关紧要。
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: before super onResume");
        super.onResume();
        Log.i(TAG, "onResume: after super onResume");
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart: before super onStart");
        super.onStart();
        Log.i(TAG, "onStart: after super onStart");
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: before super onStop");
        super.onStop();
        Log.i(TAG, "onStop: after super onStop");
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart: before onRestart");
        super.onRestart();
        Log.i(TAG, "onRestart: after onRestart");
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: before onDestroy");
        super.onDestroy();
        Log.i(TAG, "onDestroy: after onDestroy");
    }
}