package com.example.sanitasi;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sanitasi.fragments.BerandaFragment;
import com.example.sanitasi.fragments.StatistikFragment;
import com.example.sanitasi.fragments.LaporanFragment;
import com.example.sanitasi.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_beranda:
                    selectedFragment = new BerandaFragment();
                    break;
                case R.id.nav_statistik:
                    selectedFragment = new StatistikFragment();
                    break;
                case R.id.nav_laporan:
                    selectedFragment = new LaporanFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }

            if (selectedFragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });

        // Tampilkan fragment awal
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new BerandaFragment())
                    .commit();
        }
    }
}
