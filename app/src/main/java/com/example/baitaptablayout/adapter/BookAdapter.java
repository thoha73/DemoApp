//package com.example.baitaptablayout.adapter;
//
//import android.app.Activity;
//import android.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.example.baitaptablayout.R;
//import com.example.baitaptablayout.model.Book;
//
//import java.util.ArrayList;
//
//public class BookAdapter extends ArrayAdapter<Book> {
//    Activity context;
//    Fragment context1;
//    int idLayout;
//    ArrayList<Book> listBook;
//    public BookAdapter(Activity context, int idLayout, ArrayList<Book> listBook) {
//        super(context, idLayout, listBook);
//        this.context = context;
//        this.idLayout = idLayout;
//        this.listBook = listBook;
//    }
////    public BookAdapter(Fragment context1, int idLayout, ArrayList<Book> listBook) {
////        super(context1, idLayout, listBook);
////        this.context1 = context1;
////        this.idLayout = idLayout;
////        this.listBook = listBook;
////    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater myflater= context.getLayoutInflater();
//        convertView = myflater.inflate(idLayout, null);
////        int width=parent.getWidth()/3;
////        convertView.setLayoutParams(new GridView.LayoutParams(width,GridView.AUTO_FIT));
//        Book book = listBook.get(position);
//        ImageView imageView=convertView.findViewById(R.id.imageView);
//        imageView.setImageResource(book.getImage());
//        TextView textView=convertView.findViewById(R.id.textView);
//        textView.setText(book.getBookName());
//        return convertView;
//    }
//}

package com.example.baitaptablayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaptablayout.R;
import com.example.baitaptablayout.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private Context myContext;
    private List<Book> listBook;
    public BookAdapter(Context myContext) {
        this.myContext = myContext;
    }
    public void setData(List<Book> list){
        this.listBook=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_carditem_book,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book=listBook.get(position);
        if(book==null){
            return;
        }
        holder.imageView.setImageResource(book.getImage());
        holder.textViewName.setText(book.getBookName());
    }

    @Override
    public int getItemCount() {
        if(listBook!=null){
            return listBook.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewName;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_book);
            textViewName = itemView.findViewById(R.id.tv_bookName);
        }
    }
}

