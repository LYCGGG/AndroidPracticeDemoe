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
    String name;
    int count;
    float price;
    boolean isTrue;
    String info;

    public ParcelTest(String name, int count, float price, boolean isTrue, String info) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.isTrue = isTrue;
        this.info = info;
    }

    protected ParcelTest(Parcel in) {
        name = in.readString();
        count = in.readInt();
        price = in.readFloat();
        isTrue = in.readBoolean();
        info = in.readString();
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
        dest.writeString(this.info);
        dest.writeString(this.name);
        dest.writeInt(this.count);
        dest.writeFloat(this.price);
        dest.writeString(this.info);
    }
}
