package com.example.david.pantallacategoriasfinal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TipoPeliculaAdapter  extends RecyclerView.Adapter<TipoPeliculaAdapter.TipoPeliculaViewHolder>{

    private List<TipoPelicula> datos;

    private AdapterListener listener;

    public TipoPeliculaAdapter(AdapterListener listener,List<TipoPelicula> datos) {
        this.listener = listener;
        this.datos = datos;

    }

    @NonNull
    @Override
    public TipoPeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        TipoPeliculaViewHolder tipoPeliculaViewHolder = new TipoPeliculaViewHolder(view);
        return tipoPeliculaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TipoPeliculaViewHolder holder, int position) {
        TipoPelicula tipoPelicula = datos.get(position);
        holder.cargar(tipoPelicula);

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public interface AdapterListener{
        void irDetalle(TipoPelicula tipoPelicula);
    }

    public class TipoPeliculaViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre;
        private ImageView imagen;



        public TipoPeliculaViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textCategoriaPelicula);
            imagen = itemView.findViewById(R.id.imageViewItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TipoPelicula tipoPeliculaVersion = datos.get(getAdapterPosition());
                    listener.irDetalle(tipoPeliculaVersion);
                }
            });
        }


        public void cargar (TipoPelicula tipoPelicula){
            nombre.setText(tipoPelicula.getNombre());
            imagen.setImageResource(tipoPelicula.getImagen());
        }
    }
}