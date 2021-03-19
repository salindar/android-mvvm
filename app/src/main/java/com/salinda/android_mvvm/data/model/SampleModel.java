package com.salinda.android_mvvm.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Sample model that can be used to as a response of API endpoint
 */
public class SampleModel extends BaseModel {
    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//test
    public String isUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}