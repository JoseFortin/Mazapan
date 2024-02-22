package com.example.mazapan.Modelos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mazapan.Herramienta.AdminSQLiteOpen;
import com.example.mazapan.Modelos.Registro_Maestros;

public class Registro_Maestros extends AdminSQLiteOpen {
    // ESTO ES LO QUE SE ESTRAERA O SE UTILIZARA PARA LA BASE DE DATOS
    Context context;

    public Registro_Maestros(Context context) {
        super(context);
        this.context = context;
    }

    public long InsertarMaestro(String Nombre_Maestro, String Correo_Maestro, String Contrasena) {
        long id =0;
        try {
            AdminSQLiteOpen adminSql = new AdminSQLiteOpen(context);
            SQLiteDatabase db = adminSql.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Nombre_Maestro", Nombre_Maestro);
            values.put("Correo_Maestro", Correo_Maestro);
            values.put("Contrasena", Contrasena);

            id = db.insert("Maestros", null, values);
        }catch (Exception ex) {
            ex.toString();
        }
        return id;
    }
}