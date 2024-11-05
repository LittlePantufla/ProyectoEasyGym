package com.example.carshop;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UsuarioActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3;
    private Button btnLoadImages, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        // Inicializamos los ImageViews y el botón para cargar imágenes
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        btnLoadImages = findViewById(R.id.btnLoadImages);
        btnBack = findViewById(R.id.btnBack);

        // Cuando se presiona el botón de cargar imágenes
        btnLoadImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarImagenesEnSegundoPlano();
            }
        });

        // Cuando se presiona el botón de regresar
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Termina la actividad actual y vuelve a la anterior
            }
        });
    }

    private void cargarImagenesEnSegundoPlano() {
        // Handler asociado al hilo principal para actualizar la UI
        Handler handler = new Handler(Looper.getMainLooper());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Simulamos la carga de tres imágenes con retrasos
                    Thread.sleep(2000); // Simula el tiempo de carga de la imagen 1
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView1.setImageResource(R.drawable.boo);  // Imagen 1
                        }
                    });

                    Thread.sleep(2000); // Simula el tiempo de carga de la imagen 2
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView2.setImageResource(R.drawable.jia);  // Imagen 2
                        }
                    });

                    Thread.sleep(2000); // Simula el tiempo de carga de la imagen 3
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView3.setImageResource(R.drawable.ugauga);  // Imagen 3
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
