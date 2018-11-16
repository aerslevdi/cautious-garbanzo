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
    DAOActores daoActores = new DAOActores();


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
        peliculasInfantiles.add(new Pelicula("Finding Nemo", "2003","PG","30-05-2003", "100 min", "Animation","Andrew Stanton", "Andrew Stanton, Bob Peterson, David Reynolds", daoActores.getActores(), "After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.", "English","17", "USA", R.drawable.movie1infantiles, "8,1/10", "90", "5",1, "Film", R.drawable.findingnemo));
        peliculasInfantiles.add(new Pelicula("High School Musical", "2006", "PG", "20-01-2006", "98 min","Musical","Kenny Ortega","Peter Barsocchini",daoActores.getActores(),"A popular high school athlete and an academically gifted girl get roles in the school musical and develop a friendship that threatens East High's social order.","English", "9","USA", R.drawable.movie2infantiles, "5,3/10","N/A", "3", 2, "Film", R.drawable.hsmtrailer));
        peliculasInfantiles.add(new Pelicula("Maleficent", "2014", "PG", "28-05-2014","97 min","Dark Fantasy","Robert Stromberg","Linda Woolverton", daoActores.getActores(),"A vengeful fairy is driven to curse an infant princess, only to discover that the child may be the one person who can restore peace to their troubled land.","English", "10","USA", R.drawable.movie3infantiles,"7/10","56","8",3,"Film", R.drawable.maleficenttrailer));
        peliculasInfantiles.add(new Pelicula("Los Increibles 2", "2018","G","05-06-2018","118 min", "Animation","Brad Bird","Brad Bird",daoActores.getActores(),"Bob Parr (Mr. Incredible) is left to care for the kids while Helen (Elastigirl) is out saving the world.","English","3","USA",  R.drawable.movie4infantiles,"7,9/10","80","8",4, "Film", R.drawable.incrediblestwo));
        peliculasInfantiles.add(new Pelicula("Los Increibles","2004","G","27-10-2004","115 min", "Animation","Brad Bird","Brad Bird", daoActores.getActores(),"A family of undercover superheroes, while trying to live the quiet suburban life, are forced into action to save the world.","English","67", "USA", R.drawable.movie5infantiles, "8/10","90","9",5,"Film", R.drawable.incrediblestrailer));
        peliculasInfantiles.add(new Pelicula("Intensamente","2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie6infantiles,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasInfantiles.add(new Pelicula("Juego de Gemelas",R.drawable.movie7infantiles));
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
