package com.example.dao;

import com.example.model.Categoria;
import com.example.model.PeliculaOld;
import com.example.view.Pelicula;
import com.example.wpenia.phim.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wpenia on 11/11/18.
 */

public class MoviesDao {
    List<Pelicula> peliculasPelicula = new ArrayList();
    List<Pelicula> peliculasInfantiles = new ArrayList();
    List<Pelicula> peliculasAventura = new ArrayList();
    List<Pelicula> peliculasSeries = new ArrayList();
    List<Categoria> categorias = new ArrayList();


    private static MoviesDao instance;

    private MoviesDao(){
        this.categoriaPeliculas();
        this.categoriaSeries();
        this.categoriaAventura();
        this.categoriaInfantiles();
        this.categoriasInicio();
    }

    public static synchronized MoviesDao getInstance(){
        if(instance == null){
            instance = new MoviesDao();
        }
        return instance;
    }


    private void categoriaInfantiles(){
        peliculasInfantiles.add(new Pelicula("Finding Nemo", 1, R.drawable.movie1infantiles));
        peliculasInfantiles.add(new Pelicula("High Scholl Musical",1, R.drawable.movie2infantiles));
        peliculasInfantiles.add(new Pelicula("Maleficcent", 1, R.drawable.movie3infantiles));
        peliculasInfantiles.add(new Pelicula("Los Increibles 2",1,  R.drawable.movie4infantiles));
        peliculasInfantiles.add(new Pelicula("Los Increibles", 1, R.drawable.movie5infantiles));
        peliculasInfantiles.add(new Pelicula("Intensamente", 1,R.drawable.movie6infantiles));
        peliculasInfantiles.add(new Pelicula("Gemelas", 1,R.drawable.movie7infantiles));
        peliculasInfantiles.add(new Pelicula("Mini Espeias", 1,R.drawable.movie8infantiles));
        peliculasInfantiles.add(new Pelicula("Tangled", 1,R.drawable.movie9infantiles));
        peliculasInfantiles.add(new Pelicula("Coco", 1,R.drawable.movie10infantiles));
    }

    private void categoriaPeliculas(){
        peliculasPelicula.add(new Pelicula("Star Wars Jedi", 1,R.drawable.movie1aventura));
        peliculasPelicula.add(new Pelicula("Star Wars",1, R.drawable.movie2aventura));
        peliculasPelicula.add(new Pelicula("Batman", 1,R.drawable.movie3aventura));
        peliculasPelicula.add(new Pelicula("Batman v Superman",1, R.drawable.movie4aventura));
        peliculasPelicula.add(new Pelicula("El Zorro", 1,R.drawable.movie5aventura));
        peliculasPelicula.add(new Pelicula("El Zorro La mascara", 1, R.drawable.movie6aventura));
        peliculasPelicula.add(new Pelicula("Avengers", 1,R.drawable.movie7aventura));
        peliculasPelicula.add(new Pelicula("Superman Returns",1, R.drawable.movie8aventura));
        peliculasPelicula.add(new Pelicula("Spider-Man", 1,R.drawable.movie9aventura));
        peliculasPelicula.add(new Pelicula("Captain america", 1, R.drawable.movie10aventura));
    }

    private void categoriaSeries(){
        peliculasSeries.add(new Pelicula("Suits",1, R.drawable.series1));
        peliculasSeries.add(new Pelicula("The Crown", 1,R.drawable.series2));
        peliculasSeries.add(new Pelicula("13 Reasons Why", 1,R.drawable.series3));
        peliculasSeries.add(new Pelicula("The last Kingdom",1, R.drawable.series4));
        peliculasSeries.add(new Pelicula("Maniac", 1,R.drawable.series5));
        peliculasSeries.add(new Pelicula("House of Cards", 1,R.drawable.series6));
        peliculasSeries.add(new Pelicula("Luis Miguel", 1,R.drawable.series7));
        peliculasSeries.add(new Pelicula("Stranger Things",1, R.drawable.series8));
        peliculasSeries.add(new Pelicula("Narcos", 1,R.drawable.series9));
        peliculasSeries.add(new Pelicula("The Sopranos", 1,R.drawable.series10));
    }

    private void categoriaAventura(){
        peliculasAventura.add(new Pelicula("Star Wars Jedi", 1,R.drawable.movie1aventura));
        peliculasAventura.add(new Pelicula("Star Wars",1, R.drawable.movie2aventura));
        peliculasAventura.add(new Pelicula("Batman", 1,R.drawable.movie3aventura));
        peliculasAventura.add(new Pelicula("Batman v Superman",1, R.drawable.movie4aventura));
        peliculasAventura.add(new Pelicula("El Zorro", 1,R.drawable.movie5aventura));
        peliculasAventura.add(new Pelicula("El Zorro La mascara", 1, R.drawable.movie6aventura));
        peliculasAventura.add(new Pelicula("Avengers", 1,R.drawable.movie7aventura));
        peliculasAventura.add(new Pelicula("Superman Returns",1, R.drawable.movie8aventura));
        peliculasAventura.add(new Pelicula("Spider-Man", 1,R.drawable.movie9aventura));
        peliculasAventura.add(new Pelicula("Captain america", 1, R.drawable.movie10aventura));
    }

    public void categoriasInicio(){
        categorias.add(new Categoria("Peliculas", R.drawable.holmes1));
        categorias.add(new Categoria("Series", R.drawable.strangerthings));
        categorias.add(new Categoria("Infantiles", R.drawable.up));
        categorias.add(new Categoria("Aventura", R.drawable.avengers));
        categorias.add(new Categoria("Fantasticas", R.drawable.senordelosanillos));
    }

    public List<Pelicula> getPeliculas(Integer codigo) {
        switch (codigo) {
            case 1:
                return getPeliculasAventura();
            case 2:
                return getPeliculasSeries();
            case 3:
                return getPeliculasInfantiles();
            case 4:
                return getPeliculasPeliculaOlds();
            default:
                return getPeliculasInfantiles();
        }
    }

    public List<Pelicula> getPeliculasPeliculaOlds() {
        return peliculasPelicula;
    }
    public List<Pelicula> getPeliculasAventura() {
        return peliculasAventura;
    }
    public List<Pelicula> getPeliculasInfantiles() {
        return peliculasInfantiles;
    }
    public List<Pelicula> getPeliculasSeries() {
        return peliculasSeries;
    }
    public List<Categoria> getCategorias() { return categorias; }


}
