package com.lyc.alertdialogdemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "LYC";
    private AlertDialog.Builder alertDialogBuilder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBarTest();
        setContentView(R.layout.activity_main);
//        AlertDialogTest();

        AlarmManagerTest();

    }

    private void AlarmManagerTest() {
        startTimeOut();
    }



    private void ActionBarTest() {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setCustomView(R.layout.action_bar_test);
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.hide();

    }

    private void AlertDialogTest() {
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setPositiveButton("OK1", (dialog, which) -> Log.i(TAG, "onClick: OK"));
        alertDialogBuilder.setNegativeButton("Cancel1", (dialog, which) -> Log.i(TAG, "onClick: Cancel"));
        alertDialogBuilder.setOnCancelListener(dialog -> Log.i(TAG, "onCancel: CancelDialog"));
        alertDialogBuilder.setTitle("Title");
        alertDialogBuilder.setMessage("Message");
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialogBuilder.setTitle()
//        alertDialog.show();;

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.stk_msg_dialog,null);
        alertDialogBuilder.setView(dialogView);
        TextView textView = dialogView.findViewById(R.id.message);
        textView.setText(R.string.What);
        ImageView imageView = dialogView.findViewById(R.id.icon);
        imageView.setVisibility(View.GONE);



        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();

//        final Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
//        LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
//        positiveButtonLL.gravity = Gravity.CENTER;
//        positiveButton.setLayoutParams(positiveButtonLL);

        Button btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();
        layoutParams.weight = 10;
        btnPositive.setLayoutParams(layoutParams);
        btnNegative.setLayoutParams(layoutParams);

        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
//        WindowManager m = getWindowManager();
//        Display d = m.getDefaultDisplay(); //为获取屏幕宽、高
        WindowManager.LayoutParams p = alertDialog.getWindow().getAttributes(); //获取对话框当前的参数值
//        p.width = d.getWidth(); //宽度设置为屏幕
        alertDialog.getWindow().setAttributes(p); //设置生效
    }

    private void startTimeOut() {
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        long mAlarmTime = 3000;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String ALARM_TAG = TAG;
        Log.i(TAG, "startTimeOut: alarmManager start");
        am.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,mAlarmTime,ALARM_TAG,mAlarmListener,null);
    }

    private AlarmManager.OnAlarmListener mAlarmListener = 
            new AlarmManager.OnAlarmListener() {
                @Override
                public void onAlarm() {
                    Log.i(TAG, "onAlarm: The alarm time is reached");
                    cancelTimeOut();
                }
            };

    private void cancelTimeOut() {
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        Log.i(TAG, "cancelTimeOut: AlarmManager cancel");
        am.cancel(mAlarmListener);
    }
}