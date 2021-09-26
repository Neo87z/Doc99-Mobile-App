package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.InitialUserManagement.MainActivity;
import com.example.myapplication.Models.Medication;
import com.example.myapplication.SessionManagement.SessionMangement;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReviewMedication extends AppCompatActivity {

    TextView RquesterName,ContactNumber,Address,Prescription,Message;
    Button Save, Edit, Discard;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_medication);
        RquesterName=findViewById(R.id.editTextTextPersonName2);
        ContactNumber=findViewById(R.id.editTextTextPersonName3);
        Address=findViewById(R.id.editTextTextPersonName4);
        Prescription=findViewById(R.id.textView42);
        Message=findViewById(R.id.editTextTextMultiLine);
        Save=findViewById(R.id.button18);
        Edit=findViewById(R.id.button17);
        Discard=findViewById(R.id.button16);
        BottomNavigationView btnNav=findViewById(R.id.BottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListner);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditData();
            }
        });
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveData();
            }
        });
        Discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Request Discarded", Toast.LENGTH_SHORT).show();
                Intent startIntent= new Intent(getApplicationContext(), MainHome.class);
                startActivity(startIntent);
            }
        });

        SetValues();
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

    public void EditData(){
        Intent startIntent= new Intent(getApplicationContext(), EditMediaction.class);
        startIntent.putExtra("RequesterName", RquesterName.getText().toString());
        startIntent.putExtra("Number", ContactNumber.getText().toString());
        startIntent.putExtra("Address", Address.getText().toString());
        startIntent.putExtra("Message", Message.getText().toString());
        startActivity(startIntent);
    }
    public void SaveData(){
        try{
            RquesterName=findViewById(R.id.editTextTextPersonName2);
            ContactNumber=findViewById(R.id.editTextTextPersonName3);
            Address=findViewById(R.id.editTextTextPersonName4);
            Prescription=findViewById(R.id.textView42);
            Message=findViewById(R.id.editTextTextMultiLine);
            dbref= FirebaseDatabase.getInstance().getReference().child("Medication");
            Medication Med= new Medication();
            SessionMangement s1= new SessionMangement(getApplicationContext());
            Med.setAddress(Address.getText().toString());
            Med.setContactNumber(ContactNumber.getText().toString());
            Med.setMesSage(Message.getText().toString());
            Med.setPrescription(Prescription.getText().toString());
            Med.setRequesterName(RquesterName.getText().toString());
            Med.setStatus("Pending");
            Med.setUSerID(s1.GetUserID());
            dbref.child(s1.GetUserID()).setValue(Med);
            Toast.makeText(getApplicationContext(),"Request Submited Sucessfully", Toast.LENGTH_SHORT).show();
            Intent startIntent= new Intent(getApplicationContext(), MainHome.class);
            startActivity(startIntent);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    public  void SetValues(){
        RquesterName=findViewById(R.id.editTextTextPersonName2);
        ContactNumber=findViewById(R.id.editTextTextPersonName3);
        Address=findViewById(R.id.editTextTextPersonName4);
        Prescription=findViewById(R.id.textView42);
        Message=findViewById(R.id.editTextTextMultiLine);
        RquesterName.setText(getIntent().getStringExtra("RequesterName"));
        ContactNumber.setText(getIntent().getStringExtra("Number"));
        Address.setText(getIntent().getStringExtra("Address"));
        Prescription.setText("Prescription.jpg");
        Message.setText(getIntent().getStringExtra("Message"));
    }
}