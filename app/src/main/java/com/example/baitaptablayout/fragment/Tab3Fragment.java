package com.example.baitaptablayout.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaptablayout.R;
import com.example.baitaptablayout.adapter.BookAdapter;
import com.example.baitaptablayout.model.Book;

import java.util.List;

public class Tab3Fragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Book> list;
    private BookAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view= inflater.inflate(R.layout.fragment_tab2,container,false);
        recyclerView=view.findViewById(R.id.rcv_bookItem);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        adapter= new BookAdapter(getContext());
        if(getArguments()!=null){
            list=getArguments().getParcelableArrayList("data2");
            if(list!=null){
                adapter.setData(list);

            }
        }
        recyclerView.setAdapter(adapter);
        return view;
    }
}
