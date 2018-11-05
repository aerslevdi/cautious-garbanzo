package com.example.digital.phim;

public class ActorDetalle {
    //ATRIBUTOS

    private String nombre;
    private Integer imagen;

    //CONSTRUCTOR

    public ActorDetalle(String nombre, Integer imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    //GETTER/SETTER


    public String getNombre() {
        return nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
