package com.example.view;

/**
 * Created by wpenia on 07/11/18.
 */

public class Pelicula {
    private String name;
    private int numOfMovies;
    private int thumbnail;

    public Pelicula() {
    }

    public Pelicula(String name, int numOfMovies, int thumbnail) {
        this.name = name;
        this.numOfMovies = numOfMovies;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfMovies() {
        return numOfMovies;
    }

    public void setNumOfMovies(int numOfMovies) {
        this.numOfMovies = numOfMovies;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

