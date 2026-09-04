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
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class GridMusic extends Fragment {

    private GridView gridViewMusicas;
    private GridAdapter adapter;
    private List<ItemModel> listaMusicas;
    private SharedViewModel viewModel;
    private List<ItemModel> todasAsMusicas;

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

        viewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        todasAsMusicas = new ArrayList<>();

// ==================== K-POP ====================

        todasAsMusicas.add(new ItemModel(
                1,
                getString(R.string.nome_musica_kpop_1),
                "K-pop",
                R.drawable.boy_with_luv,
                R.raw.spring_day    ,
                9.5,
                getString(R.string.bts),
                2020,
                getString(R.string.album_kpop_1),
                getString(R.string.avaliador_kpop_1),
                getString(R.string.avaliacao_kpop_1)
        ));

        todasAsMusicas.add(new ItemModel(
                2,
                getString(R.string.nome_musica_kpop_2),
                "K-pop",
                R.drawable.boy_with_luv,
                R.raw.dna,
                9.5,
                getString(R.string.bts),
                2021,
                getString(R.string.album_kpop_2),
                getString(R.string.avaliador_kpop_2),
                getString(R.string.avaliacao_kpop_2)
        ));

        todasAsMusicas.add(new ItemModel(
                3,
                getString(R.string.nome_musica_kpop_3),
                "K-pop",
                R.drawable.boy_with_luv,
                R.raw.black_swan,
                10.0,
                getString(R.string.bts),
                2017,
                getString(R.string.album_kpop_3),
                getString(R.string.avaliador_kpop_3),
                getString(R.string.avaliacao_kpop_3)
        ));

        todasAsMusicas.add(new ItemModel(
                4,
                getString(R.string.nome_musica_kpop_4),
                "K-pop",
                R.drawable.boy_with_luv,
                R.raw.run,
                9.0,
                getString(R.string.bts),
                2018,
                getString(R.string.album_kpop_4),
                getString(R.string.avaliador_kpop_4),
                getString(R.string.avaliacao_kpop_4)
        ));

        listaMusicas.add(new ItemModel(
                5,
                getString(R.string.nome_musica_kpop_5),
                "K-pop",
                R.drawable.boy_with_luv,
                R.raw.boy_with_luv,
                9.0,
                getString(R.string.bts),
                2019,
                getString(R.string.album_kpop_5),
                getString(R.string.avaliador_kpop_5),
                getString(R.string.avaliacao_kpop_5)
        ));


// ==================== JORGE E MATEUS - SERTANEJO ====================

        listaMusicas.add(new ItemModel(
                6,
                getString(R.string.nome_musica_sertanejo_1),
                "Sertanejo",
                R.drawable.louca_de_saudade,
                R.raw.noite_dia,
                9.5,
                getString(R.string.Jorge),
                2010,
                getString(R.string.album_sertanejo_1),
                getString(R.string.avaliador_sertanejo_1),
                getString(R.string.avaliacao_sertanejo_1)
        ));

        listaMusicas.add(new ItemModel(
                7,
                getString(R.string.nome_musica_sertanejo_2),
                "Sertanejo",
                R.drawable.louca_de_saudade,
                R.raw.voa_flor,
                9.5,
                getString(R.string.Jorge),
                2015,
                getString(R.string.album_sertanejo_2),
                getString(R.string.avaliador_sertanejo_2),
                getString(R.string.avaliacao_sertanejo_2)
        ));

        listaMusicas.add(new ItemModel(
                8,
                getString(R.string.nome_musica_sertanejo_3),
                "Sertanejo",
                R.drawable.louca_de_saudade,
                R.raw.seu_astral,
                9.0,
                getString(R.string.Jorge),
                2018,
                getString(R.string.album_sertanejo_3),
                getString(R.string.avaliador_sertanejo_3),
                getString(R.string.avaliacao_sertanejo_3)
        ));

        listaMusicas.add(new ItemModel(
                9,
                getString(R.string.nome_musica_sertanejo_4),
                "Sertanejo",
                R.drawable.louca_de_saudade,
                R.raw.anjos_cantam,
                9.5,
                getString(R.string.Jorge),
                2015,
                getString(R.string.album_sertanejo_4),
                getString(R.string.avaliador_sertanejo_4),
                getString(R.string.avaliacao_sertanejo_4)
        ));

        listaMusicas.add(new ItemModel(
                10,
                getString(R.string.nome_musica_sertanejo_5),
                "Sertanejo",
                R.drawable.louca_de_saudade,
                R.raw.louca_de_saudade,
                9.0,
                getString(R.string.Jorge),
                2016,
                getString(R.string.album_sertanejo_5),
                getString(R.string.avaliador_sertanejo_5),
                getString(R.string.avaliacao_sertanejo_5)
        ));


// ==================== SABRINA CARPENTER - POP ====================

        listaMusicas.add(new ItemModel(
                11,
                getString(R.string.nome_musica_pop_1),
                "Pop",
                R.drawable.house_tour,
                R.raw.expresso,
                10.0,
                getString(R.string.Sabrina),
                2024,
                getString(R.string.album_pop_1),
                getString(R.string.avaliador_pop_1),
                getString(R.string.avaliacao_pop_1)
        ));

        listaMusicas.add(new ItemModel(
                12,
                getString(R.string.nome_musica_pop_2),
                "Pop",
                R.drawable.boy_with_luv,
                R.raw.please,
                9.5,
                getString(R.string.Sabrina),
                2024,
                getString(R.string.album_pop_2),
                getString(R.string.avaliador_pop_2),
                getString(R.string.avaliacao_pop_2)
        ));

        listaMusicas.add(new ItemModel(
                13,
                getString(R.string.nome_musica_pop_3),
                "Pop",
                R.drawable.house_tour,
                R.raw.feather,
                9.5,
                getString(R.string.Sabrina),
                2023,
                getString(R.string.album_pop_3),
                getString(R.string.avaliador_pop_3),
                getString(R.string.avaliacao_pop_3)
        ));

        listaMusicas.add(new ItemModel(
                14,
                getString(R.string.nome_musica_pop_4),
                "Pop",
                R.drawable.house_tour,
                R.raw.nonsense,
                9.0,
                getString(R.string.Sabrina),
                2022,
                getString(R.string.album_pop_4),
                getString(R.string.avaliador_pop_4),
                getString(R.string.avaliacao_pop_4)
        ));

        listaMusicas.add(new ItemModel(
                15,
                getString(R.string.nome_musica_pop_5),
                "Pop",
                R.drawable.house_tour,
                R.raw.house_tour,
                9.0,
                getString(R.string.Sabrina),
                2025,
                getString(R.string.album_pop_5),
                getString(R.string.avaliador_pop_5),
                getString(R.string.avaliacao_pop_5)
        ));


// ==================== GOSPEL ====================

        listaMusicas.add(new ItemModel(
                16,
                getString(R.string.nome_musica_gospel_1),
                "Gospel",
                R.drawable.filho_da_fe,
                R.raw.filho_da_fe,
                9.0,
                getString(R.string.Samuel),
                2026,
                getString(R.string.album_gospel_1),
                getString(R.string.avaliador_gospel_1),
                getString(R.string.avaliacao_gospel_1)
        ));

        listaMusicas.add(new ItemModel(
                17,
                getString(R.string.nome_musica_gospel_2),
                "Gospel",
                R.drawable.filho_da_fe,
                R.raw.lugar_secreto,
                9.5,
                getString(R.string.Samuel),
                2015,
                getString(R.string.album_gospel_2),
                getString(R.string.avaliador_gospel_2),
                getString(R.string.avaliacao_gospel_2)
        ));

        listaMusicas.add(new ItemModel(
                18,
                getString(R.string.nome_musica_gospel_3),
                "Gospel",
                R.drawable.filho_da_fe,
                R.raw.ousado_amor,
                9.5,
                getString(R.string.Samuel),
                2020,
                getString(R.string.album_gospel_3),
                getString(R.string.avaliador_gospel_3),
                getString(R.string.avaliacao_gospel_3)
        ));

        listaMusicas.add(new ItemModel(
                19,
                getString(R.string.nome_musica_gospel_4),
                "Gospel",
                R.drawable.filho_da_fe,
                R.raw.raridade,
                10.0,
                getString(R.string.Samuel),
                2018,
                getString(R.string.album_gospel_4),
                getString(R.string.avaliador_gospel_4),
                getString(R.string.avaliacao_gospel_4)
        ));

        listaMusicas.add(new ItemModel(
                20,
                getString(R.string.nome_musica_gospel_5),
                "Gospel",
                R.drawable.filho_da_fe,
                R.raw.faz_chover,
                9.5,
                getString(R.string.Samuel),
                2018,
                getString(R.string.album_gospel_5),
                getString(R.string.avaliador_gospel_5),
                getString(R.string.avaliacao_gospel_5)
        ));

        listaMusicas = new ArrayList<>(todasAsMusicas);

        adapter = new GridAdapter(
                requireContext(),
                listaMusicas
        );

        gridViewMusicas.setAdapter(adapter);

        viewModel.getGeneroSelecionado().observe(
                getViewLifecycleOwner(),
                genero -> {

                    List<ItemModel> musicasFiltradas = new ArrayList<>();

                    for (ItemModel musica : todasAsMusicas) {

                        if (musica.getGenero().equalsIgnoreCase(genero)) {
                            musicasFiltradas.add(musica);
                        }
                    }

                    adapter.atualizarLista(musicasFiltradas);
                }
        );

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
