package com.example.sanitasi.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sanitasi.R;
import com.example.sanitasi.auth.LoginActivity;
import com.example.sanitasi.auth.RegistrasiActivity;

public class MainActivity extends AppCompatActivity {

    Button btnDaftar, btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDaftar = findViewById(R.id.btnDaftar);
        btnMasuk = findViewById(R.id.btnMasuk);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDaftar.setBackgroundColor(getResources().getColor(R.color.red));
                // Arahkan ke halaman daftar
                Intent intent = new Intent(MainActivity.this, RegistrasiActivity.class); // ← Ini AKTIF
                startActivity(intent);
            }
        });

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMasuk.setBackgroundColor(getResources().getColor(R.color.red));
                // Arahkan ke halaman login
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
