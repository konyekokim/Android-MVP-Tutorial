package com.chokus.konye.mvptutorial.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseModel {
    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("statusMsg")
    @Expose
    public String statusMsg;
}
