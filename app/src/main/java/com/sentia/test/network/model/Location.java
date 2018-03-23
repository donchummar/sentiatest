
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Location implements Parcelable{

    @SerializedName("address_1")
    private String mAddress1;
    @SerializedName("address_2")
    private String mAddress2;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("full_address")
    private String mFullAddress;
    @SerializedName("id")
    private Long mId;
    @SerializedName("latitude")
    private Double mLatitude;
    @SerializedName("longitude")
    private Double mLongitude;
    @SerializedName("postcode")
    private String mPostcode;
    @SerializedName("state")
    private String mState;
    @SerializedName("suburb")
    private String mSuburb;

    protected Location(Parcel in) {
        mAddress1 = in.readString();
        mAddress2 = in.readString();
        mCountry = in.readString();
        mFullAddress = in.readString();
        if (in.readByte() == 0) {
            mId = null;
        } else {
            mId = in.readLong();
        }
        if (in.readByte() == 0) {
            mLatitude = null;
        } else {
            mLatitude = in.readDouble();
        }
        if (in.readByte() == 0) {
            mLongitude = null;
        } else {
            mLongitude = in.readDouble();
        }
        mPostcode = in.readString();
        mState = in.readString();
        mSuburb = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAddress1);
        dest.writeString(mAddress2);
        dest.writeString(mCountry);
        dest.writeString(mFullAddress);
        if (mId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mId);
        }
        if (mLatitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(mLatitude);
        }
        if (mLongitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(mLongitude);
        }
        dest.writeString(mPostcode);
        dest.writeString(mState);
        dest.writeString(mSuburb);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getAddress1() {
        return mAddress1;
    }

    public void setAddress1(String address1) {
        mAddress1 = address1;
    }

    public String getAddress2() {
        return mAddress2;
    }

    public void setAddress2(String address2) {
        mAddress2 = address2;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getFullAddress() {
        return mFullAddress;
    }

    public void setFullAddress(String fullAddress) {
        mFullAddress = fullAddress;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(Double latitude) {
        mLatitude = latitude;
    }

    public Double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(Double longitude) {
        mLongitude = longitude;
    }

    public String getPostcode() {
        return mPostcode;
    }

    public void setPostcode(String postcode) {
        mPostcode = postcode;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getSuburb() {
        return mSuburb;
    }

    public void setSuburb(String suburb) {
        mSuburb = suburb;
    }

}
