package com.example.mastro.drawer_Item.my_acc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mastro.home.date.DHome;
import com.example.mastro.home.matrimony.MHome;
import com.example.mastro.R;

public class MyAccount extends AppCompatActivity {

    TextView page_title;
    String previousActivity;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account);

        Intent getdata = getIntent();
        previousActivity = getdata.getStringExtra("previousActivity");

        page_title = findViewById(R.id.pageTitle);
        page_title.setText("Settings");

    }

    public void moveBack(View view) {
        this.finish();
    }

    public void changeActiveStatus(View view) {
    }

    public void changeEmailOrPhone(View view) {
        passChosenTask("ch_emailorphone");
    }

    public void changePassword(View view) {
        passChosenTask("ch_password");
    }

    public void openBlockList(View view) {
        passChosenTask("openblocklist");
    }

    public void changeAccountVisibility(View view) {
    }

    public void deactivateAccount(View view) {
    }

    public void deleteAccountPermanently(View view) {
    }

    public void passChosenTask(String task) {
        Intent pass = new Intent(MyAccount.this, MyAccountTasks.class);
        pass.putExtra("choosenTask", task);
        startActivity(pass);
    }


}