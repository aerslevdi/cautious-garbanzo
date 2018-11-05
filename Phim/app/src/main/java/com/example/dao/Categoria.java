package com.example.wpenia.phim;


import java.util.ArrayList;
import java.util.List;

public class Categoria {
    List<Pelicula> peliculasInfantiles = new ArrayList();
    List<Pelicula> peliculasAdultos = new ArrayList();
    List<Pelicula> peliculasDocumentales = new ArrayList();
    List<Pelicula> peliculasComics = new ArrayList();

    public Categoria() {

        this.categoriaInfantiles();
        this.categoriaAdultos();


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

    public List<Pelicula> getPeliculasInfantiles() {
        return peliculasInfantiles;
    }

    public List<Pelicula> getPeliculasAdultos() {
        return peliculasAdultos;
    }
}
