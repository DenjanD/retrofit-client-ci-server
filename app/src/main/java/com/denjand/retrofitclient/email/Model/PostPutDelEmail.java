package com.denjand.retrofitclient.email.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */

public class PostPutDelEmail {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Email mEmail;
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
    public Email getEmail() {
        return mEmail;
    }
    public void setEmail(Email Email) {
        mEmail = Email;
    }

}