package com.example.demolayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        TextView textViewSignup,textViewPass,textUsername,textPassword;
        Button btnLogin;
        textViewSignup = findViewById(R.id.text_signup);
        textViewPass=findViewById(R.id.textPass);
        btnLogin=findViewById(R.id.btnLogin);
        textUsername=findViewById(R.id.text_username);
        textPassword=findViewById(R.id.text_password);
        textViewSignup.setPaintFlags(textViewSignup.getPaintFlags() | android.graphics.Paint.UNDERLINE_TEXT_FLAG);
        textViewPass.setPaintFlags(textViewPass.getPaintFlags() | android.graphics.Paint.UNDERLINE_TEXT_FLAG);
        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(myIntent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message="Họ và tên: Nguyễn Thọ Hà\n"+"Mã sinh viên: 22115053122314\n"+"Username: "+textUsername.getText().toString()+"\n"
                                +"Password: "+textPassword.getText().toString();
                AlertDialog.Builder mydialogin = new AlertDialog.Builder(MainActivity.this);
                mydialogin.setTitle("Thông tin đăng nhập");
                mydialogin.setMessage(message);
                mydialogin.setPositiveButton("Exit",null);
                mydialogin.create().show();
            }
        });
    }
}