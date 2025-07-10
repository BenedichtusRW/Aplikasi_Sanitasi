package com.example.sanitasi.dinasterkait.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sanitasi.databinding.FragmentLaporanBinding;

public class LaporanFragment extends Fragment {

    private FragmentLaporanBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentLaporanBinding.inflate(inflater, container, false);

        // Contoh penggunaan:
        // binding.btnKirim.setOnClickListener(v -> ... );

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;   // Hindari memory‑leak
    }
}
