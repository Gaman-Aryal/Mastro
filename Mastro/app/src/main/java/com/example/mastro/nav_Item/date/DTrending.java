package com.example.mastro.nav_Item.date;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mastro.R;

import java.util.ArrayList;

public class DTrending extends AppCompatActivity {
    private static final String TAG = "DTrending";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private Point ptSize = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_trending);



    }

    public void viewProfile(View view) {
    }

    public void backToHome(View view) {onBackPressed();
    }
}
