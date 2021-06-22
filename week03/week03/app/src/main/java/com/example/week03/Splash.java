package com.example.week03;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    byte timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer = 0;

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (timer < 3) {
                    timer++;
                    handler.postDelayed(this, 300);
                }
                else {
                    finish();
                    Intent intent = new Intent(Splash.this, EnterPassword.class);
                    startActivity(intent);
                }
            }
        }, 0);
    }
}
