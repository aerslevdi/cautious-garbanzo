package com.example.view;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.dao.DAOActores;
import com.example.model.ActorDetalle;
import com.example.wpenia.phim.R;

import java.util.ArrayList;
import java.util.List;

    public class PerfilPelicula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_pelicula);

        FloatingActionButton fab = findViewById(R.id.fabButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "La pelicula ha sido agregada a tu lista", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //QUITAR DE LA LISTA
                    }
                }).show();
            }
        });
        Button rating = findViewById(R.id.ratingButton);

        final PeliculaInfo peliculaInfo = new PeliculaInfo();

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.buttonFrame, peliculaInfo);

                fragmentTransaction.commit();


            }
        });


        List<ActorDetalle> actores = (new DAOActores()).getActores();

        RecyclerView recyclerView = findViewById(R.id.actoresRecycler);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ActorAdapter actorAdapter = new ActorAdapter(actores);
        recyclerView.setAdapter(actorAdapter);

    }

    }
