package com.example.mastro.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mastro.home.date.DHome;
import com.example.mastro.R;
import com.example.mastro.message.Inbox;
import com.example.mastro.registration_verification.date.DRegistration;

public class Login extends AppCompatActivity {

    private EditText loginEmailOrPhone, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        init();
    }

    private void init() {
        loginEmailOrPhone = findViewById(R.id.loginEmailOrPhone);
        loginPassword = findViewById(R.id.loginPassword);
    }

    public void newRegistration(View view) {
        startActivity(new Intent(Login.this, DRegistration.class));
    }

    public void loginBtn(View view) {
        Intent intent = new Intent(Login.this, DHome.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

}