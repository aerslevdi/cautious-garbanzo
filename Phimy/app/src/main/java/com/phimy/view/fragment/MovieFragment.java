package com.phimy.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.phimy.R;
import com.phimy.controller.ControllerMovieDB;
import com.phimy.model.MovieDB;
import com.phimy.view.InicioActivity;
import com.phimy.view.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

import Utils.ResultListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private ControllerMovieDB controllerMovieDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        this.controllerMovieDB=new ControllerMovieDB();
        loadRecyclerView(view);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_calls, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_call) {
            Toast.makeText(getActivity(), "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                    .show();
        }
        return true;
    }

    private void loadRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.movieRecyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        MovieAdapter adapter = new MovieAdapter(new ArrayList<MovieDB>(), R.layout.movie_cardview);
        recyclerView.setAdapter(adapter);

        loadAdapterData(adapter, view);
    }

    private void loadAdapterData(final MovieAdapter adapter, View view) {
        controllerMovieDB.getMovies(new ResultListener<List<MovieDB>>() {
            @Override
            public void finish(List<MovieDB> result) {
                adapter.setArtworkList(result);
            }
        }, view.getContext());
    }

}
