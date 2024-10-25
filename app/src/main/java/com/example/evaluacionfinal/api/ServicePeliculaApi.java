package com.example.evaluacionfinal.api;

import com.example.evaluacionfinal.entity.pelicula;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServicePeliculaApi {

    @POST("registrar")
    public Call<pelicula> registrar(@Body pelicula objpelicula);
}
