package com.example.proyekakhir3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MenuInterface {
    @GET("mabar/")
    Call<List<Menu>> getMenu();

    @POST("mabar/")
    Call<Menu> postMenu(@Field("tier")String tier, @Field("harga")String harga, @Field("deskripsi")String deskripsi);

}
