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
import com.phimy.controller.ControllerSeriesDB;
import com.phimy.model.Cast;
import com.phimy.model.MovieDB;
import com.phimy.model.SerieDB;
import com.phimy.model.VideoDB;
import com.phimy.view.adapter.DetalleAdapter;
import com.phimy.view.adapter.SerieActoresAdapter;

import java.util.ArrayList;
import java.util.List;

import Utils.ResultListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesDetalleFragment extends Fragment {
    public static final String KEY_SERIESDB= "movieDB";
    private List<SerieDB> favoritos;
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
    private SerieDB serieDB;
    private ImageView verTrailer;
    private DetalleFragment.Listener listener;
    private ControllerSeriesDB controllerSeries = new ControllerSeriesDB();
    private List<Cast> casting = new ArrayList<>();
    private ControllerMovieDB controller = new ControllerMovieDB();


    public SeriesDetalleFragment() {
        // Required empty public constructor
    }
    public static SeriesDetalleFragment fabrica(SerieDB serie) {
        SeriesDetalleFragment fragment = new SeriesDetalleFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(SeriesDetalleFragment.KEY_SERIESDB, serie);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_series_detalle, container, false);
        final SerieActoresAdapter actorAdapter = new SerieActoresAdapter(casting);

        Bundle bundle = getArguments();
        Object seriesObj = bundle.getSerializable(KEY_SERIESDB);
        serieDB = (SerieDB) seriesObj;
        path = serieDB.getPoster_path();

        recyclerView = view.findViewById(R.id.recyclerActores);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(actorAdapter);


        //TRAER CAST
        controller.getCast(view.getContext(), new ResultListener<List<Cast>>() {
            @Override
            public void finish(List<Cast> resultado) {
                actorAdapter.setActores(resultado);

            }
        }, serieDB.getId());






        //GET COMPONENTS

        tituloView = view.findViewById(R.id.nombreSerie);

        fechaView = view.findViewById(R.id.date);
        scoreView = view.findViewById(R.id.scoreNum);
        metaView = view.findViewById(R.id.metaScore);

        trailerView = view.findViewById(R.id.imagenPath);
        shareMovie = view.findViewById(R.id.shareButton);
        plot = view.findViewById(R.id.overview);
        fab = view.findViewById(R.id.fab);
        verTrailer = view.findViewById(R.id.serieButton);


        //SET DATA


        tituloView.setText(serieDB.getTitle());
        Glide.with(this).load("http://image.tmdb.org/t/p/w185/" + path).into(trailerView);
        fechaView.setText(serieDB.getRelease_date());
        scoreView.setText(serieDB.getPopularity().toString());
        metaView.setText(serieDB.getVote_count().toString());

        //plot.setText(movieDB.getOverview());
        //TODO BACKGROUND COLOR Y HEIGHT DE CARDVIEW
        ExpandableTextView expTv1 = (ExpandableTextView) view.findViewById(R.id.expand_text_view);
        expTv1.setText(serieDB.getOverview());





        //SHARE

        shareMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Compartir en WhatsApp");
                share.putExtra(Intent.EXTRA_TEXT, "Te recomiendo " + serieDB.getTitle() + " Enviado desde PHIM");
                startActivity(Intent.createChooser(share, "Share link!"));
            }
        });

        //AGREGAR A FAVORITOS

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (favoritos == null) {
                    favoritos = new ArrayList<>();
                    favoritos.add(serieDB);
                } else {
                    favoritos.add(serieDB);
                }
                Snackbar.make(view, "La pelicula ha sido agregada a tu lista", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        favoritos.remove(serieDB);
                    }
                }).show();
            }
        });



        //TRAER VIDEO

            verTrailer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    controller.getVideoDB(getContext(), new ResultListener<VideoDB>() {
                        @Override
                        public void finish(VideoDB resultado) {
                            videoKey = resultado.getKey();
                            DetalleFragment.VideoTrailer listenerTrailer = (DetalleFragment.VideoTrailer) getContext();
                            listenerTrailer.recibirVideo(videoKey);
                        }
                    }, serieDB.getId());
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

    public interface SerieTrailer{
        void recibirVideo(String key);
    }

}
