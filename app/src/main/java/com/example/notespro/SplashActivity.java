package com.example.notespro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToCorrectPage();
            }
        }, 1000); // delayMillis is specified without parameter name
    }

    private void navigateToCorrectPage() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            // User is not logged in, navigate to Create Account page
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        } else {
            // User is logged in, navigate to Main page
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
        finish(); // optional, depending on your use case
    }
}
