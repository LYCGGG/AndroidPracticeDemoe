package com.lyc.servicedemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/6/10
 * @Version:
 * @Descrpition:
 */
public class ParceTest implements Parcelable {

    protected ParceTest(Parcel in) {
    }

    public static final Creator<ParceTest> CREATOR = new Creator<ParceTest>() {
        @Override
        public ParceTest createFromParcel(Parcel in) {
            return new ParceTest(in);
        }

        @Override
        public ParceTest[] newArray(int size) {
            return new ParceTest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
