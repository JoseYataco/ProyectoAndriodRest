package com.example.evaluacionfinal.util;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ConectionRest {

    private static Retrofit retrofit ;

    private static final String URL = "http://3.93.187.12:8080/url/pelicula/";

    public static Retrofit getConnection(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
