package com.example.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.ActorDetalle;
import com.example.wpenia.phim.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabPerfilFragment extends Fragment {

    private static final String KEY_ACTORES = "actores";


    public TabPerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_perfil, container, false);
        // Obtengo el bundle
        Bundle bundle = getArguments();

        //bundle.putLongArray(PerfilFragment.KEY_ACTORES, dato.getActores());
        // Datos
        List<ActorDetalle> actores = (List<ActorDetalle>) bundle.getSerializable(KEY_ACTORES);

        // Busco componentes

        TextView actoresView = view.findViewById(R.id.actoresRecycler);






        // Seteo los datos

        actoresView.setText(actores.toString());

        return view;
    }

}
