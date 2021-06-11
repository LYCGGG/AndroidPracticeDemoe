package com.lyc.servicedemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: “lycmmm@outlook.com”
 * @Date: 2021/6/10
 * @Version:
 * @Descrpition:
 */
public class ParcelTest implements Parcelable {

    protected ParcelTest(Parcel in) {
    }

    public static final Creator<ParcelTest> CREATOR = new Creator<ParcelTest>() {
        @Override
        public ParcelTest createFromParcel(Parcel in) {
            return new ParcelTest(in);
        }

        @Override
        public ParcelTest[] newArray(int size) {
            return new ParcelTest[size];
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
