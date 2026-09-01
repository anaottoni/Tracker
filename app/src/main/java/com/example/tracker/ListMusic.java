package com.example.tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class ListMusic extends Fragment {

    private ListView listViewMusicas;
    private ItemAdapter adapter;

    private List<ItemModel> todasAsMusicas;
    private List<ItemModel> listaMusicas;

    private SharedViewModel viewModel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(
                R.layout.fragment_list,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);

        // ListView
        listViewMusicas = view.findViewById(R.id.listViewMusicas);

        // ViewModel compartilhada com os outros Fragmentos
        viewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        // Lista com todas as músicas
        todasAsMusicas = new ArrayList<>();

        todasAsMusicas.add(new ItemModel(
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

        todasAsMusicas.add(new ItemModel(
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

        todasAsMusicas.add(new ItemModel(
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

        todasAsMusicas.add(new ItemModel(
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

        // Lista que será exibida
        listaMusicas = new ArrayList<>(todasAsMusicas);

        // Criando o Adapter
        adapter = new ItemAdapter(
                requireContext(),
                listaMusicas
        );

        // Ligando Adapter ao ListView
        listViewMusicas.setAdapter(adapter);

        // Observando mudanças no gênero selecionado pelo Spinner
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}