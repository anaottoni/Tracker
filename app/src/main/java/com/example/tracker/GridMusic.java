package com.example.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
                R.raw.filho_da_fe,
                2.0,
                getString(R.string.Samuel),
                2026,
                "The love",
                getString(R.string.avaliador_musica_gospel),
                getString(R.string.avaliacao_musica_gospel)
        ));

        // Boy with Luv
        listaMusicas.add(new ItemModel(
                1,
                getString(R.string.nome_musica_kpop),
                "K-pop",
                R.drawable.boy_with_luv,
                R.raw.boy_with_luv,
                5.0,
                getString(R.string.bts),
                2019,
                "Map of the Soul: Persona",
                getString(R.string.avaliador_musica_kpop),
                getString(R.string.avaliacao_musica_kpop)
        ));

        // Louca de saudade
        listaMusicas.add(new ItemModel(
                2,
                getString(R.string.nome_musica_sertanejo),
                "Sertanejo",
                R.drawable.louca_de_saudade,
                R.raw.louca_de_saudade,
                3.0,
                getString(R.string.Jorge),
                2016,
                "Como. Sempre Feito. Nunca",
                getString(R.string.avaliador_musica_sertanejo),
                getString(R.string.avaliacao_musica_sertanejo)
        ));

        // House tour
        listaMusicas.add(new ItemModel(
                3,
                getString(R.string.nome_musica_pop),
                "Pop",
                R.drawable.house_tour,
                R.raw.house_tour,
                4.0,
                getString(R.string.Sabrina),
                2025,
                "Man's Best Friend",
                getString(R.string.avaliador_musica_pop),
                getString(R.string.avaliacao_musica_pop)
        ));

        adapter = new GridAdapter(
                requireContext(),
                listaMusicas
        );

        gridViewMusicas.setAdapter(adapter);

        gridViewMusicas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemModel item = (ItemModel) parent.getItemAtPosition(position);

                Intent intent = new Intent(requireContext(), ActivityExtra.class);

                intent.putExtra("ch_titulo", item.getNome());
                intent.putExtra("ch_genero", item.getGenero());
                intent.putExtra("ch_artista", item.getCantor());
                intent.putExtra("ch_ano", String.valueOf(item.getAno()));
                intent.putExtra("ch_album", item.getAlbum());
                intent.putExtra("ch_nota", String.valueOf(item.getNota()));
                intent.putExtra("ch_imagem", item.getImagem());
                intent.putExtra("ch_audio", item.getIdAudio());
                intent.putExtra("ch_avaliacao", item.getAvaliacao());
                intent.putExtra("ch_avaliador", item.getAvaliador());

                startActivity(intent);
            }
        });
    }
}