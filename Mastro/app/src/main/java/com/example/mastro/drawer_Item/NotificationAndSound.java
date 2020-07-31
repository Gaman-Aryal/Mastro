package com.example.mastro.drawer_Item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mastro.home.date.DHome;
import com.example.mastro.home.matrimony.MHome;
import com.example.mastro.R;

public class NotificationAndSound extends AppCompatActivity {
    String previousActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifi_and_sound);


    }

    public void changeNotificationStatus(View view) {
    }

    public void moveBack(View view) {
        this.finish();
    }

    public void changeSoundStatus(View view) {
    }
}