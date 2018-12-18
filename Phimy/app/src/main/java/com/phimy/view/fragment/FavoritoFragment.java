package com.phimy.view.fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.phimy.R;
import com.phimy.controller.ControllerMovieDB;
import com.phimy.model.FavoritoDB;
import com.phimy.view.MovieDetalleActivity;
import com.phimy.view.adapter.FavoritoAdapter;
import java.util.ArrayList;
import java.util.List;
import Utils.DefaultSettings;
import Utils.ResultListener;

public class FavoritoFragment extends Fragment implements FavoritoAdapter.Receptor{
    private ControllerMovieDB controllerMovieDB;
    private FavoritoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_favorito, container, false);
        this.controllerMovieDB = ControllerMovieDB.getInstance();
        loadRecyclerView(view);
        return view;
    }

    private void loadRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.movieFavoritoRecyclerView);
        recyclerView.setHasFixedSize(true);
        //Preferencia cantidad de columnas
        String countColumns= DefaultSettings.getListPrefereceValue(view.getContext());
        int columnas = Integer.parseInt(countColumns);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), columnas);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        Drawable imageFavorito= this.getResources().getDrawable(R.drawable.favoritered);
        Drawable imageNoFavorito= this.getResources().getDrawable(R.drawable.favoritegrey);
        adapter = new FavoritoAdapter(this.getContext(), this, new ArrayList<FavoritoDB>(), R.layout.movie_cardview,
                imageFavorito, imageNoFavorito);
        recyclerView.setAdapter(adapter);
        loadAdapterData(adapter, view);
    }

    private void loadAdapterData(final FavoritoAdapter adapter, View view) {
        controllerMovieDB.getFavoritos(new ResultListener<List<FavoritoDB>>() {
            @Override
            public void finish(List<FavoritoDB> result) {
                adapter.setMovieList(result);
            }
        }, view.getContext());
    }


    @Override
    public void recibir(FavoritoDB favoritoDB,  Integer pos, String nameFrag) {
        Intent intent=new Intent(this.getActivity(), MovieDetalleActivity.class );
        Bundle bundle= new Bundle();
        bundle.putSerializable(MovieDetalleActivity.KEY_MOVIEDB, favoritoDB);
        bundle.putInt(MovieDetalleActivity.KEY_POS, pos);
        bundle.putString(MovieDetalleActivity.KEY_NAMEFRAG, "MovieFragment");
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
