package com.example.david.pantallacategoriasfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class DetallePeliculaActivity extends AppCompatActivity {

    public static final String KEY_NOMBRE = "keyNombre";
    public static final String KEY_IMAGEN ="keyImagen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nombre = bundle.getString(KEY_NOMBRE);
        Integer imagen = bundle.getInt(KEY_IMAGEN);

        ImageView imageViewImagen = findViewById(R.id.imageViewItem);

        imageViewImagen.setImageResource(imagen);


    }


}

