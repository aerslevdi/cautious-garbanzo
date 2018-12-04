package com.phimy.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phimy.R;
import com.phimy.model.Cast;
import com.phimy.model.Credit;
import com.phimy.model.Crew;
import com.phimy.model.MovieDB;
import com.phimy.view.adapter.ActorAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment implements ActorAdapter.AdapterListener {
    public static final String KEY_MOVIEDB="movieDB";
    private static final String KEY_TITULO = "titulo";
    private static final String KEY_ANIO = "anio";
    private static final String KEY_RATED = "rated";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_PLOT = "plot";
    private static final String KEY_DURACION = "duracion";
    private static final String KEY_ID = "id";
    private static final String KEY_TRAILER = "trailer";
    private static final String KEY_CREW = "crew";
    public static final String KEY_CAST = "cast";


    public DetalleFragment() {
        // Required empty public constructor
    }
    public static DetalleFragment perfilFabrica(MovieDB dato){
        DetalleFragment fragment = new DetalleFragment();


        Bundle bundle = new Bundle();
        bundle.putSerializable(DetalleFragment.KEY_MOVIEDB, dato);
        //bundle.putArr(DetalleFragment.KEY_CAST, list.getCast());
        //bundle.putParcelableArrayList(DetalleFragment.KEY_CREW, list.getCrew());
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        Bundle bundle = getArguments();
        // Datos



        String path = movieDB.getPoster_path();
        Glide.with(this).load("http://image.tmdb.org/t/p/w185/"+movieDB.getPoster_path()).into(imageView);



        String rate = bundle.getString(KEY_RATED);

        //List<Cast> actores = bundle.getParcelableArrayList(KEY_CAST);
        //List<Crew> crewList = bundle.getParcelableArrayList(KEY_CREW);
        TextView tituloView = view.findViewById(R.id.tituloPelicula);
        //ActorAdapter actorAdapter = new ActorAdapter(actores, this);
        TextView generoView = view.findViewById(R.id.genero);
        TextView duracionView = view.findViewById(R.id.duracion);
        TextView fechaView = view.findViewById(R.id.fecha);
        TextView plotView = view.findViewById(R.id.plotView);
        TextView scoreView = view.findViewById(R.id.scoreNumero);
        TextView metaView = view.findViewById(R.id.scoreMeta);
        TextView premiosView = view.findViewById(R.id.premiosNumero);
        RecyclerView recyclerView = view.findViewById(R.id.actoresRecycler);

        ImageView trailerView = view.findViewById(R.id.imagenVideo);



        // Seteo los datos
        tituloView.setText(movieDB.getTitle());
        trailerView.setImageResource(movieDB.getTrailer());
        generoView.setText(movieDB.getGenres());
        duracionView.setText(movieDB.getRuntime());
        fechaView.setText(movieDB.getRelease_date());
        plotView.setText(movieDB.getOverview());
        scoreView.setText(movieDB.getVote_count());
        metaView.setText(movieDB.getPopularity());

        //recyclerView.setAdapter(actorAdapter);


        return view;
    }

    @Override
    public void recibir() {

    }
}
