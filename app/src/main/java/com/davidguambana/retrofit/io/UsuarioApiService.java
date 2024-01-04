package com.davidguambana.retrofit.io;

import com.davidguambana.retrofit.model.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuarioApiService {
    @GET("users")
    Call<ArrayList<Usuario>> getUsuarios();

    /*
    @FormUrlEncoded
    @POST("upload/photo")
    Call<SimpleResponse> postPhoto(
            @Field("image") String base64,
            @Field("extension") String extension,
            @Field("user_id") String user_id
    );

    @GET("login")
    Call<LoginResponse> getLogin(
            @Query("username") String username,
            @Query("password") String password
    );

    @FormUrlEncoded
    @POST("product")
    Call<SimpleResponse> postNewProduct(
            @Field("code") String code,
            @Field("name") String name,
            @Field("description") String description
    );

     */
}
