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
public class Categoria2ColFragment extends Fragment implements PeliculaOldAdapter.Receptor {


    public Categoria2ColFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        container.getContext().setTheme(R.style.GreyTheme);
        View view = inflater.inflate(R.layout.fragment_categoria2_col, container, false);
        Bundle bundle = getArguments();
        Integer categoria = bundle.getInt(KEY_CATEGORIA);
        Integer columnas = bundle.getInt(KEY_CANTIDAD_COLUMNAS);

        RecyclerView recyclerViewPantalla= view.findViewById(R.id.recyclerViewCategoria);
        CategoriaDao categorias = new CategoriaDao();
        List<PeliculaOld> peliculaOlds = new ArrayList();


        PeliculaOldAdapter peliculaOldAdapter =  new PeliculaOldAdapter(this, peliculaOlds,R.layout.item_pelicula);
        recyclerViewPantalla.setAdapter(peliculaOldAdapter);

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
    public void recibir(PeliculaOld peliculaOld) {
        Intent intent=new Intent(this.getActivity(), Main2Activity.class );

        Bundle bundle= new Bundle();
        bundle.putString(Main2Activity.KEY_NOMBRE, peliculaOld.getNombre());
        bundle.putInt(Main2Activity.KEY_IMAGEN, peliculaOld.getImagen());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
