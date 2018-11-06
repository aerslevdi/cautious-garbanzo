package com.example.david.pantallacategoriasfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TipoPeliculaAdapter.AdapterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<TipoPelicula> listaPelicula = new ArrayList<>();
        listaPelicula.add(new TipoPelicula("cienciaFiccion", R.drawable.cienciaficcion));
        listaPelicula.add(new TipoPelicula("CineArte",R.drawable.arte));
        listaPelicula.add(new TipoPelicula("Infalntil", R.drawable.infantil));
        listaPelicula.add(new TipoPelicula("Adultos",R.drawable.adultos));
        listaPelicula.add(new TipoPelicula("Terror",R.drawable.terror));

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCategorias);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        TipoPeliculaAdapter tipoPeliculaAdapter = new TipoPeliculaAdapter(this, listaPelicula);
        recyclerView.setAdapter(tipoPeliculaAdapter);

    }

    @Override
    public void irDetalle(TipoPelicula tipoPelicula) {
        Intent intent = new Intent(this,DetallePeliculaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(DetallePeliculaActivity.KEY_NOMBRE,tipoPelicula.getNombre());
        bundle.putInt(DetallePeliculaActivity.KEY_IMAGEN,tipoPelicula.getImagen());

        intent.putExtras(bundle);
        startActivity(intent);


    }
}
