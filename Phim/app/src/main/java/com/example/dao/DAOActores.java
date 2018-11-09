package com.example.dao;

import com.example.model.ActorDetalle;
import com.example.wpenia.phim.R;

import java.util.ArrayList;
import java.util.List;

public class DAOActores {
    public List<ActorDetalle> getActores() {
        List<ActorDetalle> actores = new ArrayList<>();
        actores.add(new ActorDetalle("Robert Downey Jr", R.drawable.robertdowneyjr));
        actores.add(new ActorDetalle("Chris Hemsworth", R.drawable.chrishemsworth));
        actores.add(new ActorDetalle("Mark Ruffalo", R.drawable.markruffalo));
        actores.add(new ActorDetalle("Chris Evans", R.drawable.chrisevans));
        actores.add(new ActorDetalle("Scarlett Johansson", R.drawable.scarlettjohansson));
        actores.add(new ActorDetalle("Don Cheadle", R.drawable.doncheadle));
        actores.add(new ActorDetalle("Benedict Cumberbatch", R.drawable.benedictcumberbatch));
        actores.add(new ActorDetalle("Tom Holland", R.drawable.tomholland));
        actores.add(new ActorDetalle("Chadwick Boseman", R.drawable.chadwickboseman));
        actores.add(new ActorDetalle("Zoe Zaldana", R.drawable.zoezaldana));
        actores.add(new ActorDetalle("Karen Gillan", R.drawable.karengillian));
        actores.add(new ActorDetalle("Tom Hiddleston", R.drawable.tomhiddleston));
        actores.add(new ActorDetalle("Paul Bettany", R.drawable.paulbettany));
        actores.add(new ActorDetalle("Elizabeth Olsen", R.drawable.elisabetholsen));
        actores.add(new ActorDetalle("Anthony Mackie", R.drawable.robertdowneyjr));
        actores.add(new ActorDetalle("Sebastian Stan", R.drawable.sebastianstan));
        actores.add(new ActorDetalle("Idris Elba", R.drawable.idriselba));
        actores.add(new ActorDetalle("Danai Gurira", R.drawable.danaigurira));
        actores.add(new ActorDetalle("Peter Dinklage", R.drawable.peterdinklage));
        actores.add(new ActorDetalle("Benedict Wong", R.drawable.benedictwong));
        return actores;
    }
}
