package com.example.evaluacionfinal.entity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class pelicula{


private String nombre;
private String genero;
private int año;
private double calificacion;


// Getters y Setters
public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getGenero() {
    return genero;
}

public void setGenero(String genero) {
    this.genero = genero;
}

public int getAño() {
    return año;
}

public void setAnio(int anio) {
    this.año = año;
}

public double getCalificacion() {
    return calificacion;
}

public void setCalificacion(double calificacion) {
    this.calificacion = calificacion;
}

    public static interface ServicePeliculaApi {

        @POST("pelicula/registar")
        public abstract Call<pelicula> registrar(@Body pelicula obj);
    }
}
