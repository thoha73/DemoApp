package com.example.baitaptablayout.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.baitaptablayout.R;
import com.example.baitaptablayout.adapter.OrderViewPageAdapter;
import com.example.baitaptablayout.model.Book;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class NotificaionFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View myView;
    private ImageView btn_back;
    public NotificaionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView= inflater.inflate(R.layout.fragment_notificaion, container, false);
        tabLayout=myView.findViewById(R.id.tabLayout);
        viewPager=myView.findViewById(R.id.viewPager);
        OrderViewPageAdapter adapter=new OrderViewPageAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        List<Book> bookList=loadBookData();
        TabFragment tabFragment=new TabFragment();
        Tab2Fragment tabFragment1= new Tab2Fragment();
        Tab3Fragment tabFragment2= new Tab3Fragment();
        Bundle bundle= new Bundle();
        bundle.putParcelableArrayList("data", new ArrayList<>(bookList));
        tabFragment.setArguments(bundle);

        Bundle bundle1= new Bundle();
        bundle1.putParcelableArrayList("data1", new ArrayList<>(loadBookData1()));
        tabFragment1.setArguments(bundle1);

        Bundle bundle2= new Bundle();
        bundle2.putParcelableArrayList("data2", new ArrayList<>(loadBookData2()));
        tabFragment2.setArguments(bundle2);

        adapter.addFragment(tabFragment,"New");
        adapter.addFragment(tabFragment1,"Popular");
        adapter.addFragment(tabFragment2,"Category");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return myView;
    }
    private List<Book> loadBookData(){
        List<Book> list= new ArrayList<>();
        list.add(new Book(R.drawable.book11,"English"));
        list.add(new Book(R.drawable.book13,"Nhật ký của tôi"));
        list.add(new Book(R.drawable.book6,"Mỗi lần vấp ngã là một lần trưởng thành"));
        list.add(new Book(R.drawable.book12,"Thành phố phép màu"));
        list.add(new Book(R.drawable.toikhongthichonao,"Tôi không thích ồn ào"));
        list.add(new Book(R.drawable.tamlyhoc,"Tâm lí học"));
        return list;
    }
    private List<Book> loadBookData1(){
        List<Book> list= new ArrayList<>();
        list.add(new Book(R.drawable.book9_2,"Đắc nhân tâm"));
        list.add(new Book(R.drawable.book8,"Tài chính căn bản"));
        list.add(new Book(R.drawable.book4,"Hai đứa trẻ"));
        list.add(new Book(R.drawable.book10,"Think & Grow Rich"));
        list.add(new Book(R.drawable.caycamngot,"Cây cam ngọt của tôi"));
        list.add(new Book(R.drawable.book7,"Chí phèo"));
        list.add(new Book(R.drawable.book14,"Đóa hoa mùa xuân"));
        list.add(new Book(R.drawable.nenkinhtetudo,"Nền kinh tế tự do"));
        list.add(new Book(R.drawable.kiuctuoithanhxuan,"Kí ức tuổi thanh xuân"));
        list.add(new Book(R.drawable.tamlihocdamdong,"Tâm lý học đám đông"));
        list.add(new Book(R.drawable.book18,"Sự tích chú cuội"));
        list.add(new Book(R.drawable.tuoitredanggiabn,"Tuổi trẻ đáng giá bao nhiêu"));
        list.add(new Book(R.drawable.book6,"Mỗi lần vấp ngã là một lần trưởng thành"));
        return list;
    }
    private List<Book> loadBookData2(){
        List<Book> list= new ArrayList<>();
        list.add(new Book(R.drawable.book1,"Sách động lực"));
        list.add(new Book(R.drawable.book3,"Sách hư cấu"));
        list.add(new Book(R.drawable.book4,"Sách tiểu thuyết"));
        list.add(new Book(R.drawable.book11,"Sách tiếng anh"));
        list.add(new Book(R.drawable.book6,"Sách tự lực"));
        list.add(new Book(R.drawable.book7,"Sách văn học"));
        list.add(new Book(R.drawable.book14,"Sách truyện tranh"));
        list.add(new Book(R.drawable.book15,"Sách tham khảo"));
        list.add(new Book(R.drawable.book16,"Sách khoa học"));
        list.add(new Book(R.drawable.book17,"Sách giáo khoa"));
        list.add(new Book(R.drawable.book18,"Sách truyện cổ tích"));
        list.add(new Book(R.drawable.book19,"Sách lập trình"));
        return list;
    }
}

