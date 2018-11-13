package com.example.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.PeliculaOld;
import com.example.wpenia.phim.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilPeliculaFragment extends Fragment {
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
    private static final String KEY_SCORE = "score";
    private static final String KEY_TRAILER = "trailer";


    public PerfilPeliculaFragment() {
        // Required empty public constructor
    }

    public static PerfilPeliculaFragment perfilFabrica(PeliculaOld dato){
        PerfilPeliculaFragment fragment = new PerfilPeliculaFragment();

        Bundle bundle = new Bundle();

        bundle.putString(PerfilPeliculaFragment.KEY_TITULO, dato.getNombre());
        bundle.putString(PerfilPeliculaFragment.KEY_ANIO, dato.getYear());
        bundle.putString(PerfilPeliculaFragment.KEY_RATED, dato.getRated());
        bundle.putString(PerfilPeliculaFragment.KEY_GENRE, dato.getGenre());
        bundle.putString(PerfilPeliculaFragment.KEY_DIRECTOR, dato.getDirector());
        bundle.putString(PerfilPeliculaFragment.KEY_ESCRITOR, dato.getWriters());
        bundle.putString(PerfilPeliculaFragment.KEY_PLOT, dato.getPlot());
        bundle.putString(PerfilPeliculaFragment.KEY_PREMIOS, dato.getAwards());
        bundle.putString(PerfilPeliculaFragment.KEY_ORIGEN, dato.getCountryOrigin());
        bundle.putString(PerfilPeliculaFragment.KEY_META, dato.getMetaScore());
        bundle.putString(PerfilPeliculaFragment.KEY_DURACION, dato.getDuration());
        bundle.putInt(PerfilPeliculaFragment.KEY_TRAILER, dato.getTrailer());
        bundle.putString(PerfilPeliculaFragment.KEY_SCORE, dato.getImbdScore());
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil_pelicula, container, false);
        // Obtengo el bundle
        Bundle bundle = getArguments();
        // Datos
        String titulo = bundle.getString(KEY_TITULO);
        String anio = bundle.getString(KEY_ANIO);
        String rate = bundle.getString(KEY_RATED);
        String genre = bundle.getString(KEY_GENRE);
        String director = bundle.getString(KEY_DIRECTOR);
        String escritor = bundle.getString(KEY_ESCRITOR);
        String plot = bundle.getString(KEY_PLOT);
        String premios = bundle.getString(KEY_PREMIOS);
        String origen = bundle.getString(KEY_ORIGEN);
        String meta = bundle.getString(KEY_META);
        String duracion = bundle.getString(KEY_DURACION);
        Integer trailer = bundle.getInt(KEY_TRAILER);
        String score = bundle.getString(KEY_SCORE);

        // Busco componentes
        TextView tituloView = view.findViewById(R.id.tituloPelicula);
        TextView generoView = view.findViewById(R.id.genero);
        TextView duracionView = view.findViewById(R.id.duracion);
        TextView fechaView = view.findViewById(R.id.fecha);
        TextView scoreView = view.findViewById(R.id.scoreNumero);
        TextView metaView = view.findViewById(R.id.scoreMeta);
        TextView premiosView = view.findViewById(R.id.premiosNumero);

        ImageView trailerView = view.findViewById(R.id.imagenVideo);



        // Seteo los datos
        tituloView.setText(titulo);
        trailerView.setImageResource(trailer);
        generoView.setText(genre);
        duracionView.setText(duracion);
        fechaView.setText(anio);
        scoreView.setText(score);
        metaView.setText(meta);
        premiosView.setText(premios);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
