package com.example.tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class GridMusic extends Fragment {

    private GridView gridViewMusicas;
    private GridAdapter adapter;
    private List<ItemModel> listaMusicas;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(
                R.layout.fragment_grid,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);

        gridViewMusicas = view.findViewById(R.id.gridViewMusicas);

        listaMusicas = new ArrayList<>();

        // Filho da fé
        listaMusicas.add(new ItemModel(
                4,
                getString(R.string.nome_musica_gospel),
                "Gospel",
                R.drawable.filho_da_fe,
                4,
                2.0,
                getString(R.string.Samuel),
                2026,
                "The love"
        ));

        // Boy with Luv
        listaMusicas.add(new ItemModel(
                1,
                getString(R.string.nome_musica_kpop),
                "K-pop",
                R.drawable.boy_with_luv,
                1,
                5.0,
                getString(R.string.bts),
                2019,
                "Map of the Soul: Persona"
        ));

        // Louca de saudade
        listaMusicas.add(new ItemModel(
                2,
                getString(R.string.nome_musica_sertanejo),
                "Sertanejo",
                R.drawable.louca_de_saudade,
                2,
                3.0,
                getString(R.string.Jorge),
                2016,
                "Como. Sempre Feito. Nunca"
        ));

        // House tour
        listaMusicas.add(new ItemModel(
                3,
                getString(R.string.nome_musica_pop),
                "Pop",
                R.drawable.house_tour,
                3,
                4.0,
                getString(R.string.Sabrina),
                2025,
                "Man's Best Friend"
        ));

        adapter = new GridAdapter(
                requireContext(),
                listaMusicas
        );

        gridViewMusicas.setAdapter(adapter);
    }
}