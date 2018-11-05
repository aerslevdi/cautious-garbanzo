package com.example.digital.phim;

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


        List<ActorDetalle> actores = new ArrayList<>();
        actores.add(new ActorDetalle("Robert Downey Jr", R.drawable.robertdowneyjr));
        actores.add(new ActorDetalle("Chris Hemsworth", R.drawable.chrishemsworth));
        actores.add(new ActorDetalle("Mark Ruffalo", R.drawable.markruffalo));
        actores.add(new ActorDetalle("Chris Evans", R.drawable.chrisevans));
        actores.add(new ActorDetalle("Scarlett Johansson", R.drawable.scarlettjohansson));
        actores.add(new ActorDetalle("Don Cheadle", R.drawable.doncheadle));
        actores.add(new ActorDetalle("Benedict Cumberbatch", R.drawable.benedictcumberbatch));
        actores.add(new ActorDetalle("Tom Holland", R.drawable.tomholland));
        actores.add(new ActorDetalle("Chadwick Boseman", R.drawable.chadwickboseman));
        actores.add(new ActorDetalle("Zoe Zaldana", R.drawable.zoezaldana));
        actores.add(new ActorDetalle("Karen Gillan", R.drawable.karengillian));
        actores.add(new ActorDetalle("Tom Hiddleston", R.drawable.tomhiddleston));
        actores.add(new ActorDetalle("Paul Bettany", R.drawable.paulbettany));
        actores.add(new ActorDetalle("Elizabeth Olsen", R.drawable.elisabetholsen));
        actores.add(new ActorDetalle("Anthony Mackie", R.drawable.robertdowneyjr));
        actores.add(new ActorDetalle("Sebastian Stan", R.drawable.sebastianstan));
        actores.add(new ActorDetalle("Idris Elba", R.drawable.idriselba));
        actores.add(new ActorDetalle("Danai Gurira", R.drawable.danaigurira));
        actores.add(new ActorDetalle("Peter Dinklage", R.drawable.peterdinklage));
        actores.add(new ActorDetalle("Benedict Wong", R.drawable.benedictwong));

        RecyclerView recyclerView = findViewById(R.id.actoresRecycler);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ActorAdapter actorAdapter = new ActorAdapter(actores);
        recyclerView.setAdapter(actorAdapter);

    }

    }
