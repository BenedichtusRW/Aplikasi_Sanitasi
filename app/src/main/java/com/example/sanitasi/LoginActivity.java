package com.example.sanitasi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.FacebookActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText editUsername, editPassword;
    private CheckBox checkboxRemember;
    private Button btnMasuk, btnFacebook, btnGoogle;

    private SharedPreferences preferences;
    private static final String PREF_NAME = "loginPrefs";

    private boolean isPasswordVisible = false;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Facebook SDK setup (penting)
        FacebookSdk.setClientToken(getString(R.string.facebook_client_token));
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        // Inisialisasi view
        editUsername = findViewById(R.id.usernameEditText);
        editPassword = findViewById(R.id.passwordEditText);
        checkboxRemember = findViewById(R.id.rememberCheckBox);
        btnMasuk = findViewById(R.id.loginButton);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnGoogle = findViewById(R.id.btnGoogle);

        preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        checkRememberedCredentials();

        // Tampilkan/sembunyikan password
        TextInputLayout passwordLayout = findViewById(R.id.passwordTextInputLayout);
        if (passwordLayout != null) {
            passwordLayout.setEndIconOnClickListener(v -> {
                if (isPasswordVisible) {
                    editPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    editPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                editPassword.setSelection(editPassword.getText().length());
                isPasswordVisible = !isPasswordVisible;
            });
        }

        // Tombol login manual
        btnMasuk.setOnClickListener(view -> {
            String username = editUsername.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Isi semua kolom", Toast.LENGTH_SHORT).show();
                return;
            }

            if (checkboxRemember.isChecked()) {
                preferences.edit()
                        .putString("username", username)
                        .putBoolean("remember", true)
                        .apply();
            } else {
                preferences.edit().clear().apply();
            }

            Toast.makeText(this, "Login sukses", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        });

        // FACEBOOK LOGIN
        callbackManager = CallbackManager.Factory.create();

        btnFacebook.setOnClickListener(v -> {
            LoginManager.getInstance().logInWithReadPermissions(
                    this,
                    Arrays.asList("public_profile", "email")
            );

            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            AccessToken token = loginResult.getAccessToken();
                            Toast.makeText(LoginActivity.this, "Login Facebook berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }

                        @Override
                        public void onCancel() {
                            Toast.makeText(LoginActivity.this, "Login Facebook dibatalkan", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(FacebookException exception) {
                            Toast.makeText(LoginActivity.this, "Login Facebook gagal: " + exception.getMessage(), Toast.LENGTH_LONG).show();
                            Log.e("FB_LOGIN", "Error: ", exception);
                        }
                    });
        });

        // Tombol Google (belum diimplementasi)
        btnGoogle.setOnClickListener(v ->
                Toast.makeText(this, "Login via Google belum tersedia", Toast.LENGTH_SHORT).show());
    }

    private void checkRememberedCredentials() {
        boolean remember = preferences.getBoolean("remember", false);
        if (remember) {
            String savedUsername = preferences.getString("username", "");
            editUsername.setText(savedUsername);
            checkboxRemember.setChecked(true);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
