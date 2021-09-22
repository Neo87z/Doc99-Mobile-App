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

public class ConfirmReset extends AppCompatActivity {

    Button Reset;
    String NIC;
    EditText NewPass,ConfirmPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_reset);
        Reset=findViewById(R.id.button14);
        NIC= getIntent().getStringExtra("NIC");
        NewPass=findViewById(R.id.editTextTextPersonName19);
        ConfirmPass=findViewById(R.id.editTextTextPersonName18);
        Toast.makeText(this,NIC, Toast.LENGTH_SHORT).show();
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CHeckFields();
            }
        });
    }

    public  void CHeckFields(){
        NewPass=findViewById(R.id.editTextTextPersonName19);
        ConfirmPass=findViewById(R.id.editTextTextPersonName18);
        if(TextUtils.isEmpty(NewPass.getText().toString())){
            NewPass.setError("Please Enter The New Password");

        }else if(TextUtils.isEmpty(ConfirmPass.getText().toString())){
            ConfirmPass.setError("Please Enter The New Password");
        }else if(!NewPass.getText().toString().trim().equals(ConfirmPass.getText().toString().trim())){
            ConfirmPass.setError("Confirm Password Does not Match the Password");
        }else{
            UpdatePassword();
        }
    }

    public  void UpdatePassword(){
        NewPass=findViewById(R.id.editTextTextPersonName19);



        DatabaseReference ReadRef= FirebaseDatabase.getInstance().getReference().child("User").child(NIC);
        ReadRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    try{
                        User NewUSer= new User();
                        NewUSer.setPassword(NewPass.getText().toString());
                        NewUSer.setCountry( dataSnapshot.child("country").getValue().toString());
                        NewUSer.setEmail( dataSnapshot.child("email").getValue().toString());
                        NewUSer.setFirstName( dataSnapshot.child("firstName").getValue().toString());
                        NewUSer.setLastName( dataSnapshot.child("lastName").getValue().toString());
                        NewUSer.setNIC( dataSnapshot.child("nic").getValue().toString());
                        NewUSer.setSex( dataSnapshot.child("sex").getValue().toString());
                        DatabaseReference updateref= FirebaseDatabase.getInstance().getReference().child("User").child(NIC);
                        updateref.setValue(NewUSer);
                    }catch (Exception e){

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Toast.makeText(this,"Invalid NIC Or Password", Toast.LENGTH_SHORT).show();
        ResetPPassword();

    }

    public void ResetPPassword(){
        Intent i1 = new Intent(this,MainActivity.class);
        startActivity(i1);
    }
}