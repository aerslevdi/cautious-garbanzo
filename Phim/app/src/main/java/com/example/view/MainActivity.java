package com.example.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.controller.CategoriasController;
import com.example.helper.SimpleItemTouchHelperCallBack;
import com.example.model.Categoria;
import com.example.theme.ThemeUtils;
import com.example.wpenia.phim.R;

public class MainActivity extends AppCompatActivity implements CategoriaAdapter.OnItemViewSelected{

    public CategoriaAdapter.OnItemViewSelected listener;
    private CategoriaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        //ThemeUtils.onActivityCreateSetTheme(this);
        this.setTheme(R.style.GreyTheme);
        setContentView(R.layout.activity_main);

        CategoriasController categoriasController=new CategoriasController();
        Context context = this;
        this.listener= (CategoriaAdapter.OnItemViewSelected) context;

        RecyclerView recyclerView =findViewById(R.id.recyclerViewIncio);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        this.adapter = new CategoriaAdapter(categoriasController.getCategorias(),listener);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallBack(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        /*Button btnInfantiles = findViewById(R.id.btnInfantiles);

        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.clockwise);
        image.startAnimation(animation1);

        btnInfantiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CategoriaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("categoria", "infantil");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Button btnAdultos = findViewById(R.id.btnAdultos);

        btnAdultos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CategoriaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("categoria", "adultos");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });*/
    }

    public void zoom(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.clockwise);
        image.startAnimation(animation1);
    }

    public void move(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }

    public void blink(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
    }

    @Override
    public void click(Categoria categoria) {

        Intent intent=new Intent(MainActivity.this, CategoriaActivity.class);
        Bundle bundle = new Bundle();
        String categoriaSelected="Infantil";

        String categoriaTitulo = categoria.getTitulo();
        switch (categoriaTitulo) {
            case "Peliculas":
                categoriaSelected="Infantil";
                break;
            case "Series":
                categoriaSelected="Adulto";
                break;
        }

        bundle.putString("categoria", categoriaSelected);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
