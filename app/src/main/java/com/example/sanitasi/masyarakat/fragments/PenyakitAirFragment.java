package com.example.sanitasi.masyarakat.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sanitasi.R;

public class PenyakitAirFragment extends Fragment {

    public PenyakitAirFragment() {
        // Konstruktor kosong diperlukan
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_informasi_penyakit.xml
        return inflater.inflate(R.layout.fragment_penyakit_air, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gunakan ini untuk kembali ke fragment sebelumnya
                requireActivity().onBackPressed();

                // Kalau kamu pakai Navigation Component:
                // NavHostFragment.findNavController(InformasiPenyakitFragment.this).navigateUp();
            }
        });
    }
}