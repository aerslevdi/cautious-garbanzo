package com.phimy.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.phimy.model.MovieDB;
import com.phimy.model.SerieDB;
import com.phimy.view.fragment.SeriesDetalleFragment;

import java.util.ArrayList;
import java.util.List;

public class SeriesPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();

    private List<SerieDB> datos;
    public SeriesPagerAdapter(FragmentManager fm, List<SerieDB> datos) {
        super(fm);
        this.datos = datos;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
    public void setData(List<SerieDB> datos) {
        this.datos = datos;
        for (SerieDB serieDB : datos){
            SeriesDetalleFragment detalleView = SeriesDetalleFragment.fabrica(serieDB);
            fragments.add(detalleView);
        }
        notifyDataSetChanged();
    }
}
