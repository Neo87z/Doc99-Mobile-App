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

import com.example.myapplication.Models.User;
import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PersonalInfo extends AppCompatActivity {

    User NewUser;
    Button Register;
    EditText FirstName,LastName,Password,ConfirmPassword,Nic;
    String Country,Email;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        FirstName=findViewById(R.id.editTextTextPersonName9);
        LastName=findViewById(R.id.editTextTextPersonName10);
        Password=findViewById(R.id.editTextTextPersonName11);
        ConfirmPassword=findViewById(R.id.editTextTextPersonName12);
        Nic=findViewById(R.id.editTextTextPersonName20);
        Country= getIntent().getStringExtra("Country");
        Email= getIntent().getStringExtra("Email");
        Register=findViewById(R.id.button10);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckTextFiels();
            }
        });
    }

    public void RegisterUser(){
        Intent i1= new Intent(this, MainActivity.class);
        startActivity(i1);
        finish();

    }
    public void CheckTextFiels(){
        FirstName=findViewById(R.id.editTextTextPersonName9);
        LastName=findViewById(R.id.editTextTextPersonName10);
        Password=findViewById(R.id.editTextTextPersonName11);
        ConfirmPassword=findViewById(R.id.editTextTextPersonName12);
        Nic=findViewById(R.id.editTextTextPersonName20);
        if(TextUtils.isEmpty(FirstName.getText().toString())){
            FirstName.setError("First Name Cannot Be Empty");
        }else if (TextUtils.isEmpty(LastName.getText().toString())){
            LastName.setError("Last Name Cannot Be Empty");

        }else if (TextUtils.isEmpty(Password.getText().toString())){
            Password.setError("Password Cannot Be Empty");

        }else if (TextUtils.isEmpty(ConfirmPassword.getText().toString())){
            ConfirmPassword.setError("Confirm Password Cannot Be Empty");

        }else if (TextUtils.isEmpty(Nic.getText().toString())){
            Nic.setError("NIC Cannot Be Empty");
        }else if (!ConfirmPassword.getText().toString().equals(Password.getText().toString())) {
            ConfirmPassword.setError("Confirm Password Does Not Match The Password");
        }else{
            try{
                dbref= FirebaseDatabase.getInstance().getReference().child("User");
                NewUser= new User();
                NewUser.setCountry(Country);
                NewUser.setEmail(Email);
                NewUser.setFirstName(FirstName.getText().toString().trim());
                NewUser.setLastName(LastName.getText().toString().trim());
                NewUser.setPassword(Password.getText().toString().trim());
                NewUser.setNIC(Nic.getText().toString().trim());
                NewUser.setSex("Male");
                DatabaseReference Readref= FirebaseDatabase.getInstance().getReference().child("User").child(NewUser.getNIC());
                Readref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            Toast.makeText(PersonalInfo.this,"NIC Already Exits In THe Database", Toast.LENGTH_SHORT).show();
                            Nic.setError("NIC Already Registered With Us");
                        }else{
                            dbref.child(NewUser.getNIC()).setValue(NewUser);
                            Toast.makeText(PersonalInfo.this,"User Created", Toast.LENGTH_SHORT).show();
                            RegisterUser();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });



            }catch (Exception e){
                String Error =e.toString();
                Toast.makeText(this,Error, Toast.LENGTH_SHORT).show();

            }


        }


    }
}