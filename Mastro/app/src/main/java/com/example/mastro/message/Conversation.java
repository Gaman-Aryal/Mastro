package com.example.mastro.message;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mastro.R;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Conversation extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView convDrawerNav;
    CircleImageView convPicture, convSetMyPicture, convSetPicture;
    ImageView drager, mic, camera, gallery, sendMsg, sendLove;
    EditText typedMsg, convSetMyName, convSetName;
    TextView convName, convActiveStatus, convWantCallResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conv_box);

        init();
        resizingDrawer();
        msgTypingStarted();
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        convPicture = findViewById(R.id.convPicture);
        convName = findViewById(R.id.convName);
        convActiveStatus = findViewById(R.id.convActiveStatus);

        drager = findViewById(R.id.drager);
        mic = findViewById(R.id.mic);
        camera = findViewById(R.id.camera);
        gallery = findViewById(R.id.gallery);
        typedMsg = findViewById(R.id.typedMsg);
        sendMsg = findViewById(R.id.sendMsg);
        sendLove = findViewById(R.id.sendLove);

        mic.setVisibility(View.VISIBLE);
        camera.setVisibility(View.VISIBLE);
        gallery.setVisibility(View.VISIBLE);
        drager.setVisibility(View.GONE);
        sendLove.setVisibility(View.VISIBLE);
        sendMsg.setVisibility(View.INVISIBLE);

        convPicture.setImageResource(R.drawable.girls);
        convName.setText("Data");
        convActiveStatus.setText("Data");

    }

    @Override
    protected void onResume() {
        super.onResume();
        mic.setVisibility(View.VISIBLE);
        camera.setVisibility(View.VISIBLE);
        gallery.setVisibility(View.VISIBLE);
        drager.setVisibility(View.GONE);
        sendLove.setVisibility(View.VISIBLE);
        sendMsg.setVisibility(View.INVISIBLE);
    }

    public void showConvPhoto(View view) {
        if (convPicture.getVisibility() == View.GONE) {
            convPicture.setVisibility(View.VISIBLE);
        } else {
            convPicture.setVisibility(View.GONE);
        }
    }

    private void resizingDrawer() {
        drawerLayout = findViewById(R.id.drawerLayout);
        convDrawerNav = findViewById(R.id.convDrawerNav);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        convDrawerNav.getLayoutParams().width = width;
        convDrawerNav.getLayoutParams().height = height;
    }

    public void openConvSettings(View view) {
        if (drawerLayout.isDrawerOpen(convDrawerNav)) {
            drawerLayout.closeDrawer(convDrawerNav);
        } else {
            drawerLayout.openDrawer(convDrawerNav);
            showDataOnConvSet();
        }
    }

    @SuppressLint("SetTextI18n")
    public void showDataOnConvSet() {
        convWantCallResult = findViewById(R.id.convWantCallResult);
        convSetMyPicture = findViewById(R.id.convSetMyPicture);
        convSetMyName = findViewById(R.id.convSetMyName);
        convSetPicture = findViewById(R.id.convSetPicture);
        convSetName = findViewById(R.id.convSetName);

        convSetMyName.setText("Data");
        convSetName.setText("Data");
        convSetMyPicture.setImageResource(R.drawable.girls);
        convSetPicture.setImageResource(R.drawable.girls);

    }

    private void msgTypingStarted() {
        typedMsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mic.setVisibility(View.GONE);
                camera.setVisibility(View.GONE);
                gallery.setVisibility(View.GONE);
                drager.setVisibility(View.VISIBLE);
                sendLove.setVisibility(View.INVISIBLE);
                sendMsg.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void changeIconsVisibility(View view) {
        if (mic.getVisibility() == View.GONE) {
            mic.setVisibility(View.VISIBLE);
            camera.setVisibility(View.VISIBLE);
            gallery.setVisibility(View.VISIBLE);
        } else {
            mic.setVisibility(View.GONE);
            camera.setVisibility(View.GONE);
            gallery.setVisibility(View.GONE);
        }
    }

    public void sendLove(View view) {
        Toast.makeText(Conversation.this,
                "Send Love Clicked",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void sendMsg(View view) {
        mic.setVisibility(View.VISIBLE);
        camera.setVisibility(View.VISIBLE);
        gallery.setVisibility(View.VISIBLE);
        drager.setVisibility(View.GONE);
        sendLove.setVisibility(View.VISIBLE);
        sendMsg.setVisibility(View.INVISIBLE);
        Toast.makeText(Conversation.this,
                "Send Message Clicked",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void makeAudioCall(View view) {
        Toast.makeText(Conversation.this,
                "Under Construction",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void makeVideoCall(View view) {
        Toast.makeText(Conversation.this,
                "Under Construction",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void changeActiveStatusForParticular(View view) {
        Toast.makeText(Conversation.this,
                "Under Construction",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void changeNotificationStatusForParticular(View view) {
        Toast.makeText(Conversation.this,
                "Under Construction",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void changeWantCall(View view) {
        PopupMenu popup = new PopupMenu(Conversation.this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.want_call, popup.getMenu());
        convWantCallResult = view.findViewById(R.id.convWantCallResult);

        popup.show();
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.yes:
                        Toast.makeText(Conversation.this,
                                "Yes Clicked",
                                Toast.LENGTH_SHORT)
                                .show();
                        return true;
                    case R.id.no:
                        Toast.makeText(Conversation.this,
                                "No Clicked",
                                Toast.LENGTH_SHORT)
                                .show();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    public void deleteConv(View view) {
        Toast.makeText(Conversation.this,
                "Under Construction",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void unMatch(View view) {
        Toast.makeText(Conversation.this,
                "Under Construction",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void block(View view) {
        Toast.makeText(Conversation.this,
                "Under Construction",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void report(View view) {
        Toast.makeText(Conversation.this,
                "Under Construction",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(convDrawerNav)) {
            this.drawerLayout.closeDrawer(convDrawerNav);
        } else if (drager.getVisibility() == View.VISIBLE) {
            mic.setVisibility(View.VISIBLE);
            camera.setVisibility(View.VISIBLE);
            gallery.setVisibility(View.VISIBLE);
            drager.setVisibility(View.GONE);
            sendLove.setVisibility(View.VISIBLE);
            sendMsg.setVisibility(View.INVISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    public void closeConvSet(View view) {
        drawerLayout.closeDrawer(convDrawerNav);
    }

    public void back(View view) {
        this.finish();
    }
}