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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResetPassword extends AppCompatActivity {

    Button VerifyPIN;
    EditText Email,NIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        VerifyPIN=findViewById(R.id.button12);
        Email=findViewById(R.id.editTextTextPersonName15);
        NIC=findViewById(R.id.editTextTextPersonName16);
        VerifyPIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckFields();
            }
        });
    }

    public void CheckFields(){
        Email=findViewById(R.id.editTextTextPersonName15);
        NIC=findViewById(R.id.editTextTextPersonName16);
        if(TextUtils.isEmpty(Email.getText())){
            Email.setError("Please Enter Valid Email Address");
        }else if(TextUtils.isEmpty(NIC.getText().toString())){
            NIC.setError("Please Enter NIC");
        }else{
            CheckValidity();
        }
    }

    public  void CheckValidity(){
        try{
            final DatabaseReference readRef= FirebaseDatabase.getInstance().getReference().child("User").child(NIC.getText().toString());
            readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChildren()){
                        String Emailx=dataSnapshot.child("email").getValue().toString();
                        if(Emailx.equals(Email.getText().toString())){
                            VerifyEmail();
                        }else{
                            Toast.makeText(ResetPassword.this,"Password And NIC Combination Does Not Match", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(ResetPassword.this,"Password And NIC Combination Does Not Match", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }catch (Exception e){
            String Error=e.toString();
            Toast.makeText(this,Error, Toast.LENGTH_SHORT).show();
        }

    }

    public  void VerifyEmail(){
        Intent i1 = new Intent(this, VerifyPin.class);
        NIC=findViewById(R.id.editTextTextPersonName16);
        i1.putExtra("NIC", NIC.getText().toString());
        startActivity(i1);
    }
}