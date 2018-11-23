package com.phimy.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phimy.R;
import com.phimy.model.MovieDB;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<MovieDB> movieList;
    private Integer resources;

    public MovieAdapter(List<MovieDB> movieList, Integer resources) {
        this.movieList = movieList;
        this.resources = resources;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resources, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder artworkViewHolder, int position) {
        MovieDB artwork = movieList.get(position);
        artworkViewHolder.load(artwork);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView movieImage;
        private TextView artistaName;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.moviePoster);
            artistaName = itemView.findViewById(R.id.artista);
        }

        public void load(MovieDB movie) {
            String path=movie.getPoster_path();
            Glide.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w185/"+movie.getPoster_path()).into(movieImage);
            artistaName.setText(movie.getTitle());
        }
    }

    public List<MovieDB> getMovieList() {
        return movieList;
    }

    public void setArtworkList(List<MovieDB> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }
}
