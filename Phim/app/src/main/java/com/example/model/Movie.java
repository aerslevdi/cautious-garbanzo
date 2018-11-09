package com.example.model;

import java.util.Date;
import java.util.List;

public class Movie {

    //ATRIBUTOS

    private String title;
    private String year;
    private String rated;
    private String fecha;
    private String duration;
    private String genre;
    private String director;
    private String writers;
    private List<ActorDetalle> actores;
    private String plot;
    private String language;
    private String awards;
    private String countryOrigin;
    private Integer poster;
    private String imbdScore;
    private String metaScore;
    private String votes;
    private Integer id;
    private String format;
    private Integer image;

    //CONSTRUCTOR


    public Movie( String title, String year, String rated, String fecha, String duration, String genre, String director, String writers, List<ActorDetalle> actores, String plot, String language, String awards, String countryOrigin, Integer poster, String imbdScore, String metaScore, String votes, Integer id, String format,  Integer image) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.fecha = fecha;
        this.duration = duration;
        this.genre = genre;
        this.director = director;
        this.writers = writers;
        this.actores = actores;
        this.plot = plot;
        this.language = language;
        this.awards = awards;
        this.countryOrigin = countryOrigin;
        this.poster = poster;
        this.metaScore = metaScore;
        this.votes = votes;
        this.image = image;
        this.format = format;
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

    public String getFecha() {
        return fecha;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getFormat() {
        return format;
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

    public Integer getPoster() {
        return poster;
    }

    public String getMetaScore() {
        return metaScore;
    }

    public String getVotes() {
        return votes;
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
