package com.example.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wpenia.phim.R;

public class CategoriaActivity extends AppCompatActivity {
    private String categoria;
    private Integer columnas=2;
    private Bundle bundle;
    private Intent intent;
    private Categoria2ColFragment categoriaFragment;
    private Categoria1ColFragment categoria1Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        intent = getIntent();
        bundle = intent.getExtras();


        bundle.putInt("columnas",columnas);
        intent.putExtras(bundle);


        this.categoria= bundle.getString("categoria");


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                columnas=(columnas==1)?2:1;
                bundle.putInt("columnas",columnas);
                intent.putExtras(bundle);

                if (columnas==1) {
                    categoria1Fragment.setArguments(bundle);
                    reemplazarFragment(categoria1Fragment);
                }else{
                    categoriaFragment.setArguments(bundle);
                    reemplazarFragment(categoriaFragment);
                }

                Toast.makeText(CategoriaActivity.this, categoria + ".." + columnas, Toast.LENGTH_SHORT).show();
            }
        });
        categoria1Fragment = new Categoria1ColFragment();
        // FRAGMENTS
        // TODO (8) Crear una instancia del fragmento con dos columnas
       categoriaFragment = new Categoria2ColFragment();

        // Comunicacion entre Fragments
        // TODO (9) Agregar el Bundle a la instancia del WelcomeFragment
        categoriaFragment.setArguments(bundle);

        this.reemplazarFragment(categoriaFragment);

        /*
        // Fragments
        // TODO (10) Pedirle al CategoriaActivity su FragmentManager
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     FragmentManager fragmentManager = getSupportFragmentManager();
        // TODO (11) Pedirle al FragmentManager una transacción
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // TODO (12) Configurar la transacción, es decir, decirle que tiene que hacer.
        fragmentTransaction.add(R.id.fragmento, categoriaFragment);
        // TODO (13) Largar la transacción
        fragmentTransaction.commit();
       */

    }

    private void reemplazarFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmento, fragment);
        fragmentTransaction.commit();
    }
}
