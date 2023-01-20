package com.denjand.retrofitclient.email.Model;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */

public class Email {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;

    public Email(){}

    public Email(String id, String nama, String email) {
        this.id = id;
        this.nama = nama;
        this.email = email;
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
}