package com.example.wpenia.phim;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder> {
    private List<Pelicula> datos;
    private Receptor receptor;

    public PeliculaAdapter(Receptor receptor,List<Pelicula> datos) {
        this.datos = datos;
        this.receptor= receptor;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelicula,parent,false);
        PeliculaViewHolder viewHolder = new PeliculaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        Pelicula pelicula=datos.get(position);
        holder.cargar(pelicula);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public interface Receptor{
        void recibir(Pelicula pelicula);
    }

    public class PeliculaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView titulo;

        public PeliculaViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.title);
            imagen = itemView.findViewById(R.id.imageViewImagen);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pelicula pelicula= datos.get(getAdapterPosition());
                    receptor.recibir(pelicula);
                }
            });

        }
        public void cargar(Pelicula unaPelicula){
            titulo.setText(unaPelicula.getNombre());
            imagen.setImageResource(unaPelicula.getImagen());
        }
    }
}
