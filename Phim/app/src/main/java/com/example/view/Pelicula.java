package com.example.view;

import com.example.model.ActorDetalle;

import java.util.List;

/**
 * Created by wpenia on 07/11/18.
 */

public class Pelicula {
    private String name;
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
    private Integer thumbnail;
    private String imbdScore;
    private String metaScore;
    private String votes;
    private Integer id;
    private String format;
    private Integer trailer;

    public Pelicula() {
    }

    public Pelicula(String name, String year, String rated, String fecha, String duration, String genre, String director, String writers, List<ActorDetalle> actores, String plot, String language, String awards, String countryOrigin, Integer thumbnail, String imbdScore, String metaScore, String votes, Integer id, String format, Integer trailer) {
        this.name = name;
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
        this.thumbnail = thumbnail;
        this.imbdScore = imbdScore;
        this.metaScore = metaScore;
        this.votes = votes;
        this.id = id;
        this.format = format;
        this.trailer = trailer;
    }

    public String getName() {
        return name;
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

    public String getDuration() {
        return duration;
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

    public String getLanguage() {
        return language;
    }

    public String getAwards() {
        return awards;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public String getImbdScore() {
        return imbdScore;
    }

    public String getMetaScore() {
        return metaScore;
    }

    public String getVotes() {
        return votes;
    }

    public Integer getId() {
        return id;
    }

    public String getFormat() {
        return format;
    }

    public Integer getTrailer() {
        return trailer;
    }

    public Integer getThumbnail() {
        return thumbnail;
    }
}

