package com.example.mazapan.asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mazapan.Modelos.Registrar_Cursos;
import com.example.mazapan.R;

public class Agregar_Cursos extends AppCompatActivity {

    EditText TxtCurso, TxtDescripcion;
    TextView BtnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cursos);


        // Inicializar los componentes de la interfaz de usuario
        TxtCurso = findViewById(R.id.TxtNombreCurso);
        TxtDescripcion = findViewById(R.id.TxtDescripcion);

         BtnGuardar = findViewById(R.id.BtnGuardarCurso);

        // Establecer un Listener para el botón de guardar
        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear una instancia de Registro_Maestros para manejar la lógica de la base de datos
                Registrar_Cursos registrar_cursos = new Registrar_Cursos(Agregar_Cursos.this);

                // Insertar un nuevo maestro en la base de datos y obtener el ID resultante
                long id = registrar_cursos.InsertarCurso(
                        TxtCurso.getText().toString(),
                        TxtDescripcion.getText().toString());

                // Verificar el resultado de la inserción y mostrar un mensaje apropiado
                if (id > 0) {
                    Toast.makeText(Agregar_Cursos.this, "Registro Guardado", Toast.LENGTH_LONG).show();
                    // Limpiar los campos de la interfaz de usuario
                    limpiar();
                } else {
                    Toast.makeText(Agregar_Cursos.this, "Error Al Guardar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Método para limpiar los campos de la interfaz de usuario
    private void limpiar() {
        TxtCurso.setText("");
        TxtDescripcion.setText("");
    }

}