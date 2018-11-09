package com.example.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wpenia.phim.R;

public class Main2Activity extends AppCompatActivity {
    public static final String KEY_NOMBRE="nombre";
    public static final String KEY_IMAGEN="imagen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String nombre = bundle.getString(KEY_NOMBRE);
        Integer imagen= bundle.getInt(KEY_IMAGEN);

        TextView textView= findViewById(R.id.titleDetalle);
        ImageView imageView = findViewById(R.id.imageViewImagenDetalle);

        textView.setText(nombre);
        imageView.setImageResource(imagen);

    }
}
