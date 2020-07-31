package com.example.mastro.home.matrimony;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mastro.drawer_Item.my_acc.MyAccount;
import com.example.mastro.drawer_Item.NotificationAndSound;
import com.example.mastro.drawer_Item.Premium;
import com.example.mastro.drawer_Item.my_profile.MyProfile;
import com.example.mastro.home.date.DHome;
import com.example.mastro.nav_Item.matrimony.MAstro;
import com.example.mastro.nav_Item.matrimony.MContent;
import com.example.mastro.message.Inbox;
import com.example.mastro.nav_Item.Notification;
import com.example.mastro.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MHome extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    BottomNavigationView mBottomNavigationView;

    TextView appName, drawerFullname, drawerSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_home);

        init();
        setGradientOnAppName();
        navigationItemsHandler();
        drawerItemsHandler();

    }

    private void init() {
        mDrawerLayout = findViewById(R.id.mHomeLayout);
        mNavigationView = findViewById(R.id.mDrawer);
        mBottomNavigationView = findViewById(R.id.mNav);

        mBottomNavigationView.setItemIconTintList(null);
        mNavigationView.setItemIconTintList(null);

//        drawerFullname = findViewById(R.id.drawerFullname);
//        drawerSection = findViewById(R.id.drawerSection);
//        drawerFullname.setText("Data");
//        drawerSection.setText("Data");
    }

    private void setGradientOnAppName() {
        appName = findViewById(R.id.mAppName);
        TextPaint paint = appName.getPaint();
        float width = paint.measureText("Application");

        Shader shader = new LinearGradient(0, 0, width, appName.getTextSize(),
                new int[]{
                        Color.parseColor("#B205E3"),
                        Color.parseColor("#ffb454"),
                        Color.parseColor("#0688F1"),
                }, null, Shader.TileMode.CLAMP);
        appName.getPaint().setShader(shader);

    }

    private void navigationItemsHandler() {

        getSupportFragmentManager().beginTransaction().replace(R.id.mFragContainer, new MContent()).commit();

        mBottomNavigationView = findViewById(R.id.mNav);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.interest:
                        showFragment(new MContent());
                        break;
                    case R.id.trending:
                        showFragment(new MAstro());
                        break;
                    case R.id.notification:
                        showFragment(new Notification());
                        break;
                }
                return true;
            }
        });
    }

    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mFragContainer, fragment).commit();
    }

    public void openDrawer(View view) {
        if (mDrawerLayout.isDrawerOpen(mNavigationView)) {
            mDrawerLayout.closeDrawer(mNavigationView);
        } else {
            mDrawerLayout.openDrawer(mNavigationView);
        }
    }

    private void drawerItemsHandler() {
        mNavigationView = findViewById(R.id.mDrawer);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.switch_acc:
                        switchAccount();
                        break;
                    case R.id.account:
                        startActivity(new Intent(MHome.this, MyAccount.class));
                        break;
                    case R.id.premium:
                        startActivity(new Intent(MHome.this, Premium.class));
                        break;
                    case R.id.n_and_s:
                        startActivity(new Intent(MHome.this, NotificationAndSound.class));
                        break;
                    case R.id.tutorial:
//                        startActivity(new Intent(DHome.this, Feature.class));
//                        break;
                    case R.id.report:
//                        startActivity(new Intent(DHome.this, Feature.class));
//                        break;
                    case R.id.terms:
//                        setContentView(R.layout.terms);
//                        break;
                    case R.id.logout:
//                        setContentView(R.layout.login);
//                        break;
                }
                mDrawerLayout.closeDrawer(mNavigationView);
                return true;
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void switchAccount() {
        final Dialog accSwitchDialog = new Dialog(MHome.this);
        accSwitchDialog.setContentView(R.layout.acc_switch_alert);

        ImageView cancel = accSwitchDialog.findViewById(R.id.closeAlertMsg);
        TextView switch_info = accSwitchDialog.findViewById(R.id.switchText);
        EditText check_pass = accSwitchDialog.findViewById(R.id.switchCheckPassword);
        Button ok = accSwitchDialog.findViewById(R.id.switchOK);

        switch_info.setText("Wanna switch to Date ?");
        accSwitchDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        accSwitchDialog.show();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accSwitchDialog.dismiss();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog pd = new ProgressDialog(MHome.this);
                pd.setTitle("Welcome to Date");
                pd.setMessage("Beautiful peoples are waiting for you ");
                pd.show();
                startActivity(new Intent(MHome.this, DHome.class));
            }
        });

    }

    public void openInbox(View view) {
        startActivity(new Intent(MHome.this, Inbox.class));
    }

    public void openMyProfile(View view) {
        startActivity(new Intent(MHome.this, MyProfile.class));
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().beginTransaction().replace(R.id.mFragContainer, new MContent()).commit();
    }
}