package com.example.mastro.home.date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mastro.drawer_Item.my_acc.MyAccount;
import com.example.mastro.drawer_Item.NotificationAndSound;
import com.example.mastro.drawer_Item.Premium;
import com.example.mastro.drawer_Item.my_profile.MyProfile;
import com.example.mastro.nav_Item.date.DTrending;
import com.example.mastro.nav_Item.date.DContent;
import com.example.mastro.home.matrimony.MHome;
import com.example.mastro.message.Inbox;
import com.example.mastro.nav_Item.Notification;
import com.example.mastro.R;
import com.example.mastro.nav_Item.view_profile.ViewProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.mikhaellopez.circularimageview.CircularImageView;

public class DHome extends AppCompatActivity {

    DrawerLayout dDrawerLayout;
    NavigationView dNavigationView;
    BottomNavigationView dBottomNavigationView;
    CircularImageView drawerProfilePicture;
    TextView appName, drawerFullname, drawerSection;

    String no = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_home);

        init();
        setGradientOnAppName();
        navigationItemsHandler();
        drawerItemsHandler();

    }

    @SuppressLint("SetTextI18n")
    private void init() {
        dDrawerLayout = findViewById(R.id.dHomeLayout);
        dNavigationView = findViewById(R.id.dDrawer);
        dBottomNavigationView = findViewById(R.id.dNav);

        dNavigationView.setItemIconTintList(null);
        dBottomNavigationView.setItemIconTintList(null);

//        drawerProfilePicture = findViewById(R.id.drawerProfilePicture);
//        drawerFullname = findViewById(R.id.drawerFullname);
//        drawerSection = findViewById(R.id.drawerSection);
//
//        drawerProfilePicture.setImageResource(R.drawable.girls);
//        drawerFullname.setText("Data");
//        drawerSection.setText("Data");
    }

    public void setGradientOnAppName() {
        appName = findViewById(R.id.dAppName);
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

        getSupportFragmentManager().beginTransaction().replace(R.id.dFragContainer, new DContent()).commit();

        dBottomNavigationView = findViewById(R.id.dNav);
        dBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.interest:
                        showFragment(new DContent());
                        break;
                    case R.id.trending:
                        startActivity(new Intent(DHome.this, DTrending.class));
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
        getSupportFragmentManager().beginTransaction().replace(R.id.dFragContainer, fragment).commit();
    }

    public void openDrawer(View view) {
        if (dDrawerLayout.isDrawerOpen(dNavigationView)) {
            dDrawerLayout.closeDrawer(dNavigationView);
        } else {
            dDrawerLayout.openDrawer(dNavigationView);
        }
    }

    private void drawerItemsHandler() {
        dNavigationView = findViewById(R.id.dDrawer);
        dNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.switch_acc:
                        switchAccount();
                        break;
                    case R.id.account:
                        startActivity(new Intent(DHome.this, MyAccount.class));
                        break;
                    case R.id.premium:
                        startActivity(new Intent(DHome.this, Premium.class));
                        break;
                    case R.id.n_and_s:
                        startActivity(new Intent(DHome.this, NotificationAndSound.class));
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
                dDrawerLayout.closeDrawer(dNavigationView);
                return true;
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void switchAccount() {

        final Dialog accSwitchDialog = new Dialog(DHome.this);
        accSwitchDialog.setContentView(R.layout.acc_switch_alert);

        ImageView cancel = accSwitchDialog.findViewById(R.id.closeAlertMsg);
        TextView switch_info = accSwitchDialog.findViewById(R.id.switchText);
        EditText check_pass = accSwitchDialog.findViewById(R.id.switchCheckPassword);
        Button ok = accSwitchDialog.findViewById(R.id.switchOK);

        switch_info.setText("Wanna switch to Matrimony ?");
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
                ProgressDialog pd = new ProgressDialog(DHome.this);
                pd.setTitle("Welcome to Matrimony");
                pd.setMessage("Hope you find your soul mate");
                pd.show();
                startActivity(new Intent(DHome.this, MHome.class));
            }
        });

    }

    public void openInbox(View view) {
        startActivity(new Intent(DHome.this, Inbox.class));
    }

    public void openMyProfile(View view) {
        startActivity(new Intent(DHome.this, MyProfile.class));
    }

    public void openFeedProfile(View view) {
        startActivity(new Intent(DHome.this, ViewProfile.class));
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().beginTransaction().replace(R.id.dFragContainer, new DContent()).commit();
    }
}