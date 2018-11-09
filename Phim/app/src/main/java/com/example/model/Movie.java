package com.example.model;

import java.util.List;

public class Movie {

    //ATRIBUTOS
    private Integer id;
    private String title;
    private String year;
    private String rated;
    private String genre;
    private String director;
    private String writers;
    private List<ActorDetalle> actores;
    private String plot;
    private String awards;
    private String countryOrigin;
    private String metaScore;
    private String duration;
    private Integer image;
    private String imbdScore;

    //CONSTRUCTOR


    public Movie(Integer id, String title, String year, String rated, String genre, String director, String writers, List<ActorDetalle> actores, String plot, String awards, String countryOrigin, String metaScore, String duration, Integer image, String imbdScore) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.genre = genre;
        this.director = director;
        this.writers = writers;
        this.actores = actores;
        this.plot = plot;
        this.awards = awards;
        this.countryOrigin = countryOrigin;
        this.metaScore = metaScore;
        this.duration = duration;
        this.image = image;
        this.imbdScore = imbdScore;
    }

    //GETTER


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriters() {
        return writers;
    }

    public List<ActorDetalle> getActores() {
        return actores;
    }

    public String getPlot() {
        return plot;
    }

    public String getAwards() {
        return awards;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public String getMetaScore() {
        return metaScore;
    }

    public String getDuration() {
        return duration;
    }

    public Integer getImage() {
        return image;
    }

    public String getImbdScore() {
        return imbdScore;
    }
}
