package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.InitialUserManagement.Loginactiviyu;
import com.example.myapplication.InitialUserManagement.MainActivity;
import com.example.myapplication.InitialUserManagement.VerifyPin;
import com.example.myapplication.Models.User;
import com.example.myapplication.SessionManagement.SessionMangement;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdatePorfile extends AppCompatActivity {

    EditText Fname,Lname,Country,Email;
    Button SaveChanges,DeleteAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_porfile);
        Fname=findViewById(R.id.editTextTextPersonName5);
        Lname=findViewById(R.id.editTextTextPersonName6);
        Country=findViewById(R.id.editTextTextPersonName8);
        Email=findViewById(R.id.editTextTextPersonName7);
        SaveChanges=findViewById(R.id.button6);
        DeleteAccount=findViewById(R.id.button5);
        DeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionMangement s1= new SessionMangement(getApplicationContext());
                DatabaseReference ReadRef= FirebaseDatabase.getInstance().getReference().child("User").child(s1.GetUserID());
                ReadRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            try{
                                dataSnapshot.getRef().removeValue();
                                Toast.makeText(getApplicationContext(),"User Deleted", Toast.LENGTH_SHORT).show();
                                Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i1);
                            }catch (Exception e){
                                Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        GetUserDetails();
        SaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveAccountDetails();
            }
        });
    }

    public void SaveAccountDetails(){
        Fname=findViewById(R.id.editTextTextPersonName5);
        Lname=findViewById(R.id.editTextTextPersonName6);
        Country=findViewById(R.id.editTextTextPersonName8);
        Email=findViewById(R.id.editTextTextPersonName7);
        SessionMangement s1= new SessionMangement(getApplicationContext());
        DatabaseReference ReadRef= FirebaseDatabase.getInstance().getReference().child("User").child(s1.GetUserID());
        ReadRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    try{
                        User NewUSer= new User();
                        NewUSer.setPassword(dataSnapshot.child("password").getValue().toString());
                        NewUSer.setNIC( dataSnapshot.child("nic").getValue().toString());
                        NewUSer.setSex( dataSnapshot.child("sex").getValue().toString());
                        NewUSer.setCountry( Country.getText().toString());
                        NewUSer.setEmail(  Email.getText().toString());
                        NewUSer.setFirstName( Fname.getText().toString());
                        NewUSer.setLastName( Lname.getText().toString());
                        DatabaseReference updateref= FirebaseDatabase.getInstance().getReference().child("User").child(s1.GetUserID());
                        updateref.setValue(NewUSer);
                        Toast.makeText(getApplicationContext(),"User Data Changed", Toast.LENGTH_SHORT).show();
                        Intent i1 = new Intent(getApplicationContext(), MainHome.class);

                        startActivity(i1);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public  void GetUserDetails(){
        SessionMangement s1= new SessionMangement(getApplicationContext());
        DatabaseReference readRef= FirebaseDatabase.getInstance().getReference().child("User").child(s1.GetUserID());
        try{
            readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChildren()){
                        Fname.setText(dataSnapshot.child("firstName").getValue().toString());
                        Lname.setText(dataSnapshot.child("lastName").getValue().toString());
                        Country.setText(dataSnapshot.child("country").getValue().toString());
                        Email.setText(dataSnapshot.child("email").getValue().toString());
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}