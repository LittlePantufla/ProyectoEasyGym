package com.example.carshop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Se declaran los atributos
    private EditText usuarioEditText;
    private EditText contrasenaEditText;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar los atributos de la vista main
        usuarioEditText = findViewById(R.id.usuario);
        contrasenaEditText = findViewById(R.id.contrasena);
        spinner = findViewById(R.id.spinnerRoles);
        // Creo un arreglo con los elementos del spinner
        String[] roles = {"Administrador", "Usuario"};
        // Creamos un ArrayAdapter para poblar el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // Asigno el array adapter
        spinner.setAdapter(adapter);
    }

    public void onClickAcceder(View view) {
        // Se declaran los valores a obtener en base a los ingresados
        String user = usuarioEditText.getText().toString().trim();
        String pass = contrasenaEditText.getText().toString().trim();
        String rol = spinner.getSelectedItem().toString();

        // Verifico las credenciales dependiendo del usuario
        if (rol.equals("Usuario") && user.equals("usuario1") && pass.equals("1234")) {
            // Inicio una actividad que se realiza en la clase Usuario
            Intent intent = new Intent(this, UsuarioActivity.class);
            startActivity(intent);
        } else if (rol.equals("Administrador") && user.equals("admin") && pass.equals("adminpass")) {
            // Inicio una actividad que se realiza en la clase Administrador
            Intent intent = new Intent(this, AccesoActivity.class);
            startActivity(intent);
        } else {
            // Si nada es válido, saltaré un alerta
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
        }
    }
}
