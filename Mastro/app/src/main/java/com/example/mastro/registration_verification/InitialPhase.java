package com.example.mastro.registration_verification;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mastro.R;
import com.hbb20.CountryCodePicker;
import com.muddzdev.styleabletoast.StyleableToast;

import java.util.Objects;

import static java.lang.Character.isUpperCase;

public class InitialPhase extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText mainRegFullName, mainRegEmail, mainRegPhone, mainRegDOB, mainRegPassword, mainRegConfirmPassword, mDisplayDate;
    private CountryCodePicker codePicker;
    private String Fullname, Email, PhoneNumber, DOB, Password, CPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_registration);

        init();
        datePickerHelper();
    }

    private void init() {

        mainRegFullName = findViewById(R.id.mainRegFullName);
        mainRegEmail = findViewById(R.id.mainRegEmail);
        codePicker = findViewById(R.id.countrycode);
        mainRegPhone = findViewById(R.id.mainRegPhone);
        mainRegDOB = findViewById(R.id.mainRegDOB);
        mainRegPassword = findViewById(R.id.mainRegPassword);
        mainRegConfirmPassword = findViewById(R.id.mainRegConfirmPassword);
    }

    private void datePickerHelper() {
        mDisplayDate = findViewById(R.id.mainRegDOB);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog dialog = new DatePickerDialog(InitialPhase.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int month, int day, int year) {
                Toast.makeText(InitialPhase.this, "onDateSet:mm/dd/yyyy:" + month / day / year, Toast.LENGTH_SHORT).show();
                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    }

    public void register(View view) {

        Fullname = mainRegFullName.getText().toString().trim();
        Email = mainRegEmail.getText().toString().trim();
        PhoneNumber = mainRegPhone.getText().toString();
        DOB = mainRegDOB.getText().toString().trim();
        Password = mainRegPassword.getText().toString().trim();
        CPassword = mainRegConfirmPassword.getText().toString().trim();

//        if (checkData()) {
        codePicker.registerCarrierNumberEditText(mainRegPhone);

        Intent intent = new Intent(InitialPhase.this, MiddlePhase.class);
        intent.putExtra("fullname", Fullname);
        intent.putExtra("email", Email);
        intent.putExtra("number", codePicker.getFullNumberWithPlus());
        intent.putExtra("dob", DOB);
        intent.putExtra("password", Password);
        startActivity(intent);
//        }
    }

    public boolean checkData() {
        boolean checked = false;

        if (!Fullname.isEmpty()) {
            if (!Email.isEmpty()) {
                if (emailIsValid()) {
                    if (!PhoneNumber.isEmpty()) {
                        if (numberIsValid()) {
                            if (!Password.isEmpty()) {
                                if (passwordIsValid()) {
                                    if (Password.equals(CPassword)) {
                                        checked = true;
                                    } else {
                                        StyleableToast.makeText(this,
                                                "Passwords are not matching",
                                                R.style.errorToast)
                                                .show();
                                    }
                                } else {
                                    StyleableToast.makeText(this,
                                            "Password must be 8-16 and contain 1 capital letter, 1 special character and 1 number ",
                                            R.style.errorToast)
                                            .show();
                                }
                            } else {
                                StyleableToast.makeText(this,
                                        "Create Password",
                                        R.style.errorToast)
                                        .show();
                            }
                        } else {
                            StyleableToast.makeText(this,
                                    "Enter valid Phone number",
                                    R.style.errorToast)
                                    .show();
                        }
                    } else {
                        if (!Password.isEmpty()) {
                            if (passwordIsValid()) {
                                if (Password.equals(CPassword)) {
                                    checked = true;
                                } else {
                                    StyleableToast.makeText(this,
                                            "Passwords are not matching",
                                            R.style.errorToast)
                                            .show();
                                }
                            } else {
                                StyleableToast.makeText(this,
                                        "Password must be 8-16 and contain 1 capital letter, 1 special character and 1 number ",
                                        R.style.errorToast)
                                        .show();
                            }
                        } else {
                            StyleableToast.makeText(this,
                                    "Create Password",
                                    R.style.errorToast)
                                    .show();
                        }
                    }
                } else {
                    StyleableToast.makeText(this,
                            "enter valid email",
                            R.style.errorToast)
                            .show();
                }
            } else {
                if (!PhoneNumber.isEmpty()) {
                    if (numberIsValid()) {
                        if (!Password.isEmpty()) {
                            if (passwordIsValid()) {
                                if (Password.equals(CPassword)) {
                                    checked = true;
                                } else {
                                    StyleableToast.makeText(this,
                                            "Passwords are not matching",
                                            R.style.errorToast)
                                            .show();
                                }
                            } else {
                                StyleableToast.makeText(this,
                                        "Password must be 8-16 and contain 1 capital letter, 1 special character and 1 number ",
                                        R.style.errorToast)
                                        .show();
                            }
                        } else {
                            StyleableToast.makeText(this,
                                    "Create Password",
                                    R.style.errorToast)
                                    .show();
                        }
                    } else {
                        StyleableToast.makeText(this,
                                "Enter valid Phone number",
                                R.style.errorToast)
                                .show();
                    }
                } else {
                    StyleableToast.makeText(this,
                            "Enter email or Phone number",
                            R.style.errorToast)
                            .show();
                }
            }
        } else {
//            StyleableToast.makeText(this,
//                    "Fullname is required",
//                    R.style.errorToast)
//                    .show();
            mainRegFullName.setError("Fullname");
        }

        return checked;
    }

    public boolean emailIsValid() {
        String str = Email;
        boolean checked;
        int a = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '@' || str.charAt(i) == '.') {
                a++;
            }
        }
        checked = a == 2;
        return checked;
    }

    private boolean numberIsValid() {
        boolean checked = false;
        if (PhoneNumber.length() == 10) {
            checked = true;
        }
        return checked;
    }

    private boolean passwordIsValid() {
        String str = Password;
        boolean checked;
        int UpperCaseCount = 0;
        int SpecialCharacterCount = 0;
        int NumbersCount = 0;
        int NumberOfdigit = 0;

        for (int i = 0; i < str.length(); i++) {

            int ascii = (int) str.charAt(i);

            //Checks whether a password contain special character or not
            if (str.charAt(i) == '.' || str.charAt(i) == '!' || str.charAt(i) == '@' || str.charAt(i) == '#' || str.charAt(i) == '$' || str.charAt(i) == '%' || str.charAt(i) == '^' || str.charAt(i) == '&' || str.charAt(i) == '*') {
                SpecialCharacterCount++;

                //Checks whether a password contain uppercase or not
            } else if (isUpperCase(str.charAt(i))) {
                UpperCaseCount++;

                //Checks whether a password contain number or not
            } else if ((ascii >= 48 && ascii <= 57)) {
                NumbersCount++;
            }
            NumberOfdigit++;
        }

        checked = (SpecialCharacterCount > 0) && (UpperCaseCount > 0) && (NumbersCount > 0) && ((NumberOfdigit > 8) && (NumberOfdigit < 16));
        return checked;
    }

    public void moveToLogin(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}