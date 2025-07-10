package com.example.sanitasi.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sanitasi.R;
import com.google.android.material.textfield.TextInputEditText;

public class RegistrasiActivity extends AppCompatActivity {

    private TextInputEditText etUsername, etEmail, etAlamat, etPassword, etConfirmPassword;
    private Button btnDaftar, btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi); // pastikan file XML ini sesuai nama filenya

        // Inisialisasi field input
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etAlamat = findViewById(R.id.etAlamat);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnDaftar = findViewById(R.id.btnDaftar);
        btnMasuk = findViewById(R.id.btnMasuk);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String alamat = etAlamat.getText().toString().trim();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (username.isEmpty() || email.isEmpty() || alamat.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(RegistrasiActivity.this, "Harap isi semua data!", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegistrasiActivity.this, "Konfirmasi sandi tidak cocok!", Toast.LENGTH_SHORT).show();
                } else {
                    // Simulasi registrasi berhasil
                    Toast.makeText(RegistrasiActivity.this, "Registrasi berhasil", Toast.LENGTH_SHORT).show();
                    // Arahkan ke halaman login
                    Intent intent = new Intent(RegistrasiActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke LoginActivity
                Intent intent = new Intent(RegistrasiActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
