package com.example.mastro.drawer_Item.my_profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mastro.R;
import com.example.mastro.drawer_Item.my_profile.tabs.TabsManager;
import com.mikhaellopez.circularimageview.CircularImageView;

public class MyProfile extends AppCompatActivity {

    RelativeLayout up;
    int HeightOfScreen, WidthOfScreen;
    Button btn1, btn2, btn3, btn4, btn5;
    View aboutLayout, familyLayout, hobbiesLayout, interestLayout, preferenceLayout;

    CircularImageView mProfilePicture;
    ImageView premiumUser;

    EditText mPName, mPAge, mPCollege, mPBio;
    EditText mPHeight, mPEducation, mPIncome, mPFrom, mPJob, mPMotherTongue;
    EditText mPReligion, mPFamilyType, mPFamilyStatus;
    EditText mPCharacter, mPDrink, mPSmoke, mPTravel;
    EditText mPSport, mPMusic, mPFood, mPMovies, mPSeries, mPTVShow, mPColor;
    EditText mPPHeight, mPPEducation, mPPIncome, mPPFrom, mPPJob, mPPMotherTongue, mPPReligion, mPPFamilyType, mPPFamilyStatus, mPPCharacter, mPPDrink, mPPSmoke, mPPTravel, mPPSport, mPPMusic, mPPFood, mPPMovies, mPPSeries, mPPTVShow, mPPColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        init();
        hideAndDisplayLayout();

    }

    private void init() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        WidthOfScreen = displayMetrics.widthPixels;
        HeightOfScreen = (displayMetrics.heightPixels);

        up = findViewById(R.id.up);
        up.getLayoutParams().width = WidthOfScreen;
        up.getLayoutParams().height = (int) (HeightOfScreen / 2.5);

        mProfilePicture = findViewById(R.id.mProfilePicture);
        premiumUser = findViewById(R.id.premiumUser);
        mPName = findViewById(R.id.mPName);
        mPAge = findViewById(R.id.mPAge);
        mPCollege = findViewById(R.id.mPCollege);
        mPBio = findViewById(R.id.mPBio);

        mProfilePicture.setImageResource(R.drawable.girls);
        premiumUser.setImageResource(R.drawable.ic_premium);
        mPName.setHint("Data");
        mPAge.setHint("Data");
        mPCollege.setHint("Data");
        mPBio.setHint("Data");

        mPName.clearFocus();
        mPAge.clearFocus();
        mPCollege.clearFocus();
        mPBio.clearFocus();

    }

    private void hideAndDisplayLayout() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        btn1.getLayoutParams().width = (WidthOfScreen / 2) - (WidthOfScreen / 50);
        btn2.getLayoutParams().width = (WidthOfScreen / 2) - (WidthOfScreen / 50);
        btn3.getLayoutParams().width = (WidthOfScreen / 2) - (WidthOfScreen / 50);
        btn4.getLayoutParams().width = (WidthOfScreen / 2) - (WidthOfScreen / 50);

        aboutLayout = findViewById(R.id.aboutLayout);
        familyLayout = findViewById(R.id.familyLayout);
        hobbiesLayout = findViewById(R.id.hobbiesLayout);
        interestLayout = findViewById(R.id.interestLayout);
        preferenceLayout = findViewById(R.id.preferenceLayout);

        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (aboutLayout.getVisibility() == View.GONE) {
                    hideAndDisplayHelper(btn1, btn2, btn3, btn4, btn5, aboutLayout, familyLayout, hobbiesLayout, interestLayout, preferenceLayout);
                    dataInAbout();
                } else {
                    aboutLayout.setVisibility(View.GONE);
                    btn1.setBackgroundResource(R.drawable.my_profile_btn_design);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (familyLayout.getVisibility() == View.GONE) {
                    hideAndDisplayHelper(btn2, btn1, btn3, btn4, btn5, familyLayout, aboutLayout, hobbiesLayout, interestLayout, preferenceLayout);
                    dataInFamily();
                } else {
                    familyLayout.setVisibility(View.GONE);
                    btn2.setBackgroundResource(R.drawable.my_profile_btn_design);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (interestLayout.getVisibility() == View.GONE) {
                    hideAndDisplayHelper(btn3, btn1, btn2, btn4, btn5, interestLayout, aboutLayout, familyLayout, hobbiesLayout, preferenceLayout);
                    dataInInterest();
                } else {
                    interestLayout.setVisibility(View.GONE);
                    btn3.setBackgroundResource(R.drawable.my_profile_btn_design);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (hobbiesLayout.getVisibility() == View.GONE) {
                    hideAndDisplayHelper(btn4, btn1, btn2, btn3, btn5, hobbiesLayout, aboutLayout, familyLayout, interestLayout, preferenceLayout);
                    dataInHobbies();
                } else {
                    hobbiesLayout.setVisibility(View.GONE);
                    btn4.setBackgroundResource(R.drawable.my_profile_btn_design);
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (preferenceLayout.getVisibility() == View.GONE) {
                    hideAndDisplayHelper(btn5, btn1, btn2, btn3, btn4, preferenceLayout, aboutLayout, familyLayout, hobbiesLayout, interestLayout);
                    dataInPreference();
                } else {
                    preferenceLayout.setVisibility(View.GONE);
                    btn5.setBackgroundResource(R.drawable.my_profile_btn_design);
                }
            }
        });
    }

    private void hideAndDisplayHelper(Button S, Button US1, Button US2, Button US3, Button US4, View O, View UO1, View UO2, View UO3, View UO4) {
        S.setBackgroundResource(R.drawable.my_profile_btn_clicked_color);
        US1.setBackgroundResource(R.drawable.my_profile_btn_design);
        US2.setBackgroundResource(R.drawable.my_profile_btn_design);
        US3.setBackgroundResource(R.drawable.my_profile_btn_design);
        US4.setBackgroundResource(R.drawable.my_profile_btn_design);

        O.setVisibility(View.VISIBLE);
        UO1.setVisibility(View.GONE);
        UO2.setVisibility(View.GONE);
        UO3.setVisibility(View.GONE);
        UO4.setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    public void dataInAbout() {
        mPHeight = findViewById(R.id.mPHeight);
        mPEducation = findViewById(R.id.mPEducation);
        mPIncome = findViewById(R.id.mPIncome);
        mPFrom = findViewById(R.id.mPFrom);
        mPJob = findViewById(R.id.mPJob);
        mPMotherTongue = findViewById(R.id.mPMotherTongue);

        mPHeight.setText("Data");
        mPEducation.setText("Data");
        mPIncome.setText("Data");
        mPFrom.setText("Data");
        mPJob.setText("Data");
        mPMotherTongue.setText("Data");
    }

    @SuppressLint("SetTextI18n")
    public void dataInFamily() {
        mPReligion = findViewById(R.id.mPReligion);
        mPFamilyType = findViewById(R.id.mPFamilyType);
        mPFamilyStatus = findViewById(R.id.mPFamilyStatus);

        mPReligion.setText("Data");
        mPFamilyType.setText("Data");
        mPFamilyStatus.setText("Data");
    }

    @SuppressLint("SetTextI18n")
    public void dataInHobbies() {
        mPCharacter = findViewById(R.id.mPCharacter);
        mPDrink = findViewById(R.id.mPDrink);
        mPSmoke = findViewById(R.id.mPSmoke);
        mPTravel = findViewById(R.id.mPTravel);

        mPCharacter.setText("Data");
        mPDrink.setText("Data");
        mPSmoke.setText("Data");
        mPTravel.setText("Data");
    }

    @SuppressLint("SetTextI18n")
    public void dataInInterest() {
        mPSport = findViewById(R.id.mPSport);
        mPMusic = findViewById(R.id.mPMusic);
        mPFood = findViewById(R.id.mPFood);
        mPMovies = findViewById(R.id.mPMovies);
        mPSeries = findViewById(R.id.mPSeries);
        mPTVShow = findViewById(R.id.mPTVShow);
        mPColor = findViewById(R.id.mPColor);

        mPSport.setText("Data");
        mPMusic.setText("Data");
        mPFood.setText("Data");
        mPMovies.setText("Data");
        mPSeries.setText("Data");
        mPTVShow.setText("Data");
        mPColor.setText("Data");
    }

    @SuppressLint("SetTextI18n")
    public void dataInPreference() {
        mPPHeight = findViewById(R.id.mPPHeight);
        mPPEducation = findViewById(R.id.mPPEducation);
        mPPIncome = findViewById(R.id.mPPIncome);
        mPPFrom = findViewById(R.id.mPPFrom);
        mPPJob = findViewById(R.id.mPPJob);
        mPPMotherTongue = findViewById(R.id.mPPMotherTongue);
        mPPReligion = findViewById(R.id.mPPReligion);
        mPPFamilyType = findViewById(R.id.mPPFamilyType);
        mPPFamilyStatus = findViewById(R.id.mPPFamilyStatus);
        mPPCharacter = findViewById(R.id.mPPCharacter);
        mPPDrink = findViewById(R.id.mPPDrink);
        mPPSmoke = findViewById(R.id.mPPSmoke);
        mPPTravel = findViewById(R.id.mPPTravel);
        mPPSport = findViewById(R.id.mPPSport);
        mPPMusic = findViewById(R.id.mPPMusic);
        mPPFood = findViewById(R.id.mPPFood);
        mPPMovies = findViewById(R.id.mPPMovies);
        mPPSeries = findViewById(R.id.mPPSeries);
        mPPTVShow = findViewById(R.id.mPPTVShow);
        mPPColor = findViewById(R.id.mPPColor);

        mPPHeight.setText("Data");
        mPPEducation.setText("Data");
        mPPIncome.setText("Data");
        mPPFrom.setText("Data");
        mPPJob.setText("Data");
        mPPMotherTongue.setText("Data");
        mPPReligion.setText("Data");
        mPPFamilyType.setText("Data");
        mPPFamilyStatus.setText("Data");
        mPPCharacter.setText("Data");
        mPPDrink.setText("Data");
        mPPSmoke.setText("Data");
        mPPTravel.setText("Data");
        mPPSport.setText("Data");
        mPPMusic.setText("Data");
        mPPFood.setText("Data");
        mPPMovies.setText("Data");
        mPPSeries.setText("Data");
        mPPTVShow.setText("Data");
        mPPColor.setText("Data");
    }

    public void showphotoOptions(View view) {
        PopupMenu popup = new PopupMenu(MyProfile.this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.photo_opt, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.view_ph:
                        Toast.makeText(MyProfile.this, "You clicked on View Photo", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.take_ph:
                        Toast.makeText(MyProfile.this, "You clicked on Take Photo", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.choose_ph:
                        Toast.makeText(MyProfile.this, "You clicked on Choose photo", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.del_ph:
                        Toast.makeText(MyProfile.this, "You clicked on Delete Photo", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void goBack(View view) {
        super.onBackPressed();
    }

    public void editDone(View view) {
        Toast.makeText(MyProfile.this,
                "Edit profile under construction",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void openLists(View view) {
        startActivity(new Intent(MyProfile.this, TabsManager.class));
    }
}