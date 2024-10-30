package com.example.contentprovider;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.Manifest;

import java.util.ArrayList;
import java.util.List;

public class ReadMessages extends AppCompatActivity {
    private ListView listView;
    private ContentResolver resolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_read_messages);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView=findViewById(R.id.listview);
        if(checkSelfPermission(Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_SMS},100);
        }else{
            loadMessages();
        }
    }
    private void loadMessages(){
        resolver=getContentResolver();
        List<String> list=new ArrayList<>();
        Cursor cursor=resolver.query(
                Uri.parse("content://sms/"),
                new String[]{"address", "body"},null,null,null);
        if(cursor!=null){
            try {
                while(cursor.moveToNext()){
                    String address=cursor.getString(cursor.getColumnIndexOrThrow("address"));
                    String content=cursor.getString(cursor.getColumnIndexOrThrow("body"));
                    list.add("From: "+address+"\nMessage: "+content);
                }
            }finally {
                cursor.close();
            }
        }else{
            Toast.makeText(this,"No messages",Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadMessages();
            } else {
                Toast.makeText(this, "Quyền truy cập SMS bị từ chối", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}