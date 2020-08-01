package com.example.mastro.registration_verification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.example.mastro.R;
import com.google.android.material.textfield.TextInputLayout;

public class FinalRegistration extends AppCompatActivity {
    AutoCompleteTextView ProfileCreator, MatrimonyPhysicalHealthCondition, matrimonyJobDetail, MatrimonyHeightDetail, MatrimonyFamilyStatus, MatrimonyReligion;
    RadioGroup radio_btn;
    TextInputLayout Bridename;

    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    EditText BrideName;
    LinearLayout BrideDetails;


    private AutoCompleteTextView mRProfileCreator, mRReligion, mRHealthStatus,mRJob,mRHeight,mRFamilySize,mRFamilyStatus;
    EditText mRLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_registration);

        init();
//        ProfileCreator = findViewById(R.id.mRProfileCreator);
//        MatrimonyPhysicalHealthCondition = findViewById(R.id.mRHealthStatus);
//        matrimonyJobDetail = findViewById(R.id.mRJob);
//        MatrimonyHeightDetail = findViewById(R.id.mRHeight);
//        MatrimonyFamilyStatus = findViewById(R.id.mRFamilyStatus);
//        mDisplayDate = findViewById(R.id.mRDateOfBirth);
//        radio_btn = findViewById(R.id.mRRadioGroupGender);
//        MatrimonyReligion = findViewById(R.id.mRReligion);
//        Bridename = findViewById(R.id.textInputBrideName);
//        BrideName = findViewById(R.id.mRBrideGroomName);
//        BrideDetails = findViewById(R.id.BrideDetails);
//
//
//        mDisplayDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               Calendar calendar = Calendar.getInstance();
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//                int month = calendar.get(Calendar.MONTH);
//                int year = calendar.get(Calendar.YEAR);
//                // date picker dialog
//                DatePickerDialog dialog = new DatePickerDialog(FinalRegistration.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int month, int day, int year) {
//                Toast.makeText(FinalRegistration.this, "onDateSet:mm/dd/yyyy:"+ month/day/year, Toast.LENGTH_SHORT).show();
//                String date =month+"/"+day+"/"+year;
//                mDisplayDate.setText(date);
//            }
//        };


//        String [] religionArray = getResources().getStringArray(R.array.religion);
//        ArrayAdapter<String> religionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, religionArray);
//        MatrimonyReligion.setAdapter(religionAdapter);
//
//
//
//        final String [] CreatorArray=getResources().getStringArray(R.array.Creator);
//        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, CreatorArray);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        ProfileCreator.setAdapter(adapter);
//
//        ProfileCreator.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {
//                //pos is the position of the selected item
//
//                String name = CreatorArray[pos];
//                if(pos ==0){
//                    Toast.makeText(FinalRegistration.this, CreatorArray[pos], Toast.LENGTH_SHORT).show();
//                    BrideDetails.setVisibility(View.GONE);
//                }
//                else{
//                    Toast.makeText(FinalRegistration.this, CreatorArray[pos], Toast.LENGTH_SHORT).show();
//                    BrideDetails.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//        String [] PhysicalHealth=getResources().getStringArray(R.array.HealthCondition);
//        ArrayAdapter <String> PhysicalHealthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, PhysicalHealth);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        MatrimonyPhysicalHealthCondition.setAdapter(PhysicalHealthAdapter);
//
//        MatrimonyPhysicalHealthCondition.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {
//                //pos is the position of the selected item
//
//            }
//        });
//
//        String [] JobArray=getResources().getStringArray(R.array.Jobs);
//
//        ArrayAdapter <String> JobAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, JobArray);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        matrimonyJobDetail.setAdapter(JobAdapter);
//
//        matrimonyJobDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {
//                //pos is the position of the selected item
//
//            }
//        });
//
//        final String [] HeightArray=getResources().getStringArray(R.array.Height);
//
//        ArrayAdapter <String> HeightAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, HeightArray);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        MatrimonyHeightDetail.setAdapter(HeightAdapter);
//
//        MatrimonyHeightDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {
//                //pos is the position of the selected item
//
//            }
//        });
//
//        final String [] FamilyStatusArray=getResources().getStringArray(R.array.FamilyStatus);
//        ArrayAdapter <String> FamilyStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, FamilyStatusArray);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        MatrimonyFamilyStatus.setAdapter(FamilyStatusAdapter);
//
//        MatrimonyFamilyStatus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {
//                //pos is the position of the selected item
//
//            }
//        });
    }

    private void init() {
        mRProfileCreator = findViewById(R.id.mRProfileCreator);
        mRLocation = findViewById(R.id.mRLocation);
        mRHeight = findViewById(R.id.mRHeight);
        mRReligion = findViewById(R.id.mRReligion);
        mRHealthStatus = findViewById(R.id.mRHealthStatus);
        mRJob = findViewById(R.id.mRJob);
        mRFamilySize = findViewById(R.id.mRFamilySize);
        mRFamilyStatus = findViewById(R.id.mRFamilyStatus);

    }


    public void Matro(View view) {
        startActivity(new Intent(this, MiddlePhase.class));
        Toast.makeText(this, "FinalRegistration Pressed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}




