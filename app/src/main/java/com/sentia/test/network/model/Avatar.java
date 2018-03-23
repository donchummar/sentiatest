
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Avatar implements Parcelable {

    @SerializedName("large")
    private Large mLarge;
    @SerializedName("medium")
    private Medium mMedium;
    @SerializedName("profile")
    private Profile mProfile;
    @SerializedName("small")
    private Small mSmall;
    @SerializedName("url")
    private String mUrl;

    protected Avatar(Parcel in) {
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

    public static final Creator<Avatar> CREATOR = new Creator<Avatar>() {
        @Override
        public Avatar createFromParcel(Parcel in) {
            return new Avatar(in);
        }

        @Override
        public Avatar[] newArray(int size) {
            return new Avatar[size];
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

    public Profile getProfile() {
        return mProfile;
    }

    public void setProfile(Profile profile) {
        mProfile = profile;
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
