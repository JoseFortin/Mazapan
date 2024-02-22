package com.example.mazapan.Modelos;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mazapan.Entidades.Cursos;
import com.example.mazapan.Herramienta.AdminSQLiteOpen;

import java.util.ArrayList;

public class Registrar_Cursos extends AdminSQLiteOpen{
    // ESTO ES LO QUE SE ESTRAERA O SE UTILIZARA PARA LA BASE DE DATOS
    Context context;

    public Registrar_Cursos(Context context) {
        super(context);
        this.context = context;
    }

    public long InsertarCurso(String Nombre_Curso, String Descripcion_curso) {
        long id =0;
        try {
            AdminSQLiteOpen adminSql = new AdminSQLiteOpen(context);
            SQLiteDatabase db = adminSql.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Nombre_Curso", Nombre_Curso);
            values.put("Descripcion_curso", Descripcion_curso);

            id = db.insert("Cursos", null, values);
        }catch (Exception ex) {
            ex.toString();
        }
        return id;
    }
// EN ESTA FUNCION SE MOSTRARA EN UN ACTIVITY LOS DATOS QUE SE INGRESARON EN EL REGISTRO DEL CURSO
    public ArrayList<Cursos> mostrarCursos(){
        AdminSQLiteOpen adminSql = new AdminSQLiteOpen(context);
        SQLiteDatabase db = adminSql.getWritableDatabase();

        ArrayList<Cursos> ListaCursos = new ArrayList<>();
        Cursos curso = null;
        Cursor cursorCursos = null;

        cursorCursos = db.query("SELECT * FROM"+Cursos,null);

        if ((cursorCursos.moveToFirst()))
    }

}
