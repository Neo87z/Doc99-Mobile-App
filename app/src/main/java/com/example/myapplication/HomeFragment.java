package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.InitialUserManagement.MainActivity;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    ImageView Medicine;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        Medicine=(ImageView)v.findViewById(R.id.imageView16);
        Medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent= new Intent(getContext(),RequestMedication.class);
                startActivity(startIntent);
            }
        });

        return v;
    }
}