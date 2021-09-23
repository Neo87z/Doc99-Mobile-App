package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.InitialUserManagement.Loginactiviyu;
import com.example.myapplication.InitialUserManagement.MainActivity;
import com.example.myapplication.InitialUserManagement.VerifyEmail;
import com.example.myapplication.SessionManagement.SessionMangement;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }
    TextView ProfileName,Email,Country,Sex;
    Button UpdateButton;
    private FragmentActivity myContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        SessionMangement s1= new SessionMangement(getContext());
        ProfileName= v.findViewById(R.id.textView33);
        Email= v.findViewById(R.id.textView34);
        Country= v.findViewById(R.id.textView35);
        Sex= v.findViewById(R.id.textView36);
        UpdateButton=v.findViewById(R.id.button15);
        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent startIntent= new Intent(getContext(), UpdatePorfile.class);
                startActivity(startIntent);
            }
        });
        DatabaseReference readRef= FirebaseDatabase.getInstance().getReference().child("User").child(s1.GetUserID());
        try{
            readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChildren()){
                        ProfileName.setText(dataSnapshot.child("firstName").getValue().toString()+" "+dataSnapshot.child("lastName").getValue().toString() );
                        Email.setText(dataSnapshot.child("email").getValue().toString());
                        Country.setText(dataSnapshot.child("country").getValue().toString());
                        Sex.setText(dataSnapshot.child("sex").getValue().toString());
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }catch (Exception e){
            Toast.makeText(getContext(),e.toString(), Toast.LENGTH_SHORT).show();
        }
        return v;
    }
}