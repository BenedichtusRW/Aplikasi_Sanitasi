package com.example.sanitasi;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VerifikasiActivity extends AppCompatActivity {

    private TextView txtEmailVerifikasi, txtKeterangan;
    private EditText otp1, otp2, otp3, otp4;
    private Button btnKirimUlang, btnDaftar, btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi);

        // Ambil email dari halaman sebelumnya
        String email = getIntent().getStringExtra("email");

        // Inisialisasi komponen UI
        txtEmailVerifikasi = findViewById(R.id.txtEmailVerifikasi);
        txtKeterangan = findViewById(R.id.txtKeterangan);
        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        btnKirimUlang = findViewById(R.id.btnKirimUlang);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnMasuk = findViewById(R.id.btnMasuk);

        // Set email
        txtEmailVerifikasi.setText(email != null ? "Email: " + email : "Email tidak tersedia");

        // Autofokus antar OTP
        otp1.addTextChangedListener(new GenericTextWatcher(otp1, otp2));
        otp2.addTextChangedListener(new GenericTextWatcher(otp2, otp3));
        otp3.addTextChangedListener(new GenericTextWatcher(otp3, otp4));
        otp4.addTextChangedListener(new GenericTextWatcher(otp4, null)); // terakhir


        btnKirimUlang.setOnClickListener(v ->
                Toast.makeText(this, "Kode OTP dikirim ulang ke: " + email, Toast.LENGTH_SHORT).show());

        btnDaftar.setOnClickListener(v -> startActivity(new Intent(this, RegistrasiActivity.class)));

        btnMasuk.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
    }

    // Kelas untuk autofokus antar EditText
    private static class GenericTextWatcher implements TextWatcher {
        private final EditText currentView;
        private final EditText nextView;

        public GenericTextWatcher(EditText currentView, EditText nextView) {
            this.currentView = currentView;
            this.nextView = nextView;
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() == 1 && nextView != null) {
                nextView.requestFocus();
            }
        }

        @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
    }
}
