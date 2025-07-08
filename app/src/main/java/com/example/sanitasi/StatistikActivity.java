package com.example.sanitasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class StatistikActivity extends AppCompatActivity {

    private ImageButton berandaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik); // Pastikan nama file XML-nya: activity_statistik.xml

        // Inisialisasi tombol beranda
        berandaButton = findViewById(R.id.imageButton3);

        // Tambahkan aksi klik ke tombol beranda
        berandaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pindah ke halaman beranda
                Intent intent = new Intent(StatistikActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Opsional: tutup halaman statistik
            }
        });

        // Tambahkan aksi lain jika dibutuhkan, contoh: navigasi ke laporan, profil, dll
    }
}

