package com.denjand.retrofitclient.email.Rest;

import com.denjand.retrofitclient.email.Model.GetEmail;
import com.denjand.retrofitclient.email.Model.PostPutDelEmail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("email")
    Call<List<GetEmail>> getEmail();
    @FormUrlEncoded
    @POST("email")
    Call<PostPutDelEmail> postEmail(@Field("nama") String nama,
                                      @Field("email") String email);
    @FormUrlEncoded
    @PUT("email")
    Call<PostPutDelEmail> putEmail(@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("email") String email);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "email", hasBody = true)
    Call<PostPutDelEmail> deleteEmail(@Field("id") String id);
}
