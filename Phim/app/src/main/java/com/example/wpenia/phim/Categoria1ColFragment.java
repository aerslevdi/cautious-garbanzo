package com.example.wpenia.phim;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Categoria1ColFragment extends Fragment  implements PeliculaAdapter.Receptor  {


    public Categoria1ColFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_categoria1_col, container, false);
        Bundle bundle = getArguments();
        String categoria = bundle.getString("categoria");
        Integer columnas = bundle.getInt("columnas");

        RecyclerView recyclerViewPantalla= view.findViewById(R.id.recyclerViewCategoria1);
        Categoria categorias = new Categoria();
        List<Pelicula> peliculas = new ArrayList();
        switch (categoria){
            case "infantil":
                peliculas=categorias.getPeliculasInfantiles();
                break;
            case "adultos":
                peliculas=categorias.getPeliculasAdultos();
                break;
            default:
                peliculas=categorias.getPeliculasInfantiles();
                break;
        }

        PeliculaAdapter peliculaAdapter=  new PeliculaAdapter(this, peliculas);
        recyclerViewPantalla.setAdapter(peliculaAdapter);

        //RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false);
        //recyclerViewPantalla.setLayoutManager(layoutManager);

        // Grid Layout Manager
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(container.getContext(), 1);
        recyclerViewPantalla.setLayoutManager(mGridLayoutManager);

        recyclerViewPantalla.setHasFixedSize(true);

        return view;




    }

    @Override
    public void recibir(Pelicula pelicula) {
        Intent intent=new Intent(this.getActivity(), Main2Activity.class );

        Bundle bundle= new Bundle();
        bundle.putString(Main2Activity.KEY_NOMBRE,pelicula.getNombre());
        bundle.putInt(Main2Activity.KEY_IMAGEN,pelicula.getImagen());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
