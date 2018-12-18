package com.phimy.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.phimy.R;
import com.phimy.controller.ControllerMovieDB;
import com.phimy.model.MovieDB;
import com.phimy.view.adapter.SliderAdapter;
import com.phimy.view.fragment.DetalleFragment;

import java.util.ArrayList;
import java.util.List;

import Utils.ResultListener;

public class MovieDetalleActivity extends MainActivity implements DetalleFragment.VideoTrailer{
    public static final String KEY_MOVIEDB = "movieDB";
    public static final String KEY_POS = "position";
    public static final String KEY_NAMEFRAG = "name";
    private DetalleFragment detalleFragment;
    private Toolbar toolbar;
    private List<MovieDB> movieData = new ArrayList<>();
    private ControllerMovieDB controllerMovieDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detalle);

        toolbar = findViewById(R.id.toolbarWid);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<MovieDB> listMovies = (ArrayList<MovieDB>) args.getSerializable("ARRAYLIST");
        Object movieObj = args.getSerializable(KEY_MOVIEDB);
        String senderFragment = args.getString(KEY_NAMEFRAG);
        final Integer posicion = args.getInt(KEY_POS);


        final MovieDB movieDB = (MovieDB) movieObj;
        //controllerMovieDB = new ControllerMovieDB();
        detalleFragment = new DetalleFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(detalleFragment.KEY_MOVIEDBFR, movieDB);
        detalleFragment.setArguments(bundle);

        final SliderAdapter adapter = new SliderAdapter(getSupportFragmentManager(), movieData);
        final ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        adapter.setDatos(listMovies);
        viewPager.setCurrentItem(posicion);

        /*if (senderFragment.equals("UpComingFragment")) {
            controllerMovieDB.getTvMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setDatos(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);

        } else if (senderFragment == "OnRatedFragment") {
            controllerMovieDB.getNowPlaying(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setDatos(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);
        } else if (senderFragment == "MovieFragment") {
            controllerMovieDB.getMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setDatos(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);
        }  else if (senderFragment == "TvFragment") {
            controllerMovieDB.getMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setDatos(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);
        } else if (senderFragment == "FavoritoFragment") {
            controllerMovieDB.getMovies(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setDatos(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);
        } else {
            controllerMovieDB.getNowPlaying(new ResultListener<List<MovieDB>>() {
                @Override
                public void finish(List<MovieDB> result) {
                    adapter.setDatos(result);
                    viewPager.setCurrentItem(posicion);
                }
            }, this);
        }*/
    }

    @Override
    public void recibirVideo(String key) {
        Intent intent = new Intent(MovieDetalleActivity.this, MediaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(MediaActivity.KEY_MOVIEVID, key);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
