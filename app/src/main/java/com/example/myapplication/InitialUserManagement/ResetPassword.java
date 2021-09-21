package com.example.myapplication.InitialUserManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class ResetPassword extends AppCompatActivity {

    Button VerifyPIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        VerifyPIN=findViewById(R.id.button12);
        VerifyPIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerifyEmail();
            }
        });
    }

    public  void VerifyEmail(){
        Intent i1 = new Intent(this, VerifyPin.class);
        startActivity(i1);
    }
}