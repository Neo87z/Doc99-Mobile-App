package com.example.myapplication.InitialUserManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    Button LoginButton;
    TextView SignUptext,ForGotPaassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        SignUptext=findViewById(R.id.textView30);
        LoginButton=findViewById(R.id.button11);
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

    public void ForGotPassword(){
        Intent i1 = new Intent(this,ResetPassword.class);
        startActivity(i1);
    }
}