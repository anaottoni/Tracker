package com.example.tracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tracker.databinding.FragmentFiltroBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FiltroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FiltroFragment extends Fragment {

    private Spinner spinner;
    private SharedViewModel viewModel;

    private FragmentFiltroBinding binding;

    public FiltroFragment() {
        // Required empty public constructor
    }

    public static FiltroFragment newInstance(String param1, String param2) {
        FiltroFragment fragment = new FiltroFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFiltroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    // configurando o spinner apos a view carregar
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // instanciando uma viewModel
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        spinner = view.findViewById(R.id.spinner);

        // criando adapter + setando no spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.generos,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = parent.getItemAtPosition(position).toString();
                viewModel.setGeneroSelecionado(itemSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // ajustando a largura do dropdown personalizado do spinner +
        // corrigindo o deslocamento
        spinner.post(new Runnable() {
            @Override
            public void run() {
                spinner.setDropDownWidth(spinner.getWidth());
                spinner.setDropDownHorizontalOffset(-spinner.getPaddingStart());
            }
        });

        binding.button.setOnClickListener(v -> {
            // Em vez de empilhar usando o NavController, nós mandamos o BottomNav mudar de aba.
            // Isso garante que o Android gerencie a navegação do menu corretamente.
            BottomNavigationView bottomNav = requireActivity().findViewById(R.id.bottomNav);
            if (bottomNav != null) {
                bottomNav.setSelectedItemId(R.id.ListFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}