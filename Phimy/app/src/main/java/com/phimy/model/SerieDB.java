package com.phimy.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "Series")
public class SerieDB implements Serializable{
    private String name;
    private Integer vote_count;
    @PrimaryKey
    @NonNull
    private Integer id;
    private String profile_path;
    private String overview;
    private String release_date;
    private Double popularity;


    public String getTitle() {
        return name;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public Integer getId() {
        return id;
    }

    public String getPoster_path() {
        return profile_path;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Double getPopularity() {
        return popularity;
    }

    @Override
    public String toString() {
        return "MovieDB{" +
                "title='" + name + '\'' +
                ", vote_count=" + vote_count +
                ", id=" + id +
                ", poster_path='" + profile_path + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return (this.id.equals(((SerieDB) obj).id));
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public void setPoster_path(String poster_path) {
        this.profile_path = poster_path;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }
}
