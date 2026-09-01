package com.example.tracker;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class ActivityExtra extends AppCompatActivity {
    private RatingBar ratingBar;
    private ImageView imgDestaque;
    private TextView textTitulo;
    private TextView textArtista;
    private TextView textGenero;
    private TextView textAvaliacao;
    private TextView textNotaMedia;
    private MediaPlayer mediaPlayer;
    private TextView textAvaliador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_extra);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ratingBar = findViewById(R.id.ratingBar);
        imgDestaque = findViewById(R.id.imgDestaque);
        textTitulo = findViewById(R.id.textTitulo);
        textArtista = findViewById(R.id.textArtista);
        textGenero = findViewById(R.id.textGenero);
        textAvaliacao = findViewById(R.id.textAvaliacao);
        textNotaMedia = findViewById(R.id.textNotaMedia);
        textAvaliador = findViewById(R.id.textAvaliador);

        Intent it = getIntent();
        if (it != null) {
            textTitulo.setText(it.getStringExtra("ch_titulo"));
            textGenero.setText(it.getStringExtra("ch_genero"));
            textAvaliacao.setText(it.getStringExtra("ch_avaliacao"));
            textAvaliador.setText(it.getStringExtra("ch_avaliador"));


            String artista = it.getStringExtra("ch_artista");
            String ano = it.getStringExtra("ch_ano");
            String album = it.getStringExtra("ch_album");
            if (artista != null) {
                textArtista.setText(artista + " - " + (ano != null ? ano : "") + " (" + (album != null ? album : "") + ")");
            }

            String nota = it.getStringExtra("ch_nota");
            if (nota != null) {
                if (textNotaMedia != null) {
                    textNotaMedia.setText(nota);
                }

                if (ratingBar != null) {
                    try {
                        float notaFloat = Float.parseFloat(nota);
                        ratingBar.setRating(notaFloat);
                    } catch (NumberFormatException e) {
                        ratingBar.setRating(0f);
                    }
                }
            }

            int idImagem = it.getIntExtra("ch_imagem", 0);
            int idAudio = it.getIntExtra("ch_audio", 0);

            if (idImagem != 0) {
                imgDestaque.setImageResource(idImagem);
            }

            if (idAudio != 0) {
                mediaPlayer = MediaPlayer.create(this, idAudio);
            }
        }
    }

    public void onClickPlay(View view) {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public void onClickStop(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }
    }

    public void onClickEncerrar(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    //Tratar Menu:
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.theme_light) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            return true;
        } else if (id == R.id.theme_dark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            return true;
        } else if (id == R.id.theme_system) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}