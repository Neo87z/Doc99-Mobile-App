package com.example.myapplication.InitialUserManagement;

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
        EmailPhone=findViewById(R.id.editTextTextPersonName13);
        if(TextUtils.isEmpty(EmailPhone.getText().toString())){
            Toast.makeText(this,"Please Input Email Or Phone Number", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(Password.getText().toString())){
            Toast.makeText(this,"Please Input Password", Toast.LENGTH_SHORT).show();
        }
    }

    public void ForGotPassword(){
        Intent i1 = new Intent(this,ResetPassword.class);
        startActivity(i1);
    }
}