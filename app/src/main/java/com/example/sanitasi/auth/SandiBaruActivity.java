package com.example.sanitasi.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sanitasi.R;

public class SandiBaruActivity extends AppCompatActivity {

    EditText inputPassword, inputConfirmPassword;
    Button btnKirimPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandi_baru);

        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        btnKirimPassword = findViewById(R.id.btnKirimPassword);

        btnKirimPassword.setOnClickListener(v -> {
            String password = inputPassword.getText().toString().trim();
            String confirmPassword = inputConfirmPassword.getText().toString().trim();

            if (password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Isi semua kolom", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Kata sandi tidak cocok", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Kata sandi berhasil diubah!", Toast.LENGTH_SHORT).show();

                // ⬇️ Kembali ke LoginActivity
                Intent intent = new Intent(SandiBaruActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
