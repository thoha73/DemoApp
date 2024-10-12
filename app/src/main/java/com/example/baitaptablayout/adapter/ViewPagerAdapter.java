package com.example.baitaptablayout.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.baitaptablayout.fragment.HomeFragment;
import com.example.baitaptablayout.fragment.NotificaionFragment;
import com.example.baitaptablayout.fragment.ProfileFragment;
import com.example.baitaptablayout.fragment.SearchFragment;
import com.example.baitaptablayout.fragment.SettingFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new NotificaionFragment();
            case 2:
                return new SearchFragment();
//            case 3:
//                return new SettingFragment();
            case 3:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
