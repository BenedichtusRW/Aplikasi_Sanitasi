package com.example.sanitasi.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sanitasi.R;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button btnKirim, btnDaftar, btnMasuk;
    private TextView daftarTitle, masukTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Inisialisasi komponen
        emailEditText = findViewById(R.id.emailEditText);
        btnKirim = findViewById(R.id.btnKirim);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnMasuk = findViewById(R.id.btnMasuk);

        // Aksi ketika tombol "Kirim" ditekan
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(ResetPasswordActivity.this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    // Tampilkan pesan (simulasi pengiriman email)
                    Toast.makeText(ResetPasswordActivity.this, "Kode verifikasi dikirim ke: " + email, Toast.LENGTH_SHORT).show();

                    // Pindah ke halaman verifikasi
                    Intent intent = new Intent(ResetPasswordActivity.this, VerifikasiActivity.class);
                    intent.putExtra("email", email); // Kirim email ke halaman verifikasi
                    startActivity(intent);
                }
            }
        });


        // Navigasi ke halaman DAFTAR
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResetPasswordActivity.this, RegistrasiActivity.class);
                startActivity(intent);
            }
        });

        // Navigasi ke halaman MASUK
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
