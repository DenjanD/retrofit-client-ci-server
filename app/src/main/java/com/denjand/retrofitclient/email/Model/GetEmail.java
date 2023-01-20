package com.denjand.retrofitclient.email.Model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class GetEmail {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Email> listDataEmail;
    @SerializedName("message")
    String message;

    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;

    public GetEmail(String id, String nama, String email) {
        this.id = id;
        this.nama = nama;
        this.email = email;
    }

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
    public List<Email> getListDataEmail() {
        return listDataEmail;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setListDataEmail(List<Email> listDataEmail) {
        this.listDataEmail = listDataEmail;
    }
}
