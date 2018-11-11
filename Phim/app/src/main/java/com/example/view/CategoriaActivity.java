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

import com.example.dao.MoviesDao;
import com.example.wpenia.phim.R;

public class CategoriaActivity extends AppCompatActivity {
    private Integer categoria;
    private Integer columnas=2;
    private Bundle bundle;
    private Intent intent;
    final static String KEY_CANTIDAD_COLUMNAS="key_columnas";
    final static String KEY_CATEGORIA="key_categoria";

    private Categoria2ColFragment categoriaFragment;
    private Categoria1ColFragment categoria1Fragment;
    private CategoriaDosColumFragment categoriaDosColumFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(R.style.GreyTheme);
        setContentView(R.layout.activity_categoria);

        MoviesDao moviesDao= MoviesDao.getInstance();

        intent = getIntent();
        bundle = intent.getExtras();
        this.columnas=2;    //Inicia con 2 columnas
        this.categoria = bundle.getInt(KEY_CATEGORIA);

        intent = getIntent();
        bundle = intent.getExtras();
        bundle.putInt(KEY_CATEGORIA,categoria);
        bundle.putInt(KEY_CANTIDAD_COLUMNAS,columnas);
        intent.putExtras(bundle);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                columnas=(columnas==1)?2:1;


                if (columnas==1) {
                    fab.setImageResource(R.drawable.ic_apps_black_24dp);
                    //categoria1Fragment.setArguments(bundle);
                    //reemplazarFragment(categoria1Fragment);
                }else{
                    fab.setImageResource(R.drawable.ic_view_headline_black_24dp);
                    //categoriaDosColumFragment.setArguments(bundle);
                    //reemplazarFragment(categoriaDosColumFragment);
                }

                categoriaDosColumFragment.onDestroy();
                categoriaDosColumFragment= new CategoriaDosColumFragment();
                Bundle bundle=new Bundle();
                bundle.putInt(KEY_CANTIDAD_COLUMNAS,columnas);
                bundle.putInt(KEY_CATEGORIA, categoria);
                categoriaDosColumFragment.setArguments(bundle);
                reemplazarFragment(categoriaDosColumFragment);

                Toast.makeText(CategoriaActivity.this, categoria + ".." + columnas, Toast.LENGTH_SHORT).show();
            }
        });
        // Crear Fragmentos
        categoria1Fragment = new Categoria1ColFragment();
        categoriaFragment = new Categoria2ColFragment();
        categoriaDosColumFragment= new CategoriaDosColumFragment();

        // Agregar bundle
        categoriaDosColumFragment.setArguments(bundle);
        this.reemplazarFragment(categoriaDosColumFragment);
    }

    private void reemplazarFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmento, fragment);
        fragmentTransaction.commit();
    }
}