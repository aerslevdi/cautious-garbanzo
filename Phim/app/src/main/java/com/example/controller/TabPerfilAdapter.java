package com.example.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dao.DAOMovies;

import java.util.List;

public class TabPerfilAdapter extends FragmentPagerAdapter {

    private List<Fragment>datos;
    private List<DAOMovies> movies;


    public TabPerfilAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
