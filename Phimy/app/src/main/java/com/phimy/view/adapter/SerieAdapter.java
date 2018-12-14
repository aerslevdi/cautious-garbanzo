package com.phimy.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.phimy.R;
import com.phimy.controller.ControllerSeriesDB;
import com.phimy.helper.ItemTouchHelperAdapter;
import com.phimy.model.SerieDB;

import java.util.List;

public class SerieAdapter extends RecyclerView.Adapter<SerieAdapter.MovieViewHolder> implements ItemTouchHelperAdapter {
    private Context context;
    private List<SerieDB> serieList;
    private Integer resources;
    private Drawable imageFavorito;
    private Drawable imageNoFavorito;
    private ControllerSeriesDB controllerSerieDB;
    private Receptor receptor;
    final static public Integer KEY_TAG_FAVORITO = 0;
    final static public Integer KEY_TAG_NOFAVORITO = 1;

    public SerieAdapter(Context context, Receptor receptor, List<SerieDB> serieList, Integer resources, Drawable imageFavorito, Drawable imageNoFavorito) {
        this.serieList = serieList;
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
    public void onBindViewHolder(@NonNull final MovieViewHolder serieViewHolder, int position) {
        final SerieDB serieDB = serieList.get(position);
        serieViewHolder.load(serieDB);
        serieViewHolder.controlFavoritos(serieDB);

        serieViewHolder.favoriteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer icon= (Integer) serieViewHolder.favoriteImage.getTag();
                    if (icon == KEY_TAG_FAVORITO){
                    Toast.makeText(view.getContext(), "agregar favoritos" , Toast.LENGTH_SHORT).show();
                        serieViewHolder.favoriteImage.setCompoundDrawablesWithIntrinsicBounds(imageFavorito,
                            null, null, null );
                        serieViewHolder.favoriteImage.setTag(KEY_TAG_NOFAVORITO);
                    controllerSerieDB.getInstance().addFavoritos(context, serieDB);
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(view.getContext(), "eliminar favoritos" , Toast.LENGTH_SHORT).show();
                    serieViewHolder.favoriteImage.setCompoundDrawablesWithIntrinsicBounds(imageNoFavorito,
                            null, null, null );
                    serieViewHolder.favoriteImage.setTag(KEY_TAG_FAVORITO);
                    controllerSerieDB.getInstance().removeFavoritos(context, serieDB);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return serieList.size();
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
        private TextView tituloSerie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.seriePoster);
            tituloSerie = itemView.findViewById(R.id.serieTitulo);
            favoriteImage= itemView.findViewById(R.id.butonFavoritosSeries);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SerieDB serieDB = serieList.get(getAdapterPosition());
                    receptor.recibir(serieDB);
                }
            });
        }

        public void load(SerieDB serie) {
            String path = serie.getBackdrop_path();
            //TODO sacar la URL de las imagenes a una variable o values
            Glide.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w185"+serie.getBackdrop_path()).into(movieImage);
            tituloSerie.setText(serie.getName());
        }

        public void controlFavoritos(SerieDB serieDB){
            //TODO controlar si la peli está o no en favoritos
            if (controllerSerieDB.getInstance().isFavorito(serieDB, context)) {
                //Asigno a todos los no favoritos
                favoriteImage.setCompoundDrawablesWithIntrinsicBounds(imageFavorito,
                        null, null, null);
                favoriteImage.setTag(KEY_TAG_NOFAVORITO);
            } else{
                favoriteImage.setCompoundDrawablesWithIntrinsicBounds(imageNoFavorito,
                        null, null, null);
                favoriteImage.setTag(KEY_TAG_FAVORITO);
            }
        }
    }

    public List<SerieDB> getMovieList() {
        return serieList;
    }

    public void setSerieList(List<SerieDB> serieList) {
        this.serieList = serieList;
        notifyDataSetChanged();
    }

    public interface Receptor{
        void recibir(SerieDB serieDB);
    }
}