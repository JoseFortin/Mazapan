package com.example.mazapan.Herramienta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpen extends  SQLiteOpenHelper {
    public AdminSQLiteOpen(Context context) {
        // Llamamos al constructor de la clase base SQLiteOpenHelper
        super(context, "Asistencia", null, 1);
    }

    // Aquí se crean todas las tablas de la BDD mediante consultas
    @Override
    public void onCreate(SQLiteDatabase BaseDatos) {
        // Creación de las tablas (Maestros, Alumnos, Cursos, Asistencia_Encabezado, Asistencia_Detalle)
        BaseDatos.execSQL("CREATE TABLE Maestros (Id_Maestro INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Nombre_Maestro TEXT NOT NULL, Correo_Maestro TEXT NOT NULL, Contrasena TEXT NOT NULL);");
        BaseDatos.execSQL("CREATE TABLE Alumnos (Id_Alumno INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Nombre_Alumno TEXT NOT NULL, Apellido_Alumno TEXT NOT NULL);");
        BaseDatos.execSQL("CREATE TABLE Cursos (Id_Curso INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Id_Maestro INTEGER NOT NULL, Nombre_Curso TEXT NOT NULL, Descripcion_Curso TEXT NOT NULL, FOREIGN KEY(Id_Maestro) REFERENCES Maestros(Id_Maestro));");
        BaseDatos.execSQL("CREATE TABLE Asistencia_Encabezado (Id_Asistencia INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Id_Curso INTEGER NOT NULL, Fecha TEXT NOT NULL, FOREIGN KEY(Id_Curso) REFERENCES Cursos(Id_Curso));");
        BaseDatos.execSQL("CREATE TABLE Asistencia_Detalle (Id_Asistencia INTEGER NOT NULL, Id_Alumno INTEGER NOT NULL, Estado TEXT NOT NULL, FOREIGN KEY(Id_Asistencia) REFERENCES Asistencia_Encabezado(Id_Asistencia), FOREIGN KEY(Id_Alumno) REFERENCES Alumnos(Id_Alumno), PRIMARY KEY(Id_Asistencia, Id_Alumno));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Método llamado cuando se actualiza la versión de la base de datos.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Maestros");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Alumnos");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Cursos");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Asistencia_Encabezado");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Asistencia_Detalle");
        onCreate(sqLiteDatabase);

    }
}
