package com.example.myapplication.InitialUserManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class ConfirmReset extends AppCompatActivity {

    Button Reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_reset);
        Reset=findViewById(R.id.button14);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetPPassword();
            }
        });
    }

    public void ResetPPassword(){
        Intent i1 = new Intent(this,MainActivity.class);
        startActivity(i1);
    }
}