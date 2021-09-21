package com.example.myapplication.InitialUserManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class Loginactiviyu extends AppCompatActivity {

    Button Proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactiviyu);
        Proceed=findViewById(R.id.Proceed);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProccedToVerifyEmail();
            }
        });
    }
    public void ProccedToVerifyEmail(){
        Intent startIntent= new Intent(this,VerifyEmail.class);
        startActivity(startIntent);
    }
}