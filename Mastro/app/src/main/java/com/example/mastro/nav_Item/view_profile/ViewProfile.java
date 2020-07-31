package com.example.mastro.nav_Item.view_profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mastro.R;
import com.example.mastro.home.date.DHome;

public class ViewProfile extends AppCompatActivity {

    ViewPager viewPager;

    TextView vPName, vPAge,vPGender, vPCollege,vPHowFar, vPBio;
    TextView vPHeight, vPEducation, vPIncome, vPFrom,vPJob,vPMotherTongue;
    TextView vPReligion, vPFamilyType, vPFamilyStatus;
    TextView vPCharacter, vPDrink, vPSmoke, vPTravel;
    TextView vPSport, vPMusic, vPFood, vPMovies,vPSeries,vPTVShow,vPColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_profile);
        init();
//        ImageAdapter imageAdapter =new ImageAdapter(this);
//        viewPager.setAdapter(imageAdapter);

        settingImageHalfOfPhoneHeight();
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        viewPager = findViewById(R.id.vProfilePic);

        vPName = findViewById(R.id.vPName);
        vPAge = findViewById(R.id.vPAge);
        vPGender = findViewById(R.id.vPGender);
        vPCollege = findViewById(R.id.vPCollege);
        vPHowFar = findViewById(R.id.vPHowFar);
        vPBio = findViewById(R.id.vPBio);

        vPHeight = findViewById(R.id.vPHeight);
        vPEducation = findViewById(R.id.vPEducation);
        vPIncome = findViewById(R.id.vPIncome);
        vPFrom = findViewById(R.id.vPFrom);
        vPJob = findViewById(R.id.vPJob);
        vPMotherTongue =findViewById(R.id.vPMotherTongue);

        vPReligion = findViewById(R.id.vPReligion);
        vPFamilyType = findViewById(R.id.vPFamilyType);
        vPFamilyStatus = findViewById(R.id.vPFamilyStatus);

        vPCharacter = findViewById(R.id.vPCharacter);
        vPDrink = findViewById(R.id.vPDrink);
        vPSmoke = findViewById(R.id.vPSmoke);
        vPTravel = findViewById(R.id.vPTravel);

        vPSport = findViewById(R.id.vPSport);
        vPMusic = findViewById(R.id.vPMusic);
        vPFood = findViewById(R.id.vPFood);
        vPMovies = findViewById(R.id.vPMovies);
        vPSeries =findViewById(R.id.vPSeries);
        vPTVShow = findViewById(R.id.vPTVShow);
        vPColor =findViewById(R.id.vPColor);

        vPName.setText("Emly Julia"+" ,");
        vPAge.setText("23");
        vPGender.setText("Female");
        vPCollege.setText("University of Wolverhampton");
        vPHowFar.setText("3km far from you");
        vPBio.setText("Searching for best match, isn't everyone?");

        vPHeight.setText("Data");
        vPEducation.setText("Data");
        vPIncome.setText("Data");
        vPFrom.setText("Data");
        vPJob.setText("Data");
        vPMotherTongue.setText("Data");

        vPReligion.setText("Data");
        vPFamilyType.setText("Data");
        vPFamilyStatus.setText("Data");

        vPCharacter.setText("Data");
        vPDrink.setText("Data");
        vPSmoke.setText("Data");
        vPTravel.setText("Data");

        vPSport.setText("Data");
        vPMusic.setText("Data");
        vPFood.setText("Data");
        vPMovies.setText("Data");
        vPSeries.setText("Data");
        vPTVShow.setText("Data");
        vPColor.setText("Data");
    }

    private void settingImageHalfOfPhoneHeight() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = (displayMetrics.heightPixels / 2) - 100;

        viewPager.getLayoutParams().width = width;
        viewPager.getLayoutParams().height = height;
    }

    public void goBack(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}