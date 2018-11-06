package com.example.david.pantallacategoriasfinal;

public class TipoPelicula {
    private String nombre;
    private Integer imagen;

    public TipoPelicula(String nombre, Integer imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "TipoPelicula{" +
                "nombre='" + nombre + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}


