package com.phimy.view;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import com.bumptech.glide.Glide;
import com.phimy.R;
import com.phimy.model.MovieDB;
import com.phimy.view.adapter.DetallePageAdapter;
import com.phimy.view.fragment.DetalleFragment;

import java.util.ArrayList;

public class MovieDetalleActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detalle);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Object movieObj = intent.getSerializableExtra(DetalleFragment.KEY_MOVIEDB);
        MovieDB movieDB = (MovieDB)movieObj;
        ViewPager viewPager = findViewById(R.id.pagerDetalle);
        DetallePageAdapter adapter = new DetallePageAdapter(getSupportFragmentManager(), new ArrayList<android.support.v4.app.Fragment>());
        viewPager.setAdapter(adapter);

    }

}
