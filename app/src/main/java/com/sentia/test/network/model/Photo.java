
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Photo implements Parcelable {

    @SerializedName("default")
    private Boolean mDefault;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private Image mImage;

    protected Photo(Parcel in) {
        byte tmpMDefault = in.readByte();
        mDefault = tmpMDefault == 0 ? null : tmpMDefault == 1;
        if (in.readByte() == 0) {
            mId = null;
        } else {
            mId = in.readLong();
        }
        mImage = in.readParcelable(Image.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (mDefault == null ? 0 : mDefault ? 1 : 2));
        if (mId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mId);
        }
        dest.writeParcelable(mImage, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public Boolean getDefault() {
        return mDefault;
    }


    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        mImage = image;
    }

}
