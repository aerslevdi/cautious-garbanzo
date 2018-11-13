package com.example.model;

import java.util.List;

public class PeliculaOld {
    private String nombre;
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
    private Integer trailer;
    private String imbdScore;
    private String metaScore;
    private String votes;
    private Integer id;
    private String format;
    private Integer imagen;

    public PeliculaOld(String nombre, String year, String rated, String fecha, String duration, String genre, String director, String writers, List<ActorDetalle> actores, String plot, String language, String awards, String countryOrigin, Integer trailer, String imbdScore, String metaScore, String votes, Integer id, String format, Integer imagen) {
        this.nombre = nombre;
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
        this.trailer = trailer;
        this.imbdScore = imbdScore;
        this.metaScore = metaScore;
        this.votes = votes;
        this.id = id;
        this.format = format;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getImagen() {
        return imagen;
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

    public Integer getTrailer() {
        return trailer;
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
}
