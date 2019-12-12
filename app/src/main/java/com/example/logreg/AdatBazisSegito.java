package com.example.logreg;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdatBazisSegito extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "felhasznalok.db";
    public static final String TABLE_NAME = "felhasznalo";

    public static final String COL_1 = "ID";
    public static  final String COL_2 = "EMAIL";
    public static final String COL_3 = "FELHNEV";
    public static final String COL_4 = "JELSZO";
    public static final String COL_5 = "TELJESNEV";

    public AdatBazisSegito(Context context){super(context, DATABASE_NAME, null, 1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT UNIQUE, FELHNEV TEXT UNIQUE, JELSZO TEXT, TELJESNEV TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor adatLekeres(String felhnev, String jelszo){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor eredmeny = database.query(TABLE_NAME,// Selecting Table
                new String[]{COL_1, COL_2, COL_3, COL_4, COL_4},//Selecting columns want to query
                COL_3 + "=?",
                new String[]{felhnev},//Where clause
                null, null, null);
        if (eredmeny != null && eredmeny.moveToFirst()&& eredmeny.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            User user = new User(eredmeny.getString(0), eredmeny.getString(1), eredmeny.getString(2), eredmeny.getString(3), eredmeny.getString(4));

            }
        
        return eredmeny;
    }
    public boolean adatRogzites(String email, String felhnev, String jelszo, String teljesnev){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, felhnev);
        contentValues.put(COL_4, jelszo);
        contentValues.put(COL_5, teljesnev);
        long eredmeny = database.insert(TABLE_NAME, null, contentValues);
        if (eredmeny == -1)
            return false;
        else
            return true;
    }
}
