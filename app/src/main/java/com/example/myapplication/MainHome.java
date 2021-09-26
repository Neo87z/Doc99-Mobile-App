package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.InitialUserManagement.MainActivity;
import com.example.myapplication.SessionManagement.SessionMangement;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        BottomNavigationView btnNav=findViewById(R.id.BottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListner);
        SessionMangement s1= new SessionMangement(getApplicationContext());

        String Status= getIntent().getStringExtra("Status");
        if(Status == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,new HomeFragment()).commit();
        }else{
            if(Status.equals("Home")){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,new HomeFragment()).commit();
            }else if(Status.equals("Profile")){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,new ProfileFragment()).commit();
            }else if(Status.equals("Settings")){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,new SettingsFragment()).commit();
            }
        }
    }
    private  BottomNavigationView.OnNavigationItemSelectedListener navListner= new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment= null;
                    switch (item.getItemId()){
                        case R.id.item1:
                            selectedFragment=new HomeFragment();
                            break;
                        case  R.id.item2:
                            selectedFragment=new ProfileFragment();
                            break;
                        case R.id.item3:
                            selectedFragment=new SettingsFragment();

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,selectedFragment).commit();
                    return true;
                }
            };
}