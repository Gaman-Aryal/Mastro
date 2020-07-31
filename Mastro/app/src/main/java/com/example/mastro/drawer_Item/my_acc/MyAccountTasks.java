package com.example.mastro.drawer_Item.my_acc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mastro.R;

public class MyAccountTasks extends AppCompatActivity {

    String choosedTask;
    TextView issue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent receiveTask = getIntent();
        choosedTask = receiveTask.getStringExtra("choosenTask");
        assert choosedTask != null;
        switch (choosedTask) {
            case "ch_emailorphone":
                setContentView(R.layout.change_email_phone);
                break;
            case "ch_password":
                setContentView(R.layout.change_pass);
                break;
            case "openblocklist":
                setContentView(R.layout.blocks);
                break;
            default:
                Toast.makeText(MyAccountTasks.this,
                        "Sorry, Something went wrong",
                        Toast.LENGTH_SHORT)
                        .show();
                onBackPressed();
                break;
        }
    }

    public void moveBack(View view) {
        this.finish();
    }

    public void updateEmailOrPhone(View view) {
        Toast.makeText(MyAccountTasks.this, "Under Construction", Toast.LENGTH_SHORT).show();
    }

    public void updatePassword(View view) {
        Toast.makeText(MyAccountTasks.this, "Under Construction", Toast.LENGTH_SHORT).show();
    }

    public void blockUser(View view) {
        Toast.makeText(MyAccountTasks.this, "Under Construction", Toast.LENGTH_SHORT).show();
    }

    public void unblockUser(View view) {
        Toast.makeText(MyAccountTasks.this, "Under Construction", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}