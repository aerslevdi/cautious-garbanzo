package com.phimy.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.phimy.R;
import com.phimy.controller.ControllerMovieDB;
import com.phimy.controller.ControllerSeriesDB;
import com.phimy.model.SerieDB;
import com.phimy.view.adapter.SeriesPagerAdapter;
import com.phimy.view.fragment.SeriesDetalleFragment;

import java.util.ArrayList;
import java.util.List;

public class SeriesDetalleActivity extends AppCompatActivity implements SeriesDetalleFragment.SerieTrailer {
    public static final String KEY_SERIEOBJ = "serieDB";
    public static final String KEY_POSITION = "position";
    public static final String KEY_TVFRAG = "name";
    private SeriesDetalleFragment seriesDetalleFragment;
    private Toolbar toolbar;
    private List<SerieDB> serieData = new ArrayList<>();
    private ControllerMovieDB controllerMovieDB;
    private ControllerSeriesDB controllerSeriesDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detalle);
        toolbar = findViewById(R.id.toolWid);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        Intent intent = getIntent();
        Bundle intentBundle = intent.getExtras();
        Object serieObj = intentBundle.getSerializable(KEY_SERIEOBJ);
        String senderFragment = intentBundle.getString(KEY_TVFRAG);
        final Integer posicion = intentBundle.getInt(KEY_POSITION);
        final SerieDB serieDB = (SerieDB) serieObj;
        controllerMovieDB = new ControllerMovieDB();
        controllerSeriesDB = new ControllerSeriesDB();

        seriesDetalleFragment = new SeriesDetalleFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(seriesDetalleFragment.KEY_SERIESDB, serieDB);
        seriesDetalleFragment.setArguments(bundle);


        final SeriesPagerAdapter adapter = new SeriesPagerAdapter(getSupportFragmentManager(), serieData);

        String holaaaaa = "TvFragment";
        final ViewPager viewPager = findViewById(R.id.pagerView);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(posicion);

        /*if (senderFragment.equals(holaaaaa)) {
            controllerMovieDB.getTvMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setData(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);

        } else if (senderFragment == "OnRatedFragment") {
            controllerMovieDB.getNowPlaying(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setData(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);
        } else if (senderFragment == "MovieFragment") {
            controllerMovieDB.getMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setData(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);
        } else {
            controllerMovieDB.getNowPlaying(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setData(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);
        }*/
    }

    @Override
    public void recibirVideo(String key) {
        Intent intent = new Intent(SeriesDetalleActivity.this, MediaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(MediaActivity.KEY_SERIEID, key);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
