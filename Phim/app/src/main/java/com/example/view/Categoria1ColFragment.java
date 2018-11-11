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
import com.example.model.PeliculaOld;
import com.example.wpenia.phim.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.view.CategoriaActivity.KEY_CANTIDAD_COLUMNAS;
import static com.example.view.CategoriaActivity.KEY_CATEGORIA;


/**
 * A simple {@link Fragment} subclass.
 */
public class Categoria1ColFragment extends Fragment  implements PeliculaOldAdapter.Receptor  {
    private int xmlView =R.layout.item_pelicula ;

    public Categoria1ColFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        container.getContext().setTheme(R.style.GreyTheme);
        View view = inflater.inflate(R.layout.fragment_categoria1_col, container, false);
        Bundle bundle = getArguments();
        Integer categoria = bundle.getInt(KEY_CATEGORIA);
        Integer columnas = bundle.getInt(KEY_CANTIDAD_COLUMNAS);

        switch (columnas){
            default:
            case 1:
                xmlView =R.layout.item_pelicula;
                break;
            case 2:
                xmlView =R.layout.item_pelicula;
                break;
        }

        RecyclerView recyclerViewPantalla= view.findViewById(R.id.recyclerViewCategoria1);
        CategoriaDao categorias = new CategoriaDao();
        List<PeliculaOld> peliculaOlds = new ArrayList();
        switch (categoria){
            case 1:
                peliculaOlds =categorias.getPeliculasInfantiles();
                break;
            case 2:
                peliculaOlds =categorias.getPeliculasAdultos();
                break;
            case 3:
                peliculaOlds =categorias.getPeliculasAdultos();
                break;
            default:
                peliculaOlds =categorias.getPeliculasInfantiles();
                break;
        }

        PeliculaOldAdapter peliculaOldAdapter =  new PeliculaOldAdapter(this, peliculaOlds,this.xmlView );
        recyclerViewPantalla.setAdapter(peliculaOldAdapter);

        //RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false);
        //recyclerViewPantalla.setLayoutManager(layoutManager);

        // Grid Layout Manager
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(container.getContext(), columnas);
        recyclerViewPantalla.setLayoutManager(mGridLayoutManager);

        recyclerViewPantalla.setHasFixedSize(true);
        return view;
    }

    @Override
    public void recibir(PeliculaOld peliculaOld) {
        Intent intent=new Intent(this.getActivity(), Main2Activity.class );

        Bundle bundle= new Bundle();
        bundle.putString(Main2Activity.KEY_NOMBRE, peliculaOld.getNombre());
        bundle.putInt(Main2Activity.KEY_IMAGEN, peliculaOld.getImagen());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
