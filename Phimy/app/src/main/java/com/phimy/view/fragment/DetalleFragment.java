package com.phimy.view.fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.phimy.R;
import com.phimy.controller.ControllerMovieDB;
import com.phimy.model.Cast;
import com.phimy.model.MovieDB;
import com.phimy.model.VideoDB;
import com.phimy.view.adapter.DetalleAdapter;

import java.util.ArrayList;
import java.util.List;

import Utils.ResultListener;


public class DetalleFragment extends Fragment {

    public static final String KEY_MOVIEDBFR = "movieDB";
    private List<MovieDB> favoritos;
    private String videoKey;
    private TextView tituloView;
    private TextView fechaView;
    private TextView scoreView;
    private TextView metaView;
    private RecyclerView recyclerView;
    private ImageView trailerView;
    private ImageView shareMovie;
    private TextView plot;
    private FloatingActionButton fab;
    private String path;
    private MovieDB movieDB;
    private ImageView verTrailer;
    private Listener listener;
    private ControllerMovieDB controller = new ControllerMovieDB();
    private List<Cast> casting = new ArrayList<>();

    public DetalleFragment() {
        // Required empty public constructor
    }

    public static DetalleFragment fabrica(MovieDB movie) {
        DetalleFragment fragment = new DetalleFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetalleFragment.KEY_MOVIEDBFR, movie);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        final DetalleAdapter actorAdapter = new DetalleAdapter(casting);

        Bundle bundle = getArguments();
        Object movieObj = bundle.getSerializable(KEY_MOVIEDBFR);
        movieDB = (MovieDB) movieObj;
        path = movieDB.getPoster_path();

        recyclerView = view.findViewById(R.id.actoresRecycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(actorAdapter);


        //TRAER CAST
        controller.getCast(view.getContext(), new ResultListener<List<Cast>>() {
            @Override
            public void finish(List<Cast> resultado) {
                actorAdapter.setCast(resultado);

            }
        }, movieDB.getId());






        //GET COMPONENTS

        tituloView = view.findViewById(R.id.nombreMovie);

        fechaView = view.findViewById(R.id.fecha);
        scoreView = view.findViewById(R.id.scoreNumero);
        metaView = view.findViewById(R.id.scoreMeta);

        trailerView = view.findViewById(R.id.imagenVideo);
        shareMovie = view.findViewById(R.id.share);
        plot = view.findViewById(R.id.plot);
        fab = view.findViewById(R.id.fabButton);
        verTrailer = view.findViewById(R.id.trailerButton);


        //SET DATA


        tituloView.setText(movieDB.getTitle());
        Glide.with(this).load("http://image.tmdb.org/t/p/w185/" + path).into(trailerView);
        fechaView.setText(movieDB.getRelease_date());
        scoreView.setText(movieDB.getPopularity().toString());
        metaView.setText(movieDB.getVote_count().toString());

        //plot.setText(movieDB.getOverview());
        ExpandableTextView expTv1 = (ExpandableTextView) view.findViewById(R.id.expand_text_view);
        expTv1.setText(movieDB.getOverview());





        //SHARE

        shareMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Compartir en WhatsApp");
                share.putExtra(Intent.EXTRA_TEXT, "Te recomiendo" + movieDB.getTitle() + "/n Enviado desde PHIM");
                startActivity(Intent.createChooser(share, "Share link!"));
            }
        });

        //AGREGAR A FAVORITOS

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        //TRAER VIDEO

        verTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favoritos == null) {
                    favoritos = new ArrayList<>();
                    favoritos.add(movieDB);
                } else {
                    favoritos.add(movieDB);
                }
                Snackbar.make(v, "La pelicula ha sido agregada a tu lista", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        favoritos.remove(movieDB);
                    }
                }).show();
            }
        });


       /* controller.getVideoDB(view.getContext(), new ResultListener<VideoDB>() {
              @Override
              public void finish(VideoDB resultado) {
                  videoKey = resultado.getKey();

              }
          }, movieDB.getId());
      } else{
          Glide.with(this).load("http://image.tmdb.org/t/p/w185/" + path).into(trailerView);
      }*/




        return view;
    }

    public interface Listener{
        void send (MovieDB movieDB);
    }
    public interface VideoTrailer{
        void recibirVideo(String key);
    }


}
