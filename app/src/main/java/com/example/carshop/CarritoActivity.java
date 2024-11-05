package com.example.carshop;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
// Importo librerías para WebView
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
// Importo librerías de Sonido
import android.media.MediaPlayer;
import android.view.View;

public class CarritoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        // Configuración del WebView para cargar video de YouTube
        WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String videoUrl = "https://www.youtube.com/embed/5_dS8HaKeXk&ab_channel=FarwellInvestor";
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(videoUrl);

        // Configuración de reproducción del sonido MP3 para el botón 'reproducir'
        findViewById(R.id.reproducir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(CarritoActivity.this, R.raw.baby);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });

        // Configuración del botón 'reproducir2'
        findViewById(R.id.reproducir2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(CarritoActivity.this, R.raw.lesgo);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });

        // Configuración del botón 'reproducir3'
        findViewById(R.id.reproducir3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(CarritoActivity.this, R.raw.oohh);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });

        // Configuración del botón 'reproducir4'
        findViewById(R.id.reproducir4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(CarritoActivity.this, R.raw.yeahbuddy);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });

        // Configuración del botón Atrás para regresar a la actividad AccesoActivity
        findViewById(R.id.btnAtras).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia AccesoActivity
                Intent intent = new Intent(CarritoActivity.this, AccesoActivity.class);
                startActivity(intent);
                finish(); // Finaliza la actividad CarritoActivity para que no se quede en el stack
            }
        });
    }
}
