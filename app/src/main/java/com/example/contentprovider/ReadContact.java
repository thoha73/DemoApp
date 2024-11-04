package com.example.contentprovider;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.Manifest;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ReadContact extends AppCompatActivity {
    private ListView listView;
    private ContentResolver resolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_read_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView=findViewById(R.id.listview);
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},100);

        }else{
            loadContact();
        }

    }
    private void loadContact(){
        ArrayList list= new ArrayList();
        resolver=getContentResolver();
        Cursor cursor= resolver.query(ContactsContract.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.Contacts._ID},null,null,null);
        if(cursor!=null){
            try {
                while(cursor.moveToNext()){
                    int idIndex=cursor.getColumnIndex(ContactsContract.Contacts._ID);
                    int nameIndex=cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                    String id=idIndex!=-1? cursor.getString(idIndex):"0";
                    String name=nameIndex!=-1? cursor.getString(nameIndex):"No name";
                    list.add("Phone: "+id+"\n"+"Name: "+name);
                }
            }finally {
                cursor.close();
            }

        }else{
            Toast.makeText(this,"No contact",Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }

}