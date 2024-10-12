//package com.example.baitaptablayout.adapter;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.fragment.app.FragmentStatePagerAdapter;
//import com.example.baitaptablayout.Order.Tab2Fragment;
//import com.example.baitaptablayout.Order.Tab3Fragment;
//import com.example.baitaptablayout.Order.TabFragment;
//
//public class OrderViewPageAdapter extends FragmentStatePagerAdapter{
//    public OrderViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
//        super(fm, behavior);
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return new TabFragment();
//            case 1:
//                return new Tab2Fragment();
//            case 2:
//                return new Tab3Fragment();
//            default:
//                return new TabFragment();
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return 3;
//    }
//
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position){
//            case 0:
//                return "New";
//            case 1:
//                return "Popular";
//            case 2:
//                return "Category";
//            default:
//                return "New";
//        }
//    }
//}
package com.example.baitaptablayout.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class OrderViewPageAdapter extends FragmentStatePagerAdapter {
    private final ArrayList<Fragment> fragmentList = new ArrayList<>();
    private final ArrayList<String> fragmentTitleList = new ArrayList<>();

    public OrderViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}


