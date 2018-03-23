
package com.sentia.test.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class HouseDetails implements Parcelable{

    @SerializedName("bathrooms")
    private Long mBathrooms;
    @SerializedName("bedrooms")
    private Long mBedrooms;
    @SerializedName("carspots")
    private Long mCarspots;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("id")
    private Long mId;
    @SerializedName("is_premium")
    private Boolean mIsPremium;
    @SerializedName("location")
    private Location mLocation;
    @SerializedName("owner")
    private Owner mOwner;
    @SerializedName("photo")
    private Photo mPhoto;
    @SerializedName("price")
    private Long mPrice;
    @SerializedName("state")
    private String mState;
    @SerializedName("title")
    private String mTitle;

    protected HouseDetails(Parcel in) {
        if (in.readByte() == 0) {
            mBathrooms = null;
        } else {
            mBathrooms = in.readLong();
        }
        if (in.readByte() == 0) {
            mBedrooms = null;
        } else {
            mBedrooms = in.readLong();
        }
        if (in.readByte() == 0) {
            mCarspots = null;
        } else {
            mCarspots = in.readLong();
        }
        mDescription = in.readString();
        if (in.readByte() == 0) {
            mId = null;
        } else {
            mId = in.readLong();
        }
        byte tmpMIsPremium = in.readByte();
        mIsPremium = tmpMIsPremium == 0 ? null : tmpMIsPremium == 1;
        if (in.readByte() == 0) {
            mPrice = null;
        } else {
            mPrice = in.readLong();
        }
        mState = in.readString();
        mTitle = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mBathrooms == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mBathrooms);
        }
        if (mBedrooms == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mBedrooms);
        }
        if (mCarspots == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mCarspots);
        }
        dest.writeString(mDescription);
        if (mId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mId);
        }
        dest.writeByte((byte) (mIsPremium == null ? 0 : mIsPremium ? 1 : 2));
        if (mPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mPrice);
        }
        dest.writeString(mState);
        dest.writeString(mTitle);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HouseDetails> CREATOR = new Creator<HouseDetails>() {
        @Override
        public HouseDetails createFromParcel(Parcel in) {
            return new HouseDetails(in);
        }

        @Override
        public HouseDetails[] newArray(int size) {
            return new HouseDetails[size];
        }
    };

    public Long getBathrooms() {
        return mBathrooms;
    }

    public void setBathrooms(Long bathrooms) {
        mBathrooms = bathrooms;
    }

    public Long getBedrooms() {
        return mBedrooms;
    }

    public void setBedrooms(Long bedrooms) {
        mBedrooms = bedrooms;
    }

    public Long getCarspots() {
        return mCarspots;
    }

    public void setCarspots(Long carspots) {
        mCarspots = carspots;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Boolean getIsPremium() {
        return mIsPremium;
    }

    public void setIsPremium(Boolean isPremium) {
        mIsPremium = isPremium;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public void setOwner(Owner owner) {
        mOwner = owner;
    }

    public Photo getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Photo photo) {
        mPhoto = photo;
    }

    public Long getPrice() {
        return mPrice;
    }

    public void setPrice(Long price) {
        mPrice = price;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
