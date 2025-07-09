package com.example.sanitasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VerifikasiActivity extends AppCompatActivity {

    private TextView txtEmailVerifikasi, txtKeterangan;
    private EditText otpEditText;
    private Button btnVerifikasi, btnKirimUlang, btnDaftar, btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi);

        // Ambil email dari halaman sebelumnya
        String email = getIntent().getStringExtra("email");

        // Inisialisasi komponen UI
        txtEmailVerifikasi = findViewById(R.id.txtEmailVerifikasi);
        txtKeterangan = findViewById(R.id.txtKeterangan);
        otpEditText = findViewById(R.id.otpEditText);
        btnVerifikasi = findViewById(R.id.btnVerifikasi);
        btnKirimUlang = findViewById(R.id.btnKirimUlang);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnMasuk = findViewById(R.id.btnMasuk);

        // Tampilkan email jika tersedia
        if (email != null) {
            txtEmailVerifikasi.setText("Email: " + email);
        } else {
            txtEmailVerifikasi.setText("Email tidak tersedia");
        }

        // Tombol verifikasi ditekan
        btnVerifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kode = otpEditText.getText().toString().trim();
                if (kode.isEmpty()) {
                    Toast.makeText(VerifikasiActivity.this, "Kode OTP belum diisi", Toast.LENGTH_SHORT).show();
                } else {
                    // Logika validasi kode (simulasi)
                    if (kode.equals("123456")) {
                        Toast.makeText(VerifikasiActivity.this, "Kode OTP benar", Toast.LENGTH_SHORT).show();
                        // Lanjutkan ke halaman ubah password atau beranda
                    } else {
                        Toast.makeText(VerifikasiActivity.this, "Kode OTP salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Tombol kirim ulang kode
        btnKirimUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VerifikasiActivity.this, "Kode OTP dikirim ulang ke: " + email, Toast.LENGTH_SHORT).show();
            }
        });

        // Navigasi ke halaman daftar
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerifikasiActivity.this, RegistrasiActivity.class);
                startActivity(intent);
            }
        });

        // Navigasi ke halaman masuk
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerifikasiActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
