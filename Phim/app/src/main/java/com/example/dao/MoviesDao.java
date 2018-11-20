package com.example.dao;

import com.example.model.Categoria;
import com.example.model.Movie;
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
        peliculasInfantiles.add(new Pelicula("Juego de Gemelas", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie7infantiles, "8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasInfantiles.add(new Pelicula("Mini Espeias", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie8infantiles, "8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasInfantiles.add(new Pelicula("Tangled", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA" ,R.drawable.movie9infantiles, "8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasInfantiles.add(new Pelicula("Coco",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie10infantiles, "8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
    }

    private void categoriaPeliculas(){
        peliculasPelicula.add(new Pelicula("Star Wars Jedi",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie1aventura, "8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasPelicula.add(new Pelicula("Star Wars", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.movie2aventura, "8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasPelicula.add(new Pelicula("Batman",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie3aventura, "8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasPelicula.add(new Pelicula("Batman vs Superman", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.movie4aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasPelicula.add(new Pelicula("El Zorro",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie5aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasPelicula.add(new Pelicula("La mascara del Zorro",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.movie6aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasPelicula.add(new Pelicula("Infinity Wars","2018","PG-13","23-04-2018", "149 min","Action", "Anthony Russo, Joe Russo", "Christopher Markus, Stephen McFeely", daoActores.getActores(), "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain. ", "English", "2", "USA", R.drawable.movie7aventura, "8,6/10","68","10", 2, "Film",  R.drawable.videoimg));
        peliculasPelicula.add(new Pelicula("Superman Returns", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.movie8aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasPelicula.add(new Pelicula("Spideman","2017","PG-13", "28-06-2017", "133 min","Action", "Jon Watts", "Jonathan Goldstein, John Francis Daley ", daoActores.getActores(), "Peter Parker balances his life as an ordinary high school student in Queens with his superhero alter-ego Spider-Man, and finds himself on the trail of a new menace prowling the skies of New York City.", "English","5", "USA", R.drawable.movie9aventura, "7,5/10","73", "3",12,"Film",  R.drawable.spideytrailer));
        peliculasPelicula.add(new Pelicula( "Capitan America","2011","PG-13", "19-04-2011", "124 min","Action", "Joe Johnston", "Christopher Markus (screenplay), Stephen McFeely", daoActores.getActores(), "Steve Rogers, a rejected military soldier transforms into Captain America after taking a dose of a Super-Soldier serum. But being Captain America comes at a price as he attempts to take down a war monger and a terrorist organization.", "English","3", "USA",R.drawable.movie10aventura,"6,9/10","66","8", 13,"Film", R.drawable.captamericatrailer));
    }

    private void categoriaSeries(){
        peliculasSeries.add(new Pelicula("Suits", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.series1,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasSeries.add(new Pelicula("The Crown",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.series2,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasSeries.add(new Pelicula("13 Reasons Why",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.series3,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasSeries.add(new Pelicula("The last Kingdom", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.series4,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasSeries.add(new Pelicula("Maniac",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.series5,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasSeries.add(new Pelicula("House of Cards",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.series6,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasSeries.add(new Pelicula("Luis Miguel",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.series7,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasSeries.add(new Pelicula("Stranger Things", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.series8,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasSeries.add(new Pelicula("Narcos",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.series9,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasSeries.add(new Pelicula("The Sopranos",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.series10,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
    }

    private void categoriaAventura(){
        peliculasAventura.add(new Pelicula("Star Wars Jedi",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie1aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasAventura.add(new Pelicula("Star Wars", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.movie2aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasAventura.add(new Pelicula("Batman",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie3aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasAventura.add(new Pelicula("Batman v Superman", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.movie4aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasAventura.add(new Pelicula("El Zorro",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie5aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasAventura.add(new Pelicula("El Zorro La mascara",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.movie6aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasAventura.add(new Pelicula("Avengers",  "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA",R.drawable.movie7aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasAventura.add(new Pelicula("Superman Returns", "2015", "G","18-05-2015","94 min","Animation","Pete Docter","Pete Docter, Ronnie Del Carmen", daoActores.getActores(),"After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.","English","94","USA", R.drawable.movie8aventura,"8,2/10","94","8",6,"Film", R.drawable.insideouttrailer));
        peliculasAventura.add(new Pelicula("Spideman","2017","PG-13", "28-06-2017", "133 min","Action", "Jon Watts", "Jonathan Goldstein, John Francis Daley ", daoActores.getActores(), "Peter Parker balances his life as an ordinary high school student in Queens with his superhero alter-ego Spider-Man, and finds himself on the trail of a new menace prowling the skies of New York City.", "English","5", "USA", R.drawable.movie9aventura, "7,5/10","73", "3",12,"Film",  R.drawable.spideytrailer));
        peliculasAventura.add(new Pelicula( "Capitan America","2011","PG-13", "19-04-2011", "124 min","Action", "Joe Johnston", "Christopher Markus (screenplay), Stephen McFeely", daoActores.getActores(), "Steve Rogers, a rejected military soldier transforms into Captain America after taking a dose of a Super-Soldier serum. But being Captain America comes at a price as he attempts to take down a war monger and a terrorist organization.", "English","3", "USA",R.drawable.movie10aventura,"6,9/10","66","8", 13,"Film", R.drawable.captamericatrailer));
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
