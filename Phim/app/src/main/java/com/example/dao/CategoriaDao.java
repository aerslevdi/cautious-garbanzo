package com.example.dao;


import com.example.model.Categoria;
import com.example.model.Pelicula;
import com.example.wpenia.phim.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    List<Pelicula> peliculasInfantiles = new ArrayList();
    List<Pelicula> peliculasAdultos = new ArrayList();
    List<Pelicula> peliculasDocumentales = new ArrayList();
    List<Pelicula> peliculasComics = new ArrayList();
    List<Categoria> categorias = new ArrayList();


    public CategoriaDao() {

        this.categoriaInfantiles();
        this.categoriaAdultos();
        this.categoriasInicio();

    }


    private void categoriaInfantiles(){
        peliculasInfantiles.add(new Pelicula("Ant-Man", R.drawable.antman));
        peliculasInfantiles.add(new Pelicula("Aladin", R.drawable.aladin));
        peliculasInfantiles.add(new Pelicula("Hotel", R.drawable.hoteltransilvania));
        peliculasInfantiles.add(new Pelicula("Cars", R.drawable.cars));
        peliculasInfantiles.add(new Pelicula("El Rey Leon", R.drawable.reyleon));
        peliculasInfantiles.add(new Pelicula("Frozen", R.drawable.frozen));
        peliculasInfantiles.add(new Pelicula("Frozen 2", R.drawable.frozen2));
        peliculasInfantiles.add(new Pelicula("Kunfu Panda", R.drawable.kunfupanda));
    }

    private void categoriaAdultos(){
        peliculasAdultos.add(new Pelicula("Iron Man 1", R.drawable.iron1));
        peliculasAdultos.add(new Pelicula("Iron Man 2", R.drawable.iron2));
        peliculasAdultos.add(new Pelicula("Spiderman", R.drawable.spiderman));
        peliculasAdultos.add(new Pelicula("Cap.America", R.drawable.captain));
        peliculasAdultos.add(new Pelicula("Infinity", R.drawable.infinity));
        peliculasAdultos.add(new Pelicula("Was", R.drawable.wasp));
    }

    public void categoriasInicio(){
        categorias.add(new Categoria("Peliculas", R.drawable.holmes1));
        categorias.add(new Categoria("Series", R.drawable.strangerthings));
        categorias.add(new Categoria("Infantiles", R.drawable.up));
        categorias.add(new Categoria("Aventura", R.drawable.avengers));
        categorias.add(new Categoria("Fantasticas", R.drawable.senordelosanillos));
    }


    public List<Pelicula> getPeliculasInfantiles() {
        return peliculasInfantiles;
    }

    public List<Pelicula> getPeliculasAdultos() {
        return peliculasAdultos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}
