package com.example.myapplication.InitialUserManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class VerifyEmail extends AppCompatActivity {

    Button NextReg;
    String Country,Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email);
        NextReg=findViewById(R.id.button);
        Country= getIntent().getStringExtra("Country");
        Email= getIntent().getStringExtra("Email");
        NextReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProceedToNextStep();
            }
        });
    }
    public void ProceedToNextStep(){

        Intent i1= new Intent(this,PersonalInfo.class);
        i1.putExtra("Country", Country);
        i1.putExtra("Email", Email);
        startActivity(i1);
    }
}