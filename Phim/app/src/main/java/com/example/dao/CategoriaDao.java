package com.example.dao;


import com.example.model.Categoria;
import com.example.model.PeliculaOld;
import com.example.wpenia.phim.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    List<PeliculaOld> peliculasInfantiles = new ArrayList();
    List<PeliculaOld> peliculasAdultos = new ArrayList();
    List<PeliculaOld> peliculasDocumentales = new ArrayList();
    List<PeliculaOld> peliculasComics = new ArrayList();
    List<Categoria> categorias = new ArrayList();


    public CategoriaDao() {

        this.categoriaInfantiles();
        this.categoriaAdultos();
        this.categoriasInicio();

    }


    private void categoriaInfantiles(){
        peliculasInfantiles.add(new PeliculaOld("Ant-Man", R.drawable.antman));
        peliculasInfantiles.add(new PeliculaOld("Aladin", R.drawable.aladin));
        peliculasInfantiles.add(new PeliculaOld("Hotel", R.drawable.hoteltransilvania));
        peliculasInfantiles.add(new PeliculaOld("Cars", R.drawable.cars));
        peliculasInfantiles.add(new PeliculaOld("El Rey Leon", R.drawable.reyleon));
        peliculasInfantiles.add(new PeliculaOld("Frozen", R.drawable.frozen));
        peliculasInfantiles.add(new PeliculaOld("Frozen 2", R.drawable.frozen2));
        peliculasInfantiles.add(new PeliculaOld("Kunfu Panda", R.drawable.kunfupanda));
    }

    private void categoriaAdultos(){
        peliculasAdultos.add(new PeliculaOld("Iron Man 1", R.drawable.iron1));
        peliculasAdultos.add(new PeliculaOld("Iron Man 2", R.drawable.iron2));
        peliculasAdultos.add(new PeliculaOld("Spiderman", R.drawable.spiderman));
        peliculasAdultos.add(new PeliculaOld("Cap.America", R.drawable.captain));
        peliculasAdultos.add(new PeliculaOld("Infinity", R.drawable.infinity));
        peliculasAdultos.add(new PeliculaOld("Was", R.drawable.wasp));
    }

    public void categoriasInicio(){
        categorias.add(new Categoria("Peliculas", R.drawable.holmes1));
        categorias.add(new Categoria("Series", R.drawable.strangerthings));
        categorias.add(new Categoria("Infantiles", R.drawable.up));
        categorias.add(new Categoria("Aventura", R.drawable.avengers));
        categorias.add(new Categoria("Fantasticas", R.drawable.senordelosanillos));
    }


    public List<PeliculaOld> getPeliculasInfantiles() {
        return peliculasInfantiles;
    }

    public List<PeliculaOld> getPeliculasAdultos() {
        return peliculasAdultos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}
