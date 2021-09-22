package com.example.myapplication.InitialUserManagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {



    EditText EmailPhone,Password;
    Button LoginButton;
    TextView SignUptext,ForGotPaassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        SignUptext=findViewById(R.id.textView30);
        EmailPhone=findViewById(R.id.editTextTextPersonName13);
        Password=findViewById(R.id.editTextTextPersonName14);
        LoginButton=findViewById(R.id.button11);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartLoginProcess();
            }
        });
        SignUptext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Test();

            }
        });
        ForGotPaassword= findViewById(R.id.textView29);
        ForGotPaassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForGotPassword();
            }
        });
    }
    public void Test(){
        Intent startIntent= new Intent(this,Loginactiviyu.class);
        startActivity(startIntent);

    }

    public void StartLoginProcess(){
        Password=findViewById(R.id.editTextTextPersonName14);

        if(TextUtils.isEmpty(EmailPhone.getText().toString())){
            EmailPhone.setError("Please Input Email");
        }else if (TextUtils.isEmpty(Password.getText().toString())){
            Password.setError("Please Input Email");
        }else{
            CheckLoginDetails();
        }
    }

    public void CheckLoginDetails(){

        final DatabaseReference readRef= FirebaseDatabase.getInstance().getReference().child("User").child(EmailPhone.getText().toString());
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    String Pass=dataSnapshot.child("password").getValue().toString();
                    if(Pass.equals(Password.getText().toString())){
                        Toast.makeText(MainActivity.this,"Pass", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Invalid NIC Or Password", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this,"Invalid NIC Or Password", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void ForGotPassword(){
        Intent i1 = new Intent(this,ResetPassword.class);
        startActivity(i1);
    }
}