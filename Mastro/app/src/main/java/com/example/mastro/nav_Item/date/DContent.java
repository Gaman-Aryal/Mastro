package com.example.mastro.nav_Item.date;

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


import org.jetbrains.annotations.NotNull;


public class DContent extends Fragment {

    ImageView dCProfilePic;
    TextView dCFullname,dCAge,dCGender,dCUniversity,dCHowFar;
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.d_frag_home, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dCProfilePic = view.findViewById(R.id.dCProfilePic);
        dCFullname = view.findViewById(R.id.dCFullname);
        dCAge = view.findViewById(R.id.dCAge);
        dCGender = view.findViewById(R.id.dCGender);
        dCUniversity = view.findViewById(R.id.dCUniversity);
        dCHowFar = view.findViewById(R.id.dCHowFar);

        dCProfilePic.setImageResource(R.drawable.girls);
        dCFullname.setText("Emly Julia"+" ,");
        dCAge.setText("23");
        dCGender.setText("Female");
        dCUniversity.setText("University of Wolverhampton");
        dCHowFar.setText("3km far from you");
    }
}