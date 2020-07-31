package com.example.mastro.drawer_Item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mastro.R;
import com.example.mastro.home.date.DHome;

public class Premium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium);
    }

    public void registerForMatrimony(View view) {
    }

    public void boostDateProfile(View view) {
    }

    public void moveBack(View view) {
        this.finish();
    }
}