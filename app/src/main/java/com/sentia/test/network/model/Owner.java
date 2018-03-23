
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Owner implements Parcelable{

    @SerializedName("avatar")
    private Avatar mAvatar;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("id")
    private Long mId;
    @SerializedName("last_name")
    private String mLastName;

    protected Owner(Parcel in) {
        mAvatar = in.readParcelable(Avatar.class.getClassLoader());
        mEmail = in.readString();
        mFirstName = in.readString();
        if (in.readByte() == 0) {
            mId = null;
        } else {
            mId = in.readLong();
        }
        mLastName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mAvatar, flags);
        dest.writeString(mEmail);
        dest.writeString(mFirstName);
        if (mId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mId);
        }
        dest.writeString(mLastName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    public Avatar getAvatar() {
        return mAvatar;
    }

    public void setAvatar(Avatar avatar) {
        mAvatar = avatar;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

}
