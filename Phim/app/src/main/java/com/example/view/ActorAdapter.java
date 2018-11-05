package com.example.digital.phim;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wpenia.phim.R;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder>{

    //ATRIBUTOS

    private List<ActorDetalle> actores;
    //private AdapterListener adapterListener;

    //CONSTRUCTOR


    public ActorAdapter(List<ActorDetalle> actores) {
        this.actores = actores;
        //this.adapterListener = adapterListener;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        //adapterListener = (AdapterListener) context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.actor_card, parent,false);
        ActorViewHolder actorViewHolder = new ActorViewHolder(view);
        return actorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        ActorDetalle actorDetalle = actores.get(position);
        holder.cargar(actorDetalle);

    }

    @Override
    public int getItemCount() {
        return actores.size();
    }


    //DEFINIR INTERFAZ

    public interface AdapterListener {
        void recibir (ActorDetalle actorDetalle);
    }

    //VIEWHOLDER

    class ActorViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView nombre;

        public ActorViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageActor);
            nombre = itemView.findViewById(R.id.actorNombre);

        }
        public void cargar (ActorDetalle actorDetalle){
            nombre.setText(actorDetalle.getNombre());
            image.setImageResource(actorDetalle.getImagen());
        }
    }
}
