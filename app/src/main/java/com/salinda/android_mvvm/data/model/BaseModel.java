package com.salinda.android_mvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Salinda Rathnayeka May 2021
 * salindakrishantha@gmail.com
 */
public class BaseModel implements Parcelable {
    //As per the API implementation, need to send the auth code in the data body
    @SerializedName("api_key")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

    protected BaseModel(Parcel in) {
        this.apiKey = in.readString();
    }

    protected BaseModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.apiKey);
    }
}
