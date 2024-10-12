package com.example.baitaptablayout.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.baitaptablayout.R;
import com.example.baitaptablayout.adapter.BookAdapter;
import com.example.baitaptablayout.model.Book;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private BookAdapter bookAdapter;
    int image[]={R.drawable.book11,R.drawable.book13,R.drawable.book6,R.drawable.book12};
    String nameBook[]={"English","Nhật ký của tôi","Mỗi lần vấp ngã là một lần trưởng thành","Thành phố phép màu"};
    String author[] ={"Jason","Nguyễn Nhật Ánh","Trần Văn An","Đặng Khánh Vân"};
    double price[]={150000,500000,999999,8888888};
    String description[]={"Xin chào","Xin chào","Xin chào","Xin chào"};
    String ISBN[]={"12312312","123124151","151251251","124125412"};

    int image1[]={R.drawable.book9,R.drawable.book7,R.drawable.book8,R.drawable.book10};
    String nameBook1[]={"Đắc nhân tâm","Chí phèo","Tài chính","Think & grow rich"};
    String author1[] ={"Bill Gate","Thị Nở","Phạm Nhật Vượng","Đặng Khánh Vân"};
    double price1[]={150000,500000,999999,8888888};
    String description1[]={"Xin chào","Xin chào","Xin chào","Xin chào"};
    String ISBN1[]={"12312312","123124151","151251251","124125412"};
    int image2[]={R.drawable.book1,R.drawable.book3,R.drawable.book4,R.drawable.book5};
    String nameBook2[]={"Sách động lực","Sách hư cấu","Sách tiểu thuyết","Sách kinh tế"};
    String author2[] ={"Jackma","Võ Nghịch Tiên","Lý Mộ Uyển","Elon Musk"};
    double price2[]={111000,1000000,676767,12315488};
    String description2[]={"Hello ","Hello","Method...","Hello"};
    String ISBN2[]={"345634643","5236346","1523562352","57345435"};
    RecyclerView recyclerView1,recyclerView2,recyclerView3;
    TextView tv_new,tv_popular,tv_category;
    ArrayList<Book> listBook,listBook1,listBook2;
    BookAdapter myAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        tv_new=view.findViewById(R.id.tv_showallNew);
        tv_popular=view.findViewById(R.id.tv_showallPopular);
        tv_category=view.findViewById(R.id.tv_showallCategory);
        recyclerView1=view.findViewById(R.id.recyclerView1);
        recyclerView2=view.findViewById(R.id.recyclerView2);
        recyclerView3=view.findViewById(R.id.recyclerView3);
        initGridView(listBook,image,nameBook,author,price,description,ISBN,recyclerView1);
        initGridView(listBook1,image1,nameBook1,author1,price1,description1,ISBN1,recyclerView2);
        initGridView(listBook2,image2,nameBook2,author2,price2,description2,ISBN2,recyclerView3);
        return view;
    }
    private void initGridView(List<Book> list, int img[], String nameBook[], String author[], double price[], String description[], String ISBN[], RecyclerView rcv){
        rcv.setPadding(10,10,10,20);
        list=new ArrayList<>();
        for(int i=0;i<img.length;i++){
            list.add(new Book(img[i],nameBook[i],author[i],price[i],description[i],ISBN[i]));
        }
//        rcv.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false));
        rcv.setLayoutManager(new LinearLayoutManager(getContext(),  LinearLayoutManager.HORIZONTAL, false));
        bookAdapter = new BookAdapter(getActivity());
        bookAdapter.setData(list);
        rcv.setAdapter(bookAdapter);

    }
}