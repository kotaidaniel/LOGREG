package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private AdatBazisSegito adatBazisSegito;
    private Button bttnRegisztracio;
    private EditText txtEmail, txtFelhNev, txtJelszo, txtTeljesNev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        bttnRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatRogzites();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init(){
        adatBazisSegito = new AdatBazisSegito(this);
        bttnRegisztracio = findViewById(R.id.bttnRegisztracioInput);
        txtEmail = findViewById(R.id.txtRegEmail);
        txtFelhNev = findViewById(R.id.txtRegFelhNev);
        txtJelszo = findViewById(R.id.txtRegJelszo);
        txtTeljesNev = findViewById(R.id.txtRegTeljesNev);
    }
    public void adatRogzites(){
        String email = txtEmail.getText().toString();
        String felhnev = txtFelhNev.getText().toString();
        String jelszo = txtJelszo.getText().toString();
        String teljesnev = txtTeljesNev.getText().toString();
        boolean eredmeny = adatBazisSegito.adatRogzites(email, felhnev, jelszo, teljesnev);
        if (eredmeny)
            Toast.makeText(this, "Sikeres regisztráció", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Sikertelen regisztráció", Toast.LENGTH_SHORT).show();
    }
}
