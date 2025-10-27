package com.example.tourism;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Siruvani extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button buttonMap, buttonRest, buttonHotel;
    private LinearLayoutManager layoutManager;
    private ArrayList<RecyclerViewModel> list = new ArrayList<>();
    private RecyclerViewItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siruvani);

        // Initialize RecyclerView data
        list.add(new RecyclerViewModel("", "", R.drawable.siruvani, 4.5f));
        list.add(new RecyclerViewModel("", "", R.drawable.siruvani2, 4f));
        list.add(new RecyclerViewModel("", "", R.drawable.siruvani3, 4.5f));
        list.add(new RecyclerViewModel("", "", R.drawable.siruvani4, 3f));

        // Setup RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, list);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        decoration = new RecyclerViewItemDecoration(16);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);

        // Initialize buttons
        buttonMap = findViewById(R.id.button);
        buttonRest = findViewById(R.id.button3);
        buttonHotel = findViewById(R.id.button2);

        // Set OnClickListeners
        buttonMap.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                    "https://maps.app.goo.gl/BgL6fQmBCm5WcoAZ7"
            ));
            startActivity(intent);
        });

        buttonRest.setOnClickListener(v -> {
            Intent intent = new Intent(Siruvani.this, rest2.class);
            startActivity(intent);
        });

        buttonHotel.setOnClickListener(v -> {
            Intent intent = new Intent(Siruvani.this, SiruvaniHotel.class);
            startActivity(intent);
        });
    }
}







//package com.example.tourism;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class Siruvani extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    Button button,rest,hotel;
//    LinearLayoutManager manager;
//    ArrayList<RecyclerViewModel> list = new ArrayList<>();
//    RecyclerViewItemDecoration decoration;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.siruvani);
//
//        ///// RECYCLER VIEW :
//
//        list.add(new RecyclerViewModel("", "", R.drawable.siruvani, 4.5f));
//        list.add(new RecyclerViewModel("", "", R.drawable.siruvani2, 4f));
//        list.add(new RecyclerViewModel("", "", R.drawable.siruvani3, 4.5f));
//        list.add(new RecyclerViewModel("", "", R.drawable.siruvani4, 3f));
//
//        recyclerView = findViewById(R.id.recyclerView);
//
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, list);
//        manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        decoration = new RecyclerViewItemDecoration(16);
//
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.addItemDecoration(decoration);
//
//
//        // Initialize the button
//        button = findViewById(R.id.button);
//        rest=findViewById((R.id.button3));
//        hotel=findViewById(R.id.button2);
//
//        // Set OnClickListener to the button
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create an intent with the Google Maps link
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/BgL6fQmBCm5WcoAZ7"));
//                // Start the intent
//                startActivity(intent);
//            }
//        });
//        rest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start SearchResultsActivity
//                Intent intent = new Intent(Siruvani.this, rest2.class);
//                startActivity(intent);
//            }
//        });
//
//        hotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start SearchResultsActivity
//                Intent intent = new Intent(Siruvani.this, SiruvaniHotel.class);
//                startActivity(intent);
//            }
//        });
//
//
//    }
//}
