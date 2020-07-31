package com.example.mastro.nav_Item.matrimony;

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
import com.mikhaellopez.circularimageview.CircularImageView;

public class MContent extends Fragment {

    CircularImageView mCircularPhoto;
    ImageView mCProfilePic;
    TextView mCName, mCJob;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.m_frag_home, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCircularPhoto = view.findViewById(R.id.mCircularPhoto);
        mCProfilePic = view.findViewById(R.id.mCProfilePic);
        mCName = view.findViewById(R.id.mCName);
        mCJob = view.findViewById(R.id.mCJob);

        mCircularPhoto.setImageResource(R.drawable.girls);
        mCProfilePic.setImageResource(R.drawable.girls);
        mCName.setText("Data");
        mCJob.setText("Data");
    }
}