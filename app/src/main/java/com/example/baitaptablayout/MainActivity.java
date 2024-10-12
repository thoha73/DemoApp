package com.example.baitaptablayout;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.baitaptablayout.R;

import com.example.baitaptablayout.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        ViewPagerAdapter adapter= new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_notification).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_search).setChecked(true);
                        break;
//                    case 3:
//                        bottomNavigationView.getMenu().findItem(R.id.menu_setting).setChecked(true);
//                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.menu_profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Map<Integer, Integer> menuItemToViewPagerMap = new HashMap<>();
        menuItemToViewPagerMap.put(R.id.menu_home, 0);
        menuItemToViewPagerMap.put(R.id.menu_notification, 1);
        menuItemToViewPagerMap.put(R.id.menu_search, 2);
//        menuItemToViewPagerMap.put(R.id.menu_setting, 3);
        menuItemToViewPagerMap.put(R.id.menu_profile, 3);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Integer position = menuItemToViewPagerMap.get(item.getItemId());
                if (position != null) {
                    viewPager.setCurrentItem(position);
                    return true;
                }
                return false;
            }
        });
    }
}