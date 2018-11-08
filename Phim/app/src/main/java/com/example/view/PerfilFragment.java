package com.example.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.ActorDetalle;
import com.example.model.Movie;
import com.example.wpenia.phim.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private static final String KEY_TITULO = "titulo";
    private static final String KEY_ANIO = "anio";
    private static final String KEY_RATED = "rated";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_DIRECTOR = "director";
    private static final String KEY_ESCRITOR = "escritor";
    private static final String KEY_PLOT = "plot";
    private static final String KEY_PREMIOS = "premios";
    private static final String KEY_ORIGEN = "origen";
    private static final String KEY_META = "meta";
    private static final String KEY_DURACION = "duracion";
    private static final String KEY_IMAGEN = "imagen";
    private static final String KEY_SCORE = "score";

    public static PerfilFragment fabrica(Movie dato){

        PerfilFragment fragment = new PerfilFragment();

        Bundle bundle = new Bundle();

        bundle.putString(PerfilFragment.KEY_TITULO, dato.getTitle());
        bundle.putString(PerfilFragment.KEY_ANIO, dato.getYear());
        bundle.putString(PerfilFragment.KEY_RATED, dato.getRated());
        bundle.putString(PerfilFragment.KEY_GENRE, dato.getGenre());
        bundle.putString(PerfilFragment.KEY_DIRECTOR, dato.getDirector());
        bundle.putString(PerfilFragment.KEY_ESCRITOR, dato.getWriters());
        bundle.putString(PerfilFragment.KEY_PLOT, dato.getPlot());
        bundle.putString(PerfilFragment.KEY_PREMIOS, dato.getAwards());
        bundle.putString(PerfilFragment.KEY_ORIGEN, dato.getCountryOrigin());
        bundle.putString(PerfilFragment.KEY_META, dato.getMetaScore());
        bundle.putString(PerfilFragment.KEY_DURACION, dato.getDuration());
        bundle.putInt(PerfilFragment.KEY_IMAGEN, dato.getImage());
        bundle.putString(PerfilFragment.KEY_SCORE, dato.getImbdScore());
        fragment.setArguments(bundle);

        return fragment;
    }


    public PerfilFragment() {
        // Required empty public constructor
    }


   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        // Obtengo el bundle
        Bundle bundle = getArguments();
        // Datos
        String titulo = bundle.getString(KEY_TITULO);
        String anio = bundle.getString(KEY_ANIO);
        String rated = bundle.getString(KEY_RATED);
        String genre = bundle.getString(KEY_GENRE);
        String director = bundle.getString(KEY_DIRECTOR);
        String escritor = bundle.getString(KEY_ESCRITOR);
        String plot = bundle.getString(KEY_PLOT);
        String premios = bundle.getString(KEY_PREMIOS);
        String origen = bundle.getString(KEY_ORIGEN);
        String meta = bundle.getString(KEY_META);
        String duracion = bundle.getString(KEY_DURACION);
        Integer imagen = bundle.getInt(KEY_IMAGEN);
       String score = bundle.getString(KEY_SCORE);

        // Busco componentes
        TextView tituloView = view.findViewById(R.id.tituloPelicula);
        TextView fecha = view.findViewById(R.id.fecha);
        TextView ratedView = view.findViewById(R.id.duracion);
        TextView generoView = view.findViewById(R.id.genero);
        TextView directorView = view.findViewById(R.id.duracion);
        TextView writerView = view.findViewById(R.id.duracion);
        TextView actoresView = view.findViewById(R.id.actoresRecycler);
        TextView plotView = view.findViewById(R.id.rating);
        TextView premiosView = view.findViewById(R.id.premiosNumero);
        TextView origenView = view.findViewById(R.id.premiosNumero);
        TextView metaView = view.findViewById(R.id.rating);
        TextView duracionView = view.findViewById(R.id.duracion);
       ImageView imageView = view.findViewById(R.id.imagenVideo);
        TextView scoreView = view.findViewById(R.id.ratingNumero);







        // Seteo los datos
        tituloView.setText(titulo);
        fecha.setText(anio);
        ratedView.setText(rated);
        generoView.setText(genre);
        directorView.setText(director);
        writerView.setText(escritor);
        actoresView.setText(actores);
        plotView.setText(plot);
        premiosView.setText(premios);
        origenView.setText(origen);
        metaView.setText(meta);
        duracionView.setText(duracion);
        imageView.setImageResource(imagen);
        scoreView.setText(score);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
