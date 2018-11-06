package com.example.dao;

import com.example.model.Movie;
import com.example.wpenia.phim.R;

import java.util.ArrayList;
import java.util.List;

public class DAOMovies {

    public List<Movie> getMovies(){
        List<Movie>movies = new ArrayList<>();
        DAOActores daoActores = new DAOActores();


        movies.add(new Movie(1,"Ant-Man","2015","PG-13","Action", "Peyton Reed", "Edwardwright, Joe Cornish", daoActores.getActores(), "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.", "1", "USA", "64", "1h 57 min", R.drawable.antman, "7,3/10"));
        movies.add(new Movie(1,"Ant-Man","2015","PG-13","Action", "Peyton Reed", "Edwardwright, Joe Cornish", daoActores.getActores(), "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.", "1", "USA", "64", "1h 57 min", R.drawable.antman, "7,3/10"));
        movies.add(new Movie(1,"Ant-Man","2015","PG-13","Action", "Peyton Reed", "Edwardwright, Joe Cornish", daoActores.getActores(), "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.", "1", "USA", "64", "1h 57 min", R.drawable.antman, "7,3/10"));
        movies.add(new Movie(1,"Ant-Man","2015","PG-13","Action", "Peyton Reed", "Edwardwright, Joe Cornish", daoActores.getActores(), "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.", "1", "USA", "64", "1h 57 min", R.drawable.antman, "7,3/10"));
        movies.add(new Movie(1,"Ant-Man","2015","PG-13","Action", "Peyton Reed", "Edwardwright, Joe Cornish", daoActores.getActores(), "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.", "1", "USA", "64", "1h 57 min", R.drawable.antman, "7,3/10"));
        movies.add(new Movie(1,"Ant-Man","2015","PG-13","Action", "Peyton Reed", "Edwardwright, Joe Cornish", daoActores.getActores(), "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.", "1", "USA", "64", "1h 57 min", R.drawable.antman, "7,3/10"));
        movies.add(new Movie(1,"Ant-Man","2015","PG-13","Action", "Peyton Reed", "Edwardwright, Joe Cornish", daoActores.getActores(), "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.", "1", "USA", "64", "1h 57 min", R.drawable.antman, "7,3/10"));
        movies.add(new Movie(1,"Ant-Man","2015","PG-13","Action", "Peyton Reed", "Edwardwright, Joe Cornish", daoActores.getActores(), "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.", "1", "USA", "64", "1h 57 min", R.drawable.antman, "7,3/10"));
        return  movies;

    }

}
