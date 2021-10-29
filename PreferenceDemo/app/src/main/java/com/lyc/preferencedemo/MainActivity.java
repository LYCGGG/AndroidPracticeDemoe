package com.lyc.preferencedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends PreferenceActivity {
    private final String TAG = getClass().getSimpleName();
    private final String key_main_category_str = "key_main_category";
    private final String key_first_preference_button_str = "key_first_preference_button";
    private final String key_list_preference = "key_list_preference";
    private final String key_switch_preference = "key_switch_preference";
    private final String key_edit_preference = "key_edit_preference";

    private PreferenceScreen mainPreferenceScreen;
    private PreferenceCategory firstPreferenceCategory;
    private Preference firstPreference;
    private ListPreference mListPreference;
    private SwitchPreference mSwitchPreference;
    private EditTextPreference mEditTextPreference;

    private String editReturnStr ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        首先就要注意到使用的是xml文件夹,生成布局文件时选择xml文件夹才会有PreferenceScreen的提示，在layout文件夹中会显示错误
        addPreferencesFromResource(R.xml.preference_main);
        init();
        FirstPreference();
        ListPreference();
        SwitchPreference();
        EditPreference();
    }

    private void init() {
        mainPreferenceScreen = getPreferenceScreen();
    }

    private void FirstPreference() {
        firstPreferenceCategory = (PreferenceCategory) findPreference(key_main_category_str);
        firstPreference = findPreference(key_first_preference_button_str);
//      一般Preference的点击事件
        firstPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Log.i(TAG, "onPreferenceClick: first preference ok");
                Toast.makeText(MainActivity.this, "第一个Category的简单点击事件: OK", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
   }

    private void ListPreference() {
        mListPreference = (ListPreference) findPreference(key_list_preference);
        mListPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                if (preference.getKey() == mListPreference.getKey()) {
                    Log.i(TAG, "onPreferenceClick: true");
                }
                return false;
            }
        });
//        OnPreferenceChangeListener应该是点击之后的事件响应，Object o则是点击对应item的值，上面的是点击本身的监听
//        返回值为true时，才会将值写入文件
        mListPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                // o就是对应的值
                Log.i(TAG, "onPreferenceChange: " + o.toString());
                return false;
            }
        });
    }

    private void SwitchPreference() {
        mSwitchPreference = (SwitchPreference) findPreference(key_switch_preference);
//        使用onPreferenceChangeListener来监听状态
        mSwitchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                Log.i(TAG, "onPreferenceChange: " + o.toString());
                return true;
            }
        });
    }

    private void EditPreference() {
        mEditTextPreference = (EditTextPreference) findPreference(key_edit_preference);
//        EditTextPreference默认就是可以点击，有EditDialog弹框的
//        获取EditText的值还是要靠监听onPreferenceChange,EditText依旧在Object o中。
        mEditTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                Log.i(TAG, "onPreferenceChange: " + o.toString());
//                如此将输入的值获取并传到外面的类中，返回true表明这个值会被保存到文件中。
//                如果需要什么操作，那最好还是调用方法
                editReturnStr = o.toString();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}