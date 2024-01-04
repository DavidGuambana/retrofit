package com.davidguambana.retrofit.io;

import com.davidguambana.retrofit.model.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuarioApiService {
    @GET("users")
    Call<ArrayList<Usuario>> getUsuarios();
}
