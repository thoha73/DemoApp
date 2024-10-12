package com.example.baitaptablayout.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.baitaptablayout.R;


public class ProfileFragment extends Fragment {
    private ImageView btn_back;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview= inflater.inflate(R.layout.fragment_profile, container, false);
        btn_back=myview.findViewById(R.id.imageView_back);
//        btn_back.setOnClickListener(v -> {
//            FragmentManager fragmentManager = getParentFragmentManager(); // Lấy FragmentManager
//            if (fragmentManager.getBackStackEntryCount() > 0) {
//                fragmentManager.popBackStack(); // Quay lại Fragment trước đó
//            } else {
//                // Nếu không còn Fragment nào trong back stack, bạn có thể làm điều gì đó khác (như đóng Activity nếu cần)
//                getActivity().onBackPressed(); // Ví dụ: gọi onBackPressed của Activity
//            }
//        });
        return myview;
    }
}