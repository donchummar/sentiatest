
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Large implements Parcelable{

    @SerializedName("url")
    private String mUrl;

    protected Large(Parcel in) {
        mUrl = in.readString();
    }

    public static final Creator<Large> CREATOR = new Creator<Large>() {
        @Override
        public Large createFromParcel(Parcel in) {
            return new Large(in);
        }

        @Override
        public Large[] newArray(int size) {
            return new Large[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
    }
}
