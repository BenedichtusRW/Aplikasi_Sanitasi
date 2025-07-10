package com.example.sanitasi.dinasterkait.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sanitasi.R;

public class GrafikBatangFragment extends Fragment {

    public GrafikBatangFragment() {
        // Konstruktor kosong
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Tampilkan layout XML yang berisi ImageView SVG
        return inflater.inflate(R.layout.fragment_grafik_batang, container, false);
    }
}
