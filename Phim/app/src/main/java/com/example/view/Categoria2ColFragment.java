package com.example.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dao.CategoriaDao;
import com.example.model.Pelicula;
import com.example.wpenia.phim.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Categoria2ColFragment extends Fragment implements PeliculaAdapter.Receptor {


    public Categoria2ColFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria2_col, container, false);
        Bundle bundle = getArguments();
        String categoria = bundle.getString("categoria");
        Integer columnas = bundle.getInt("columnas");

        RecyclerView recyclerViewPantalla= view.findViewById(R.id.recyclerViewCategoria);
        CategoriaDao categorias = new CategoriaDao();
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
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(container.getContext(), columnas);
        recyclerViewPantalla.setLayoutManager(mGridLayoutManager);

        recyclerViewPantalla.setHasFixedSize(true);

        return view;
    }

    /*private void reemplazarFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }*/




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
