package com.example.mastro.drawer_Item.my_profile.tabs;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class TabsAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int tabCount;
    public TabsAdapter(Context context, @NonNull FragmentManager fm,int tabCount) {
        super(fm);
        myContext = context;
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Like like = new Like();
                return like;
            case 1:
                Match match = new Match();
                return match;
            case 2:
                Request request = new Request();
                return request;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
