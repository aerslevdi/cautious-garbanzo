package com.phimy.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.phimy.R;
import com.phimy.controller.ControllerMovieDB;
import com.phimy.helper.ItemTouchHelperAdapter;
import com.phimy.model.FavoritoDB;
import com.phimy.model.MasterMovie;
import com.phimy.model.MovieDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FavoritoAdapter extends RecyclerView.Adapter<FavoritoAdapter.MovieViewHolder> implements ItemTouchHelperAdapter {
    private Context context;
    private List<FavoritoDB> favoritoList;
    private Integer resources;
    private Drawable imageFavorito;
    private Drawable imageNoFavorito;
    private ControllerMovieDB controllerMovieDB;
    private Receptor receptor;
    final static public Integer KEY_TAG_FAVORITO = 0;
    final static public Integer KEY_TAG_NOFAVORITO = 1;

    public FavoritoAdapter(Context context, Receptor receptor, List<FavoritoDB> favoritoList, Integer resources, Drawable imageFavorito, Drawable imageNoFavorito) {
        this.favoritoList = favoritoList;
        this.resources = resources;
        this.imageFavorito=imageFavorito;
        this.imageNoFavorito=imageNoFavorito;
        this.receptor=receptor;
        this.context=context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resources, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, int position) {
        final FavoritoDB favoritoDB = favoritoList.get(position);
        movieViewHolder.load(favoritoDB);

        movieViewHolder.favoriteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer icon= (Integer) movieViewHolder.favoriteImage.getTag();
                if (icon == KEY_TAG_FAVORITO){
                    //Desde tab favoritos no se puede agregar
                   /* Toast.makeText(view.getContext(), "agregar favoritos" , Toast.LENGTH_SHORT).show();
                    movieViewHolder.favoriteImage.setCompoundDrawablesWithIntrinsicBounds(imageFavorito,
                            null, null, null );
                    movieViewHolder.favoriteImage.setTag(KEY_TAG_NOFAVORITO);
                    controllerMovieDB.getInstance().addFavoritosDup(context, favoritoDB);
                    notifyDataSetChanged();*/
                } else {
                    Toast.makeText(view.getContext(), "eliminar favoritos" , Toast.LENGTH_SHORT).show();
                    movieViewHolder.favoriteImage.setCompoundDrawablesWithIntrinsicBounds(imageNoFavorito,
                            null, null, null );
                    movieViewHolder.favoriteImage.setTag(KEY_TAG_FAVORITO);
                    controllerMovieDB.getInstance().removeFavoritosDup(context, favoritoDB);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoritoList.size();
    }

    @Override
    public Boolean onItemMove(int fromPosition, int toPosition) {
        return null;
    }

    @Override
    public void onItemDismiss(int position) {
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView movieImage;
        private Button favoriteImage;
        private TextView artistaName;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.moviePoster);
            artistaName = itemView.findViewById(R.id.artista);
            favoriteImage= itemView.findViewById(R.id.butonFavoritos);
            //Son todos favoritos en este tab
            favoriteImage.setCompoundDrawablesWithIntrinsicBounds(imageFavorito,
                    null, null, null);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FavoritoDB favoritoDB = favoritoList.get(getAdapterPosition());
                    receptor.recibir(favoritoDB);
                }
            });
        }

        public void load(FavoritoDB favorito) {
            String path = favorito.getPoster_path();
            //TODO sacar la URL de las imagenes a una variable o values
            Glide.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w185/"+favorito.getPoster_path()).into(movieImage);
            artistaName.setText(favorito.getTitle());
        }


    }

    public List<FavoritoDB> getFavoritoList() {
        return favoritoList;
    }

    public void setMovieList(List<FavoritoDB> favoritoList) {
        this.favoritoList = favoritoList;
        notifyDataSetChanged();
    }

    public interface Receptor{
        void recibir(FavoritoDB favoritoDB);
    }

}