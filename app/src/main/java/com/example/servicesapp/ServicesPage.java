package com.example.servicesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ServicesPage extends AppCompatActivity {
    String[] names = {"burner","burner clean","regulator","tube"};
    int[] images = {R.drawable.burner,R.drawable.burnerclean,R.drawable.regulator,R.drawable.tube};
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_page);

        imageView = findViewById(R.id.serviceburner);
        textView = findViewById(R.id.itemtext);

        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        imageView.setImageResource(images[position]);
        textView.setText(names[position]);
    }
}