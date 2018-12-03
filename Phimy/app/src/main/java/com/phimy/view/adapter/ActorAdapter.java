package com.phimy.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phimy.R;
import com.phimy.model.Cast;
import com.phimy.model.Credit;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {
    //ATRIBUTOS
    private List<Credit> credits;
    private List<Cast> casts;
    private AdapterListener adapterListener;
    //CONSTRUCTOR
    public ActorAdapter(List<Credit> credits, AdapterListener adapterListener) {
        this.credits = credits;
        this.adapterListener = adapterListener;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_actor, parent, false);
        ActorViewHolder actorViewHolder = new ActorViewHolder(view);
        return actorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        Cast cast = casts.get(position);
        holder.cargar(cast);
    }

    @Override
    public int getItemCount() {
        return casts.size();
    }


    class ActorViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView nombre;

        public ActorViewHolder(final View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.actorNombre);
            imagen = itemView.findViewById(R.id.imageActor);


        }
        public void cargar (Cast cast){
            nombre.setText(cast.getName());
            String path = cast.getProfile_path();
            Glide.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w185/"+path).into(imagen);

        }
    }

    public List<Cast> getCasts(List<Credit> credits) {
        for ()

    }

    public interface AdapterListener {
        void recibir();
    }


}
