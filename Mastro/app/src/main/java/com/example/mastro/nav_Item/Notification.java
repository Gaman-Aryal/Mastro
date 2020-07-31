package com.example.mastro.nav_Item;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mastro.R;

import java.util.Objects;

public class Notification extends Fragment {

    ImageView notifPhoto;
    TextView notifContent, notifTimeInterval;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.d_frag_notifi, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @SuppressLint("SetTextI18n")
    private void init(View view) {
        notifPhoto = view.findViewById(R.id.notifPhoto);
        notifContent = view.findViewById(R.id.notifContent);
        notifTimeInterval = view.findViewById(R.id.notifTimeInterval);

        notifPhoto.setImageResource(R.drawable.girls);
        notifContent.setText("Emly Julia");
        notifTimeInterval.setText("3"+ "hours age");
    }

}