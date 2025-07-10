package com.example.sanitasi.masyarakat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sanitasi.R;
import com.example.sanitasi.databinding.FragmentStatistikBinding;

public class StatistikFragment extends Fragment {

    private FragmentStatistikBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentStatistikBinding.inflate(inflater, container, false);

        // Handle klik Grafik Air
        binding.layoutGrafikAir.setOnClickListener(v -> {
            Fragment grafikFragment = new GrafikBatangFragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, grafikFragment)
                    .addToBackStack(null)
                    .commit();
        });

        // Handle klik Penyakit Air
        binding.layoutPenyakitAir.setOnClickListener(v -> {
            Fragment penyakitFragment = new PenyakitAirFragment(); // pastikan sudah ada
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, penyakitFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
