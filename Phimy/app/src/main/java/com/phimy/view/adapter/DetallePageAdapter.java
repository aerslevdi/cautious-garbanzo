package com.phimy.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.phimy.model.Cast;
import com.phimy.model.Credit;
import com.phimy.model.Crew;
import com.phimy.model.MovieDB;

import java.util.List;

public class DetallePageAdapter extends FragmentPagerAdapter {
    List <Fragment> fragments;
    List <MovieDB> movieList;
    List<Cast> actores;
    List<Crew> backstage;
    List<Credit> fullCredit;

    public DetallePageAdapter(FragmentManager fm, List<Fragment> fragments, List<MovieDB> movieList, List<Cast> actores, List<Crew> backstage, List<Credit> fullCredit) {
        super(fm);
        this.fragments = fragments;
        this.movieList = movieList;
        this.actores = actores;
        this.backstage = backstage;
        this.fullCredit = fullCredit;
    }



    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
