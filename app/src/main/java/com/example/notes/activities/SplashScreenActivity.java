package com.example.notes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.notes.R;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 2000;

    private Animation topAnimation, bottomAnimation;
    private ImageView imageLogo;
    private TextView noteSplashScreen, splashScreenTagLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        imageLogo = findViewById(R.id.imageLogo);
        noteSplashScreen = findViewById(R.id.noteTextSplashScreen);
        splashScreenTagLine = findViewById(R.id.splashScreenTagLine);

        imageLogo.setAnimation(topAnimation);
        noteSplashScreen.setAnimation(bottomAnimation);
        splashScreenTagLine.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}