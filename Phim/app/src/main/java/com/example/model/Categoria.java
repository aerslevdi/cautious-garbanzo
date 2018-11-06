package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {

    private String titulo;
    private Integer foto;
    private String ingredientes;
    private String preparacion;

    public Categoria(String titulo, Integer foto) {
        this.titulo = titulo;
        this.foto = foto;
    }

    public Categoria(String titulo, Integer foto, String ingredientes, String preparacion) {
        this(titulo, foto);
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getFoto() {
        return foto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "titulo='" + titulo + '\'' +
                ", foto=" + foto +
                ", ingredientes='" + ingredientes + '\'' +
                ", preparacion='" + preparacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria receta = (Categoria) o;
        return Objects.equals(titulo, receta.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
