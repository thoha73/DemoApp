package com.example.demolayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView textViewTen,textViewMasv,textViewUsername,textViewPassword;
        EditText edtUsername,edtPassword,edtConfirm;
        CheckBox checkBoxAccept;
        textViewTen = findViewById(R.id.textViewTen);
        textViewMasv = findViewById(R.id.textViewMasv);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        textViewUsername = findViewById(R.id.textViewUsername);
        textViewPassword=findViewById(R.id.textViewPassword);
        edtConfirm=findViewById(R.id.edtConfirm);
        Button btnSignup = findViewById(R.id.btnSignup);
        checkBoxAccept = findViewById(R.id.checkBoxAccept);
        btnSignup.setOnClickListener(view -> {
            // Xử lý sự kiện khi nút "Sign up" được nhấn
            if(edtConfirm.getText().toString().equals(edtPassword.getText().toString()) &&checkBoxAccept.isChecked()){
                textViewTen.setText("Họ và tên: Nguyễn Thọ Hà");
                textViewMasv.setText("Mã sinh viên: 22115053122314");
                textViewUsername.setText("Username: "+edtUsername.getText().toString());
                textViewPassword.setText("Password: "+edtPassword.getText().toString());
            }else{
                if(!checkBoxAccept.isChecked()){
                    AlertDialog.Builder myMessage = new AlertDialog.Builder(SignupActivity.this);
                    myMessage.setTitle("Thông báo");
                    myMessage.setMessage("Bạn chưa đồng ý với điều khoản sử dụng");
                    myMessage.setPositiveButton("OK", null);
                    myMessage.create().show();
                }else{
                    AlertDialog.Builder myerror = new AlertDialog.Builder(SignupActivity.this);
                    myerror.setTitle("Thông báo");
                    myerror.setMessage("Mật khẩu không trùng khớp");
                    myerror.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edtPassword.setText("");
                            edtConfirm.setText("");
                        }
                    });

                    myerror.create().show();
                }

            }

        });

    }
}