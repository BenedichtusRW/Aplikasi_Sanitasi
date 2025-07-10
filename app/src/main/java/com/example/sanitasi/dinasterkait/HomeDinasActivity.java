package com.example.sanitasi.dinasterkait;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewTreeObserver;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.sanitasi.R;
import com.example.sanitasi.masyarakat.fragments.BerandaFragment;
import com.example.sanitasi.masyarakat.fragments.LaporanFragment;
import com.example.sanitasi.masyarakat.fragments.ProfileFragment;
import com.example.sanitasi.masyarakat.fragments.StatistikFragment;

public class HomeDinasActivity extends AppCompatActivity {

    private final int[] icons = {
            R.drawable.ic_home,
            R.drawable.ic_statistik,
            R.drawable.ic_laporan,
            R.drawable.ic_profilenav
    };

    private final int[] iconsActive = {
            R.drawable.ic_home_black,
            R.drawable.ic_statistik_black,
            R.drawable.ic_laporan_black,
            R.drawable.ic_profile_black
    };

    private final String[] labels = {"Beranda", "Statistik", "Laporan", "Profile"};

    private final Fragment[] fragments = {
            new BerandaFragment(),
            new StatistikFragment(),
            new LaporanFragment(),
            new ProfileFragment()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_masyarakat);
        setupCustomNavigation();
    }

    private void setupCustomNavigation() {
        LinearLayout bottomNav = findViewById(R.id.customBottomNav);
        FrameLayout activeNav = findViewById(R.id.activeNav);
        ImageView iconActive = findViewById(R.id.iconActive);

        for (int i = 0; i < bottomNav.getChildCount(); i++) {
            int index = i;
            View slot = bottomNav.getChildAt(i);

            TextView text = slot.findViewById(R.id.textNav);
            ImageView icon = slot.findViewById(R.id.iconNav);

            text.setText(labels[i]);
            icon.setImageResource(icons[i]);

            slot.setOnClickListener(v -> {
                iconActive.setImageResource(iconsActive[index]);

                for (int j = 0; j < bottomNav.getChildCount(); j++) {
                    View otherSlot = bottomNav.getChildAt(j);
                    ImageView otherIcon = otherSlot.findViewById(R.id.iconNav);
                    TextView otherText = otherSlot.findViewById(R.id.textNav);

                    if (j == index) {
                        otherIcon.setVisibility(View.INVISIBLE);
                        otherText.setTextColor(ContextCompat.getColor(this, R.color.black));
                        otherText.animate().translationY(-dpToPx(6)).setDuration(200).start();
                    } else {
                        otherIcon.setVisibility(View.VISIBLE);
                        otherText.setTextColor(ContextCompat.getColor(this, R.color.white));
                        otherText.animate().translationY(0).setDuration(200).start();
                    }
                }

                float targetX = slot.getX() + slot.getWidth() / 2f - activeNav.getWidth() / 2f;
                activeNav.animate().translationX(targetX).setDuration(250).start();

                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.fragment_container, fragments[index])
                        .commit();
            });
        }

        // Gunakan ViewTreeObserver untuk menunggu layout selesai dulu
        bottomNav.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                View firstSlot = bottomNav.getChildAt(0); // Beranda
                if (firstSlot != null && activeNav.getWidth() > 0) {
                    float startX = firstSlot.getX() + firstSlot.getWidth() / 2f - activeNav.getWidth() / 2f;

                    // Geser ke posisi awal (Beranda)
                    activeNav.setTranslationX(startX);

                    // Klik otomatis agar efek aktif muncul
                    firstSlot.performClick();

                    bottomNav.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }


    // ✅ TARUH DI LUAR method lain!
    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}