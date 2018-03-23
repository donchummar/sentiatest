
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Small implements Parcelable {

    @SerializedName("url")
    private String mUrl;

    protected Small(Parcel in) {
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

    public static final Creator<Small> CREATOR = new Creator<Small>() {
        @Override
        public Small createFromParcel(Parcel in) {
            return new Small(in);
        }

        @Override
        public Small[] newArray(int size) {
            return new Small[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
