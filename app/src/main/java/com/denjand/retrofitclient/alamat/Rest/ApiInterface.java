package com.denjand.retrofitclient.alamat.Rest;

import com.denjand.retrofitclient.alamat.Model.GetAlamat;
import com.denjand.retrofitclient.alamat.Model.PostPutDelAlamat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("alamat")
    Call<List<GetAlamat>> getAlamat();
    @FormUrlEncoded
    @POST("alamat")
    Call<PostPutDelAlamat> postAlamat(@Field("lokasi") String lokasi,
                                      @Field("alamat") String alamat);
    @FormUrlEncoded
    @PUT("alamat")
    Call<PostPutDelAlamat> putAlamat(@Field("id") String id,
                                     @Field("lokasi") String lokasi,
                                     @Field("alamat") String alamat);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "alamat", hasBody = true)
    Call<PostPutDelAlamat> deleteAlamat(@Field("id") String id);
}
