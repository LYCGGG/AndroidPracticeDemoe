package com.lyc.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lyc.aidldemo.IAdd;
import com.lyc.aidldemo.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText num1, num2;
    private Button btnAdd, btnNonPremitive, btnCall;
    private TextView total;
    protected IAdd addService;
    private String Tag = "Client Application";
    private String serverAppUri = "com.lyc.aidldemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);

        btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(this);

        btnNonPremitive = (Button) findViewById(R.id.btnNonPremitive);
        btnNonPremitive.setOnClickListener(this);

        total = (TextView) findViewById(R.id.total);

        initConnection();
    }

    private void initConnection() {
        if (addService == null) {
            Intent intent = new Intent(IAdd.class.getName());

            intent.setAction("service.calc");

            /*From 5.0 annonymous intent calls are suspended so replacing with server app's package name*/
            intent.setPackage("com.lyc.aidldemo");

            // binding to remote service
            bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            Log.d(Tag, "onServiceConnected: ");
//            addService = IAdd.Stub.asInterface((IBinder) iBinder);
            addService = IAdd.Stub.asInterface(iBinder);


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(Tag, "onServiceDisconnected: ");
            addService = null;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }

    @Override
    public void onClick(View v) {
        if (appInstalledOrNot(serverAppUri)) {
            switch (v.getId()) {
                case R.id.btnAdd:

                    if (num1.length() > 0 && num2.length() > 0 && addService != null) {
                        try {
                            total.setText("");
                            total.setText("Result: " + addService
                                    .addNumbers(Integer.parseInt(num1.getText().toString()),
                                            Integer.parseInt(num2.getText().toString())));


                        } catch (RemoteException e) {
                            e.printStackTrace();
                            Log.d(Tag, "Connection cannot be establish");
                        }
                    }

                    break;

                case R.id.btnNonPremitive:
                    try {
                        List<String> list = addService.getStringList();
                        for (int i = 0; i < list.size(); i++) {
                            Log.d("List Data: ", list.get(i));
                        }

                        List<Person> person = addService.getPersonList();
                        total.setText("\n" + "Custom Object Data");
                        for (int i = 0; i < person.size(); i++) {
                            total.append(
                                    "\n" + "Person Data: " + "Name:" + person.get(i).name + " Age:" + person
                                            .get(i).age);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        Log.d(Tag, "Connection cannot be establish");
                    }
                    break;
                case R.id.btnCall:

                    try {
                        addService.placeCall("1234567890");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } else {
            Toast.makeText(MainActivity.this, "Server App not installed", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed;
        Log.i(Tag, "appInstalledOrNot: " + uri);

        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
//            e.printStackTrace();
        }
        return app_installed;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}