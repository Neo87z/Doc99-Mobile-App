package com.example.myapplication.InitialUserManagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Loginactiviyu extends AppCompatActivity {

    Button Proceed;
    EditText Country,PhoneEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactiviyu);
        Country=findViewById(R.id.editTextTextPersonName);
        PhoneEmail=findViewById(R.id.editTextTextPassword);
        Proceed=findViewById(R.id.Proceed);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProccedToVerifyEmail(view);
            }
        });
    }
    public void ProccedToVerifyEmail(View view){
        try{
            Country=findViewById(R.id.editTextTextPersonName);
            PhoneEmail=findViewById(R.id.editTextTextPassword);

            if(TextUtils.isEmpty(Country.getText().toString())){
                Country.setError("Please Input The Country Name");
            }else if(TextUtils.isEmpty(PhoneEmail.getText().toString())){
                PhoneEmail.setError("Please Input The Email Address");

            }else{
                String Country1=Country.getText().toString().trim();
                String Email=PhoneEmail.getText().toString().trim();
                Intent startIntent= new Intent(Loginactiviyu.this,VerifyEmail.class);
                startIntent.putExtra("Country", Country1);
                startIntent.putExtra("Email", Email);
                startActivity(startIntent);

            }

        }catch (Exception e){
            String Error = e.toString();
            Toast.makeText(this,Error, Toast.LENGTH_SHORT).show();
        }

    }
}