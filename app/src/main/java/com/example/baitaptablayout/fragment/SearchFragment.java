package com.example.baitaptablayout.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.baitaptablayout.R;
import com.example.baitaptablayout.adapter.NotificationUserAdapter;
import com.example.baitaptablayout.model.Notification;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class SearchFragment extends Fragment {
    private ListView listView;
    private TextView textView_title;
    private TextView textView_time;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview= inflater.inflate(R.layout.fragment_search, container, false);
        textView_title=myview.findViewById(R.id.textView_titleNotification);
        textView_time=myview.findViewById(R.id.textView_time);
        listView=myview.findViewById(R.id.listView_Notification);
        List<Notification> list=new ArrayList<>();
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat df= new SimpleDateFormat("dd 'thg' MM", new Locale("vi","VN"));

        list.add(new Notification("Giảm giá đến 15% cho ngày 11/11",df.format(calendar.getTime()),false));
        list.add(new Notification("Giảm giá đến 10% cho ngày 12/11",df.format(calendar.getTime()),false));
        NotificationUserAdapter adapter=new NotificationUserAdapter(getContext(),R.layout.layout_item_notification,list);
        listView.setAdapter(adapter);
        return myview;
    }
}