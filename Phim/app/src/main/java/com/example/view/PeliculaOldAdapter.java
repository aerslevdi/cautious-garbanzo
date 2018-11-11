package com.example.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.PeliculaOld;
import com.example.wpenia.phim.R;

import java.util.List;

public class PeliculaOldAdapter extends RecyclerView.Adapter<PeliculaOldAdapter.PeliculaViewHolder> {
    private List<PeliculaOld> datos;
    private Receptor receptor;
    private int xmlView =R.layout.item_pelicula ;

    public PeliculaOldAdapter(Receptor receptor, List<PeliculaOld> datos, int xmlView) {
        this.datos = datos;
        this.receptor= receptor;
        this.xmlView=xmlView;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(xmlView,parent,false);
        PeliculaViewHolder viewHolder = new PeliculaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        PeliculaOld peliculaOld =datos.get(position);
        holder.cargar(peliculaOld);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public interface Receptor{
        void recibir(PeliculaOld peliculaOld);
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
                    PeliculaOld peliculaOld = datos.get(getAdapterPosition());
                    receptor.recibir(peliculaOld);
                }
            });

        }
        public void cargar(PeliculaOld unaPeliculaOld){
            titulo.setText(unaPeliculaOld.getNombre());
            imagen.setImageResource(unaPeliculaOld.getImagen());
        }
    }
}
