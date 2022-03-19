package com.example.servicesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class clientLandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_landing_page);
        final DrawerLayout drawerLayout=findViewById(R.id.drawerLayout);
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView=findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this,R.id.NavHostFragment);
        NavigationUI.setupWithNavController(navigationView,navController);
    }
}