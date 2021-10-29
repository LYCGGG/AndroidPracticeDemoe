package com.lyc.preferencedemo.custompreference;

import android.content.Context;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.lyc.preferencedemo.R;

// 这是个自定义的EditTextPreference,从中可以看到EditTextPreference还是提供了不少方法供我们配置。
public class CustomEditTextPreference extends EditTextPreference {
    private final String TAG = getClass().getSimpleName();
    private Context mContext;

    public CustomEditTextPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        setDialogLayoutResource(R.layout.edit_dialog_layout);
    }

    public CustomEditTextPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    一个非常离奇的点是这个两个参数的构造方法是必须要有的，如果缺少这个，运行会直接报错。相反的，加了这个就不会有问题，目测是谷歌的BUG(Androidx的报似乎就没有这个问题)
    public CustomEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDialogLayoutResource(R.layout.edit_dialog_layout);
    }

    public CustomEditTextPreference(Context context) {
        super(context);
    }

    @Override
    public void setDialogLayoutResource(int dialogLayoutResId) {
        Log.i(TAG, "setDialogLayoutResource: ");
        super.setDialogLayoutResource(dialogLayoutResId);
    }

    @Override
    protected void onClick() {
        super.onClick();
//        点击事件
    }

//    有一个很有意思的点就在于它们的调用顺序
//    源码也不复杂，想逻辑也不难：首先onCreateView,onBindView跟其他的创建绑定View顺序完全一致
//    点击时调用onClick,里面会调用showDialog方法，其中又会先onCreateDialogView,然后onBindDialogView,然后onBindDialogView中调用了onAddEditTextToDialogView。
    
//    另一个问题，怎么自定义

    @Override
    protected View onCreateView(ViewGroup parent) {
        Log.i(TAG, "onCreateView: 第一，它在这个Preference创建时就被调用");
        return super.onCreateView(parent);
    }

    @Override
    protected void onBindView(View view) {
        Log.i(TAG, "onBindView: 第二，它在Preference创建时被调用");
        Log.i(TAG, "onBindView: 第七，但它在显示Dialog后也会再调用一次");
        super.onBindView(view);
    }

    @Override
    protected void showDialog(Bundle state) {
        Log.i(TAG, "showDialog: 第三，在点击后调用");
        super.showDialog(state);
    }

    @Override
    protected View onCreateDialogView() {
        Log.i(TAG, "onCreateDialogView: 第四，在显示Dialog时调用");
        return super.onCreateDialogView();
    }

    @Override
    protected void onBindDialogView(View view) {
        Log.i(TAG, "onBindDialogView: 第五，在显示Dialog时调用");
        super.onBindDialogView(view);
        EditText editText = getEditText();
        Log.i(TAG, "onBindDialogView: " + editText.getId());
    }

    @Override
    protected void onAddEditTextToDialogView(View dialogView, EditText editText) {
        Log.i(TAG, "onAddEditTextToDialogView: 第六，最后调用");
        super.onAddEditTextToDialogView(dialogView, editText);
        ViewGroup container = dialogView.findViewById(R.id.editLinearLayout);
        if (container != null) {
            container.addView(editText, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public EditText getEditText() {
//        editText得到是源码中默认的Edit，自定义的edit无法覆盖。
        return super.getEditText();
    }



    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);
        Log.i(TAG, "onDialogClosed: " + getText());
    }
}
