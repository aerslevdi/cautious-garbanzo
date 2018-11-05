package com.example.wpenia.phim;

public class Pelicula {
    private String nombre;
    private Integer imagen;

    public Pelicula(String nombre, Integer imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getImagen() {
        return imagen;
    }
}
