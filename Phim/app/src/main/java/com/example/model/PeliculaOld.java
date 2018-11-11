package com.example.model;

public class PeliculaOld {
    private String nombre;
    private Integer imagen;

    public PeliculaOld(String nombre, Integer imagen) {
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
