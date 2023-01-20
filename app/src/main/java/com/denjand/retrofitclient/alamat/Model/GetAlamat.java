package com.denjand.retrofitclient.alamat.Model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class GetAlamat {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Alamat> listDataAlamat;
    @SerializedName("message")
    String message;

    @SerializedName("id")
    private String id;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("alamat")
    private String alamat;

    public GetAlamat(String id, String lokasi, String alamat) {
        this.id = id;
        this.lokasi = lokasi;
        this.alamat = alamat;
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
    public List<Alamat> getListDataAlamat() {
        return listDataAlamat;
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

    public void setNomor(String alamat) {
        this.alamat = alamat;
    }
    public void setListDataAlamat(List<Alamat> listDataAlamat) {
        this.listDataAlamat = listDataAlamat;
    }
}
