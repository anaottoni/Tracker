package com.example.tracker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> generoSelecionado = new MutableLiveData<>();

    public void setGeneroSelecionado(String genero) {
        generoSelecionado.setValue(genero);
    }

    public LiveData<String> getGeneroSelecionado() {
        return generoSelecionado;
    }
}