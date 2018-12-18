package com.phimy.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.phimy.view.fragment.FavoritoFragment;
import com.phimy.view.fragment.SeriesFragment;
import com.phimy.view.fragment.TvFragment;
import com.phimy.view.fragment.MovieFragment;
import com.phimy.view.fragment.OnRatedFragment;
import com.phimy.view.fragment.UpComingFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieFragment();//popular
            case 1:
                return new UpComingFragment();//upcoming
            case 2:
                return new OnRatedFragment(); //Now playing
            case 3:
                return new FavoritoFragment();
            case 4:
                return new TvFragment();
                //return new SeriesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
