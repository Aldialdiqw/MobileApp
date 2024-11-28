package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnSignup, btnLogin;
    private ImageView logo;
    private TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        btnSignup = findViewById(R.id.btn_signup);
        btnLogin = findViewById(R.id.btn_login);
        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.app_name);

        // Animation for logo and app name (optional)
        animateLogoAndAppName();

        // Animation for the SignUp button
        animateButton(btnSignup);

        // Animation for the Login button with a slight delay
        animateButtonWithDelay(btnLogin, 300); // 300 ms delay

        // Set an OnClickListener for the Login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the LoginActivity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void animateLogoAndAppName() {
        // Fade in logo and app name
        AlphaAnimation fadeInLogo = new AlphaAnimation(0, 1);
        fadeInLogo.setDuration(1000); // 1 second for logo
        logo.startAnimation(fadeInLogo);

        AlphaAnimation fadeInAppName = new AlphaAnimation(0, 1);
        fadeInAppName.setDuration(1000); // 1 second for app name
        appName.startAnimation(fadeInAppName);
    }

    private void animateButton(Button button) {
        // Fade in the button
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000); // 1 second
        button.startAnimation(fadeIn);
    }

    private void animateButtonWithDelay(Button button, int delay) {
        // Fade in the button with a delay
        button.postDelayed(() -> animateButton(button), delay);
    }
}
