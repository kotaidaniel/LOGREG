package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private AdatBazisSegito adatBazisSegito;
    private EditText txtFelhNevvEmail, txtJelszo;
    private Button bttnBejelentkezes, bttnRegisztracio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bttnBejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatLekeres();
            }
        });
        bttnRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init(){
        adatBazisSegito = new AdatBazisSegito(this);
        txtFelhNevvEmail = findViewById(R.id.txtFelhNevvEmail);
        txtJelszo = findViewById(R.id.txtJelszo);
        bttnBejelentkezes = findViewById(R.id.bttnBejelentkezes);
        bttnRegisztracio = findViewById(R.id.bttnRegisztracio);
    }

    public void adatLekeres(){
        Cursor jelszo = adatBazisSegito.adatLekeres("asdasd");
        System.out.println(jelszo);
    }
}
