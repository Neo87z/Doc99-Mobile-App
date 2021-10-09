package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.InitialUserManagement.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LabRepots extends AppCompatActivity {


    Button b1;
    EditText t1, t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_repots);
        BottomNavigationView btnNav=findViewById(R.id.BottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListner);
        b1=findViewById(R.id.button22);
        t1=findViewById(R.id.editTextTextPersonName21);
        t2=findViewById(R.id.editTextTextPersonName22);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(t1.getText().toString().trim())){
                    t1.setError("Please Enter The Reference Code");
                    return;
                }else if(TextUtils.isEmpty((t2.getText().toString().trim()))){
                    t2.setError("Please Enter The Passcode");
                    return;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Lab Report Has Been Sent To The Registered Email", Toast.LENGTH_SHORT).show();
                }

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

}