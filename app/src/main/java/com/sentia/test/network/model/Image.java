
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Image implements Parcelable {

    @SerializedName("large")
    private Large mLarge;
    @SerializedName("medium")
    private Medium mMedium;
    @SerializedName("small")
    private Small mSmall;
    @SerializedName("url")
    private String mUrl;

    protected Image(Parcel in) {
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

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public Large getLarge() {
        return mLarge;
    }

    public void setLarge(Large large) {
        mLarge = large;
    }

    public Medium getMedium() {
        return mMedium;
    }

    public void setMedium(Medium medium) {
        mMedium = medium;
    }

    public Small getSmall() {
        return mSmall;
    }

    public void setSmall(Small small) {
        mSmall = small;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
