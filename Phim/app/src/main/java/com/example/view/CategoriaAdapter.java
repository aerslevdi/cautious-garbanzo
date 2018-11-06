package com.example.view;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helper.ItemTouchHelperAdapter;
import com.example.model.Categoria;
import com.example.wpenia.phim.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> implements ItemTouchHelperAdapter, Filterable {

    private List<Categoria> categoriaFull;
    private OnItemViewSelected listener;
    private List<Categoria> categorias;


    public interface OnItemViewSelected {
        void click(Categoria categoria);
    }

    public CategoriaAdapter(List<Categoria> datos, OnItemViewSelected listener) {
        this.categorias = datos;
        this.categoriaFull = new ArrayList<>(datos);
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_categoria, viewGroup, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder recetaViewHolder, int i) {
        Categoria categoria = this.categorias.get(i);
        recetaViewHolder.setDatos(categoria);
    }

    @Override
    public int getItemCount() {
        return this.categorias.size();
    }


    @Override
    public Boolean onItemMove(int fromPosition, int toPosition) {
        if(fromPosition < toPosition) {
            for (int i = fromPosition ; i < toPosition; i++){
                Collections.swap(this.categorias, i, i +1);
            }

        } else {
            for (int i = fromPosition ; i > toPosition; i--){
                Collections.swap(this.categorias, i, i -1);
            }
        }

        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        this.categorias.remove(position);
        notifyItemRemoved(position);
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private ViewPager viewPager;


        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagenCategoria);
            textView = itemView.findViewById(R.id.nombreCategoria);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.click(categorias.get(getAdapterPosition()));
                }
            });
        }

        public void setDatos(Categoria categoria) {
            imageView.setImageResource(categoria.getFoto());
            textView.setText(categoria.getTitulo());
        }
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Categoria> filterList = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    filterList.addAll(categoriaFull);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (Categoria receta : categoriaFull){
                        if(receta.getTitulo().toLowerCase().trim().contains(filterPattern)) {
                            filterList.add(receta);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filterList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                categorias.clear();
                categorias.addAll((Collection<? extends Categoria>) results.values);
                notifyDataSetChanged();
            }
        };
    }

}
