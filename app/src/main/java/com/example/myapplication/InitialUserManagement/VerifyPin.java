package com.example.myapplication.InitialUserManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class VerifyPin extends AppCompatActivity {

    Button VerifyPIN;
    String NIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_pin);
        VerifyPIN= findViewById(R.id.button13);
        NIC= getIntent().getStringExtra("NIC");
        VerifyPIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetPassowrd();
            }
        });
    }
    public void ResetPassowrd(){
        Intent i1 = new Intent(this,ConfirmReset.class);
        i1.putExtra("NIC", NIC);
        startActivity(i1);
    }
}