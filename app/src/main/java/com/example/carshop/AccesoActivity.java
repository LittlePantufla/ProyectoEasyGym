package com.example.carshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class AccesoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        // Configuración del VideoView para la reproducción local
        VideoView videoView = findViewById(R.id.videoView);

        // Ruta al video en los recursos de la aplicación
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.king;

        // Creamos un Uri con la ruta del video
        Uri uri = Uri.parse(videoPath);

        // Configuramos el VideoView
        videoView.setVideoURI(uri);

        // Creamos un controlador de medios para permitir pausar y adelantar el video
        MediaController mediaController = new MediaController(this);

        // Asociamos el controlador de medios al VideoView
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Iniciamos la reproducción del video
        videoView.start();
    }

    // Método para manejar el clic en el botón "Opinión"
    public void onClickOpinion(View view) {
        // Inicia la actividad de Opinión
        Intent intent = new Intent(this, OpinionActivity.class);
        startActivity(intent);
    }

    // Método para manejar el clic en el botón "Mapa"
    public void onClickMapa(View view) {
        // Inicia la actividad de Mapa
        Intent intent = new Intent(this, MapaActivity.class);
        startActivity(intent);
    }

    public void onClickCarrito(View view) {
        Intent intent = new Intent(this, CarritoActivity.class);
        startActivity(intent);
    }

    // Método para manejar el clic en el botón "Cerrar Sesión"
    public void onClickCerrarSesion(View view) {
        // Inicia la actividad principal (actividad de inicio de sesión)
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
