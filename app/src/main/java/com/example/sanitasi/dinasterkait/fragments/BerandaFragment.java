package com.example.sanitasi.dinasterkait.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sanitasi.databinding.FragmentBerandaBinding;

public class BerandaFragment extends Fragment {

    private FragmentBerandaBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentBerandaBinding.inflate(inflater, container, false);

        // Contoh penggunaan view binding
        // binding.textViewJudul.setText("Halo, Dunia!");

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Hindari memory leak
    }
}
