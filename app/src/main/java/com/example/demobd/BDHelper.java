package com.example.demobd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {
    private final Context context;
    private static final String DATABASE_NAME ="Uvs.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "etudiant";
    private static final String COLUMN_ID ="_id";
    private static final String COLUMN_NOM ="nom";
    private static final String COLUMN_PRENOM ="prenom";
    private static final String COLUMN_AGE ="age";
    public BDHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = " CREATE TABLE "+TABLE_NAME +
                " ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_NOM+" TEXT, "+
                COLUMN_PRENOM+" TEXT, "+
                COLUMN_AGE+ " INTEGER);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
    onCreate(sqLiteDatabase);
    }
    void ajoutEtudiant(String nom, String prenom, int age){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv  = new ContentValues();
    cv.put(COLUMN_NOM, nom);
    cv.put(COLUMN_PRENOM, prenom);
    cv.put(COLUMN_AGE, age);
    long res = db.insert(TABLE_NAME, null, cv);
    if (res == -1)
    {
        Toast.makeText(context, "Echec de l'insertion!", Toast.LENGTH_LONG).show();
    }
    else
    {
        Toast.makeText(context, "Insertion avec success!", Toast.LENGTH_LONG).show();
    }
 }
 Cursor getAllData(){
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        if (db != null)
        {
            c = db.rawQuery(query, null);
        }
        return c;
 }
 void updateData(String id , String nom, String prenom, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NOM,nom);
        cv.put(COLUMN_PRENOM,prenom);
        cv.put(COLUMN_AGE,age);
        long res = db.update(TABLE_NAME, cv, "_id=?", new String[]{id});
     if (res == -1)
     {
         Toast.makeText(context, "Echec de mise à jour ! ",Toast.LENGTH_LONG).show();
     }
     else
     {
         Toast.makeText(context, "mise à jour avec success ! ",Toast.LENGTH_LONG).show();
     }

 }
 void deleteRaw(String row_id){
         SQLiteDatabase db = this.getWritableDatabase();
     long res = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
     if (res == -1)
     {
         Toast.makeText(context, "Echec de suppression ! ",Toast.LENGTH_LONG).show();
     }
     else
     {
         Toast.makeText(context, "suppression avec success ! ",Toast.LENGTH_LONG).show();
     }
 }
}
