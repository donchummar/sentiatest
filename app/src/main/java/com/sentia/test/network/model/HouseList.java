
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HouseList implements Parcelable {

    @SerializedName("data")
    private List<HouseDetails> mData;

    protected HouseList(Parcel in) {
        mData = in.createTypedArrayList(HouseDetails.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mData);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HouseList> CREATOR = new Creator<HouseList>() {
        @Override
        public HouseList createFromParcel(Parcel in) {
            return new HouseList(in);
        }

        @Override
        public HouseList[] newArray(int size) {
            return new HouseList[size];
        }
    };

    public List<HouseDetails> getData() {
        return mData;
    }

    public void setData(List<HouseDetails> data) {
        mData = data;
    }

}
