package com.example.contentprovider;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
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

public class ReadCallLog extends AppCompatActivity {
    private ListView listView;
    private ContentResolver resolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_read_call_log);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listview);
        if(checkSelfPermission(Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_CALL_LOG},100);
        }else{
            loadCallLog();

        };

    }
    private void loadCallLog(){
        ArrayList list=new ArrayList();
        resolver=getContentResolver();
        Cursor cursor=resolver.query(CallLog.Calls.CONTENT_URI,null,null,null,null);
        if(cursor!=null){
            try {
                while (cursor.moveToNext()){
                    int numberIndex = cursor.getColumnIndex(CallLog.Calls.NUMBER);
                    int typeIndex = cursor.getColumnIndex(CallLog.Calls.TYPE);
                    int dateIndex = cursor.getColumnIndex(CallLog.Calls.DATE);
                    int durationIndex = cursor.getColumnIndex(CallLog.Calls.DURATION);

                    String number = numberIndex != -1 ? cursor.getString(numberIndex) : "0";
                    String type = typeIndex != -1 ? cursor.getString(typeIndex) : "Nhatki";
                    String date = dateIndex != -1 ? cursor.getString(dateIndex) : "0/0/0";
                    String duration = durationIndex != -1 ? cursor.getString(durationIndex) : "0";

                    // Tạo một chuỗi hiển thị thông tin cuộc gọi và thêm vào danh sách
                    String callDetails = "Number: " + number + ", Type: " + type + ", Date: " + date + ", Duration: " + duration;
                    list.add(callDetails);
                }
            }finally {
                cursor.close();
            }
        }else{
            Toast.makeText(this, "No call log", Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100){
            if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                loadCallLog();
            }else{
                Toast.makeText(this,"Quyền truy cập cuộc gọi bị từ chối",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}