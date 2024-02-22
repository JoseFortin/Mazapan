package com.example.mazapan.asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mazapan.R;
import  com.example.mazapan.Modelos.Registro_Maestros;

public class MainActivity extends AppCompatActivity {


    // Declaración de componentes de la interfaz de usuario
    EditText TxtNombre, TxtCorreo, TxtContrasena;
    TextView btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Inicializar los componentes de la interfaz de usuario
        TxtNombre = findViewById(R.id.TxtNombre);
        TxtCorreo = findViewById(R.id.TxtCorreo);
        TxtContrasena = findViewById(R.id.TxtContrasena);

        btnGuardar = findViewById(R.id.BtnRegistrar);

        // Establecer un Listener para el botón de guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear una instancia de Registro_Maestros para manejar la lógica de la base de datos
                Registro_Maestros registros_maestros = new Registro_Maestros(MainActivity.this);

                // Insertar un nuevo maestro en la base de datos y obtener el ID resultante
                long id = registros_maestros.InsertarMaestro(
                        TxtNombre.getText().toString(),
                        TxtCorreo.getText().toString(),
                        TxtContrasena.getText().toString());

                // Verificar el resultado de la inserción y mostrar un mensaje apropiado
                if (id > 0) {
                    Toast.makeText(MainActivity.this, "Registro Guardado", Toast.LENGTH_LONG).show();
                    // Limpiar los campos de la interfaz de usuario
                    limpiar();
                } else {
                    Toast.makeText(MainActivity.this, "Error Al Guardar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Método para limpiar los campos de la interfaz de usuario
    private void limpiar() {
        TxtNombre.setText("");
        TxtCorreo.setText("");
        TxtContrasena.setText("");
    }

}