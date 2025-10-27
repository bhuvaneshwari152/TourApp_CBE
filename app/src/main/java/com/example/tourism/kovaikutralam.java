package com.example.tourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class kovaikutralam extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button,rest,hotel;
    LinearLayoutManager manager;
    ArrayList<RecyclerViewModel> list = new ArrayList<>();
    RecyclerViewItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kovaikutralam);

        ///// RECYCLER VIEW :

        list.add(new RecyclerViewModel("", "", R.drawable.kovaikutralamfalls, 4.5f));
        list.add(new RecyclerViewModel("", "", R.drawable.kovaikutalam2, 4f));
        list.add(new RecyclerViewModel("", "", R.drawable.kovaikutalam3, 4.5f));
        list.add(new RecyclerViewModel("", "", R.drawable.kovaikutalam4, 3f));

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, list);
        manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        decoration = new RecyclerViewItemDecoration(16);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(decoration);


        // Initialize the button
        button = findViewById(R.id.button);
        rest = findViewById(R.id.button3);
        hotel = findViewById(R.id.button2);


        // Set OnClickListener to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent with the Google Maps link
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/N5Tv57SajSpiPDaE9"));
                // Start the intent
                startActivity(intent);
            }
        });


        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SearchResultsActivity
                Intent intent = new Intent(kovaikutralam.this, kkrest.class);
                startActivity(intent);
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SearchResultsActivity
                Intent intent = new Intent(kovaikutralam.this, kkhotel.class);
                startActivity(intent);
            }
        });

    }
}
