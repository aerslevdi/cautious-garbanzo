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
import com.phimy.model.MovieDB;
import com.phimy.view.MovieDetalleActivity;
import com.phimy.view.adapter.UpComingAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Utils.DefaultSettings;
import Utils.ResultListener;

public class UpComingFragment extends Fragment implements UpComingAdapter.Receptor {
    private ControllerMovieDB controllerMovieDB;
    private UpComingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_up_coming, container, false);
        this.controllerMovieDB=ControllerMovieDB.getInstance();
        loadRecyclerView(view);
        return view;
    }

    private void loadRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.movieUpComingRecyclerView);
        recyclerView.setHasFixedSize(true);

        //Preferencia cantidad de columnas
        String countColumns= DefaultSettings.getListPrefereceValue(view.getContext());
        int columnas = Integer.parseInt(countColumns);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), columnas);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        Drawable imageFavorito= this.getResources().getDrawable(R.drawable.favoritered);
        Drawable imageNoFavorito= this.getResources().getDrawable(R.drawable.favoritegrey);
        adapter = new UpComingAdapter(this.getContext(),this,
                new ArrayList<MovieDB>(), R.layout.movie_cardview,
                imageFavorito,imageNoFavorito);
        recyclerView.setAdapter(adapter);
        loadAdapterData(adapter, view);
    }

    private void loadAdapterData(final UpComingAdapter adapter, View view) {
        controllerMovieDB.getUpComing(new ResultListener<List<MovieDB>>() {
            @Override
            public void finish(List<MovieDB> result) {
                adapter.setMovieList(result);
            }
        }, view.getContext());
    }

    @Override
    public void recibir(MovieDB movieDB, Integer pos, List<MovieDB> list, String nameFrag) {

        Intent intent = new Intent(this.getActivity(), MovieDetalleActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)list);
        args.putSerializable(MovieDetalleActivity.KEY_MOVIEDB, movieDB);
        args.putInt(MovieDetalleActivity.KEY_POS, pos);
        intent.putExtra("BUNDLE",args);
        startActivity(intent);


        /*Intent intent=new Intent(this.getActivity(), MovieDetalleActivity.class );
        Bundle bundle= new Bundle();
        bundle.putSerializable(MovieDetalleActivity.KEY_MOVIEDB, movieDB);
        bundle.putInt(MovieDetalleActivity.KEY_POS, pos);
        bundle.putString(MovieDetalleActivity.KEY_NAMEFRAG, nameFrag);
        intent.putExtras(bundle);
        startActivity(intent);*/
    }

}