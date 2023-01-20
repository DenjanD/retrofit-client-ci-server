package com.denjand.retrofitclient.alamat.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */

public class PostPutDelAlamat {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Alamat mAlamat;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Alamat getAlamat() {
        return mAlamat;
    }
    public void setAlamat(Alamat Alamat) {
        mAlamat = Alamat;
    }

}