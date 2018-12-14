package com.phimy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SerieDBContainer {
    @SerializedName("results")
    private List<SerieDB> misSeries;
    public List<SerieDB> getMisSeries() {
        return misSeries;
    }
}
