package com.example.tracker;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityExtra extends AppCompatActivity {
    private ImageView imgDestaque;
    private TextView textTitulo;
    private TextView textArtista;
    private TextView textGenero;
    private TextView textDescricao;
    private TextView textNotaMedia;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_extra);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vinculando os componentes da tela
        imgDestaque = findViewById(R.id.imgDestaque);
        textTitulo = findViewById(R.id.textTitulo);
        textArtista = findViewById(R.id.textArtista);
        textGenero = findViewById(R.id.textGenero);
        textDescricao = findViewById(R.id.textDescricao);
        textNotaMedia = findViewById(R.id.textNotaMedia);

        // REQUISITO 3.2 e 3.3: Pegando a Intent e preenchendo as informações
        Intent it = getIntent();
        if (it != null) {
            textTitulo.setText(it.getStringExtra("ch_titulo"));
            textGenero.setText(it.getStringExtra("ch_genero"));
            textDescricao.setText(it.getStringExtra("ch_descricao"));

            String artista = it.getStringExtra("ch_artista");
            String ano = it.getStringExtra("ch_ano");
            String album = it.getStringExtra("ch_album");
            if (artista != null) {
                textArtista.setText(artista + " - " + (ano != null ? ano : "") + " (" + (album != null ? album : "") + ")");
            }

            // EXIBINDO A NOTA DA MÚSICA
            String nota = it.getStringExtra("ch_nota");
            if (nota != null && textNotaMedia != null) {
                textNotaMedia.setText(nota);
            }

            int idImagem = it.getIntExtra("ch_imagem", 0);
            int idAudio = it.getIntExtra("ch_audio", 0);

            if (idImagem != 0) {
                imgDestaque.setImageResource(idImagem);
            }

            // REQUISITO 3.3: Inicializando o player com o áudio recebido
            if (idAudio != 0) {
                mediaPlayer = MediaPlayer.create(this, idAudio);
            }
        }
    }

    // Método para o onClick do botão Play no XML
    public void onClickPlay(View view) {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    // Método para o onClick do botão Stop no XML
    public void onClickStop(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }
    }

    // REQUISITO 3.4: Botão Encerrar que fecha a Activity
    public void onClickEncerrar(View view) {
        finish();
    }

    // REQUISITO 3.5: Destruir o player ao fechar a tela
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
}