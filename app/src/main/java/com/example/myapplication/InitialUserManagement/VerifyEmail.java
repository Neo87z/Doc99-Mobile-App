package com.example.myapplication.InitialUserManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class VerifyEmail extends AppCompatActivity {

    Button NextReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email);
        NextReg=findViewById(R.id.button);
        NextReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProceedToNextStep();
            }
        });
    }
    public void ProceedToNextStep(){
        Intent i1= new Intent(this,PersonalInfo.class);
        startActivity(i1);

    }
}