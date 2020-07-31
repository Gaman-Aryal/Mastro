package com.example.mastro.registration_verification.date;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mastro.R;
import com.example.mastro.login.Login;
import com.example.mastro.registration_verification.Verification;
import com.example.mastro.registration_verification.matrimony.MRegistration;

import java.util.Calendar;
import java.util.Objects;

public class DRegistration extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText mainRegFullName, mainRegEmailOrPhone, mainRegDOB, mainRegPassword, mainRegConfirmPassword, mDisplayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_registration);

        init();
        datePickerHelper();
    }

    private void init() {

        mainRegFullName = findViewById(R.id.mainRegFullName);
        mainRegEmailOrPhone = findViewById(R.id.mainRegEmailOrPhone);
        mainRegDOB = findViewById(R.id.mainRegDOB);
        mainRegPassword = findViewById(R.id.mainRegPassword);
        mainRegConfirmPassword = findViewById(R.id.mainRegConfirmPassword);

    }

    private void datePickerHelper() {
        mDisplayDate = findViewById(R.id.mainRegDOB);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog dialog = new DatePickerDialog(DRegistration.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int month, int day, int year) {
                Toast.makeText(DRegistration.this, "onDateSet:mm/dd/yyyy:" + month / day / year, Toast.LENGTH_SHORT).show();
                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    }

    public void register(View view) {
        setContentView(R.layout.date_matro_selector);
    }

    public void date(View view) {
        startActivity(new Intent(this, Verification.class));
    }

    public void Matrimony(View view) {
        startActivity(new Intent(this, MRegistration.class));
    }

    public void moveToLogin(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}