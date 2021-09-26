package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CovidInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_information);

        BottomNavigationView btnNav=findViewById(R.id.BottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListner);
        String URL="https://hpb.health.gov.lk/covid19-dashboard/";
        WebView web=(WebView) findViewById(R.id.COvidInfo);
        WebSettings webSettings= web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.loadUrl(URL);

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