package com.denjand.retrofitclient.alamat.Model;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */

public class Alamat {
    @SerializedName("id")
    private String id;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("alamat")
    private String alamat;

    public Alamat(){}

    public Alamat(String id, String lokasi, String alamat) {
        this.id = id;
        this.lokasi = lokasi;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}