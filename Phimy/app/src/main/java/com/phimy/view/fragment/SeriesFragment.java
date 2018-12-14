package com.phimy.view.fragment;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phimy.R;
import com.phimy.controller.ControllerSeriesDB;
import com.phimy.model.MovieDB;
import com.phimy.model.SerieDB;
import com.phimy.view.MovieDetalleActivity;
import com.phimy.view.adapter.MovieAdapter;
import com.phimy.view.adapter.SerieAdapter;

import java.util.ArrayList;
import java.util.List;

import Utils.DefaultSettings;
import Utils.ResultListener;

public class SeriesFragment extends Fragment implements SerieAdapter.Receptor{
    private ControllerSeriesDB controllerSeriesDB;

    public SeriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        this.controllerSeriesDB=ControllerSeriesDB.getInstance();
        loadRecyclerView(view);
        return view;
    }

    private void loadRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rvPopularRecyclerView);
        recyclerView.setHasFixedSize(true);
        //Preferencia cantidad de columnas
        String countColumns= DefaultSettings.getListPrefereceValue(view.getContext());
        int columnas = Integer.parseInt(countColumns);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        Drawable imageFavorito= this.getResources().getDrawable(R.drawable.favoritered);
        Drawable imageNoFavorito= this.getResources().getDrawable(R.drawable.favoritegrey);
        SerieAdapter adapter = new SerieAdapter(this.getContext(),this,
                new ArrayList<SerieDB>(), R.layout.cardview_serie,
                imageFavorito,imageNoFavorito);
        recyclerView.setAdapter(adapter);
        loadAdapterData(adapter, view);


    }

    private void loadAdapterData(final SerieAdapter adapter, View view) {
        controllerSeriesDB.getSeriesPopular(new ResultListener<List<SerieDB>>() {
            @Override
            public void finish(List<SerieDB> result) {
                adapter.setSerieList(result);
            }
        }, view.getContext());
    }



    public void recibir(MovieDB movieDB, Integer pos, String nameFrag) {
        Intent intent=new Intent(this.getActivity(), MovieDetalleActivity.class );
        Bundle bundle= new Bundle();
        bundle.putSerializable(MovieDetalleActivity.KEY_MOVIEDB, movieDB);
        bundle.putInt(MovieDetalleActivity.KEY_POS, pos);
        bundle.putString(MovieDetalleActivity.KEY_NAMEFRAG, "MovieFragment");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void recibir(SerieDB serieDB) {

    }
}
