
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Medium implements Parcelable{

    @SerializedName("url")
    private String mUrl;

    protected Medium(Parcel in) {
        mUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Medium> CREATOR = new Creator<Medium>() {
        @Override
        public Medium createFromParcel(Parcel in) {
            return new Medium(in);
        }

        @Override
        public Medium[] newArray(int size) {
            return new Medium[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
