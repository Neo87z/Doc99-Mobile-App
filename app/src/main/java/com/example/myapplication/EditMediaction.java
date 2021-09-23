package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EditMediaction extends AppCompatActivity {

    EditText RequesterName,ContactNumber,Address,Message;
    Button Save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mediaction);
        RequesterName=findViewById(R.id.editTextTextPersonName2);
        ContactNumber=findViewById(R.id.editTextTextPersonName3);
        Address=findViewById(R.id.editTextTextPersonName4);
        Message=findViewById(R.id.editTextTextMultiLine);
        Save=findViewById(R.id.button3);
        BottomNavigationView btnNav=findViewById(R.id.BottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListner);
        SetValues();
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveDetails();
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


    public  void SetValues(){
        RequesterName=findViewById(R.id.editTextTextPersonName2);
        ContactNumber=findViewById(R.id.editTextTextPersonName3);
        Address=findViewById(R.id.editTextTextPersonName4);
        Message=findViewById(R.id.editTextTextMultiLine);
        RequesterName.setText(getIntent().getStringExtra("RequesterName"));
        ContactNumber.setText(getIntent().getStringExtra("Number"));
        Address.setText(getIntent().getStringExtra("Address"));
        Message.setText(getIntent().getStringExtra("Message"));
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