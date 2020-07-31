package com.example.mastro.message;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mastro.R;

public class Inbox extends AppCompatActivity {

    private ImageView cancelSearch, searchIcon, sAPhoto, sMsgPhoto, sMsgStatusIcon;
    private EditText search;
    private TextView pageTitle, sAName, sMsgName, sMsgOfWhom, slastMsg;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox);

        init();
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        pageTitle = findViewById(R.id.pageTitle);
        pageTitle.setText("Inbox");

        cancelSearch = findViewById(R.id.cancelSearch);
        searchIcon = findViewById(R.id.iSearchIcon);
        search = findViewById(R.id.iSearch);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cancelSearch.setVisibility(View.GONE);
                searchIcon.setVisibility(View.GONE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cancelSearch.setVisibility(View.VISIBLE);
                searchIcon.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        cancelSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.setText("");
                cancelSearch.setVisibility(View.GONE);
            }
        });

        sAPhoto = findViewById(R.id.sAPhoto);
        sAName = findViewById(R.id.sAName);

        sMsgPhoto = findViewById(R.id.sMsgPhoto);
        sMsgName = findViewById(R.id.sMsgName);
        sMsgStatusIcon = findViewById(R.id.sMsgStatusIcon);
        sMsgOfWhom = findViewById(R.id.sMsgOfWhom);
        slastMsg = findViewById(R.id.slastMsg);

        sAPhoto.setImageResource(R.drawable.girls);
        sAName.setText("Emly Julia");

        sMsgPhoto.setImageResource(R.drawable.girls);
        sMsgName.setText("Emly Julia");
        sMsgStatusIcon.setImageResource(R.drawable.ic_edit);
        sMsgOfWhom.setText("you"+" :");
        slastMsg.setText("wat's up ?");
    }

    public void showMsgOptions(View view) {
        PopupMenu msgOpt = new PopupMenu(Inbox.this, view);
        MenuInflater inflater = msgOpt.getMenuInflater();
        inflater.inflate(R.menu.msg_opt, msgOpt.getMenu());
        msgOpt.show();
        msgOpt.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.view_profile:
                        Toast.makeText(Inbox.this,
                                "You clicked on View Profile",
                                Toast.LENGTH_SHORT)
                                .show();
                        return true;
//                    case R.id.ignore_msg:
//                        Toast.makeText(Inbox.this,
//                                "You clicked on Ignore Conversation",
//                                Toast.LENGTH_SHORT)
//                                .show();
//                        return true;
                    case R.id.del_conv:
                        Toast.makeText(Inbox.this,
                                "You clicked on Delete Conversation",
                                Toast.LENGTH_SHORT)
                                .show();
                        return true;
                    case R.id.unmatch:
                        Toast.makeText(Inbox.this,
                                "You clicked on Unmatch",
                                Toast.LENGTH_SHORT)
                                .show();
                        return true;
                    case R.id.report:
                        Toast.makeText(Inbox.this,
                                "You clicked on Report",
                                Toast.LENGTH_SHORT)
                                .show();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

//    @Override
//    public void onBackPressed() {
////        if (searchIcon.getVisibility() == View.VISIBLE) {
////            search.setText("");
////            search.clearFocus();
////            cancelSearch.setVisibility(View.GONE);
////            searchIcon.setVisibility(View.GONE);
////        }else {
//            onBackPressed();
////        }
//    }

    public void openConvBox(View view) {
        startActivity(new Intent(Inbox.this, Conversation.class));
    }

    public void moveBack(View view) {
        onBackPressed();
    }
}