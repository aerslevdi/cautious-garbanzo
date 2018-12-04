package com.phimy.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    public static DetalleFragment perfilFabrica(MovieDB dato, Credit list){
        DetalleFragment fragment = new DetalleFragment();

        Bundle bundle = new Bundle();
        bundle.putString(DetalleFragment.KEY_TITULO, dato.getTitle());
        bundle.putString(DetalleFragment.KEY_ANIO, dato.getRelease_date());
        bundle.putInt(DetalleFragment.KEY_RATED, dato.getPopularity());
        bundle.putString(DetalleFragment.KEY_GENRE, dato.getGenres());
        bundle.putString(DetalleFragment.KEY_PLOT, dato.getOverview());
        bundle.putInt(DetalleFragment.KEY_DURACION, dato.getRuntime());
        bundle.putInt(DetalleFragment.KEY_TRAILER, dato.getTrailer());
        bundle.putInt(DetalleFragment.KEY_ID, dato.getId());
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
        String titulo = bundle.getString(KEY_TITULO);
        String anio = bundle.getString(KEY_ANIO);
        String rate = bundle.getString(KEY_RATED);
        String genre = bundle.getString(KEY_GENRE);
        String plot = bundle.getString(KEY_PLOT);
        String duracion = bundle.getString(KEY_DURACION);
        Integer trailer = bundle.getInt(KEY_TRAILER);
        //List<Cast> actores = bundle.getParcelableArrayList(KEY_CAST);
        //List<Crew> crewList = bundle.getParcelableArrayList(KEY_CREW);
        TextView tituloView = view.findViewById(R.id.tituloPelicula);
        //ActorAdapter actorAdapter = new ActorAdapter(actores, this);
        TextView generoView = view.findViewById(R.id.genero);
        TextView duracionView = view.findViewById(R.id.duracion);
        TextView fechaView = view.findViewById(R.id.fecha);
        TextView scoreView = view.findViewById(R.id.scoreNumero);
        TextView metaView = view.findViewById(R.id.scoreMeta);
        TextView premiosView = view.findViewById(R.id.premiosNumero);
        RecyclerView recyclerView = view.findViewById(R.id.actoresRecycler);

        ImageView trailerView = view.findViewById(R.id.imagenVideo);



        // Seteo los datos
        tituloView.setText(titulo);
        trailerView.setImageResource(trailer);
        generoView.setText(genre);
        duracionView.setText(duracion);
        fechaView.setText(anio);
        //recyclerView.setAdapter(actorAdapter);


        return view;
    }

    @Override
    public void recibir() {

    }
}
