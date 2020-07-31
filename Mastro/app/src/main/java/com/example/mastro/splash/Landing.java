package com.example.mastro.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mastro.login.Login;
import com.example.mastro.R;

public class Landing extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);
        int splash_timeout = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginIntent = new Intent(Landing.this, Login.class);
                startActivity(loginIntent);
                finish();
            }
        }, splash_timeout);
    }
}