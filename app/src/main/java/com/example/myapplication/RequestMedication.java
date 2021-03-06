package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.InitialUserManagement.Loginactiviyu;
import com.example.myapplication.InitialUserManagement.VerifyEmail;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RequestMedication extends AppCompatActivity {



    EditText RequesterName,ContactNumber,Address,Message;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_medication);
        RequesterName=findViewById(R.id.editTextTextPersonName2);
        ContactNumber=findViewById(R.id.editTextTextPersonName3);
        Address=findViewById(R.id.editTextTextPersonName4);
        Message=findViewById(R.id.editTextTextMultiLine);
        Save=findViewById(R.id.button3);
        BottomNavigationView btnNav=findViewById(R.id.BottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListner);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckFeilds();
            }
        });
    }
    private  BottomNavigationView.OnNavigationItemSelectedListener navListner= new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.item1:
                            Intent startIntent= new Intent(getApplicationContext(),MainHome.class);
                            startIntent.putExtra("Status", "Home");
                            startActivity(startIntent);
                            break;
                        case  R.id.item2:
                            Intent startIntent2= new Intent(getApplicationContext(),MainHome.class);
                            startIntent2.putExtra("Status", "Profile");
                            startActivity(startIntent2);
                            break;
                        case R.id.item3:
                            Intent startIntent3= new Intent(getApplicationContext(),MainHome.class);
                            startIntent3.putExtra("Status", "Settings");
                            startActivity(startIntent3);
                    }
                    return true;
                }
            };

    public void CheckFeilds(){
        RequesterName=findViewById(R.id.editTextTextPersonName2);
        ContactNumber=findViewById(R.id.editTextTextPersonName3);
        Address=findViewById(R.id.editTextTextPersonName4);
        Message=findViewById(R.id.editTextTextMultiLine);

        if(TextUtils.isEmpty(RequesterName.getText().toString())){
            RequesterName.setError("Please Input The Requster's Name");
        }else if(TextUtils.isEmpty(ContactNumber.getText().toString())){
            ContactNumber.setError("Please Input Contact Number");
        }else if(TextUtils.isEmpty(Address.getText().toString())){
            Address.setError("Please Input Address");
        }else if(TextUtils.isEmpty(Message.getText().toString())){
            Message.setError("Please Input Message");
        }else{
            SaveDetails();
        }
    }

    public void SaveDetails(){
        RequesterName=findViewById(R.id.editTextTextPersonName2);
        ContactNumber=findViewById(R.id.editTextTextPersonName3);
        Address=findViewById(R.id.editTextTextPersonName4);
        Message=findViewById(R.id.editTextTextMultiLine);
        Intent startIntent= new Intent(getApplicationContext(), ReviewMedication.class);
        startIntent.putExtra("RequesterName", RequesterName.getText().toString());
        startIntent.putExtra("Number", ContactNumber.getText().toString());
        startIntent.putExtra("Address", Address.getText().toString());
        startIntent.putExtra("Message", Message.getText().toString());
        startActivity(startIntent);

    }
}