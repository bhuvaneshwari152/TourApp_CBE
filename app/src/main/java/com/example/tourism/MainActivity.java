package com.example.tourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

/**import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView**/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AdapterViewFlipper flipper;
    ArrayList<AdapterFlipperModel> flipper_data;
    AdapterFlipper_BaseAdapter flipper_baseadapter;

    CardView amritsar;
    CardView vellia;
    CardView siruvani;
    CardView maruthu;
    CardView kutralam;
    CardView lake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = findViewById(R.id.adapter_flipper_home); //main flipper of the home which would be shown in application

        flipper_data = new ArrayList<>();

        //Adding items to flipper_data arraylist.
        flipper_data.add(new AdapterFlipperModel("Isha", "", R.drawable.isha2)); //setting values to the items which were in the constructor of model adpater java class
        flipper_data.add(new AdapterFlipperModel("Siruvani", "", R.drawable.siruvani));
        flipper_data.add(new AdapterFlipperModel("Maruthamalai Hills", "", R.drawable.maruthamalai));
        flipper_data.add(new AdapterFlipperModel("Brookfields Mall", "", R.drawable.brookefields));
        flipper_data.add(new AdapterFlipperModel("Kovai Kutralam", "", R.drawable.kovaikutralamfalls));

        //Setting the adapter
        flipper_baseadapter = new AdapterFlipper_BaseAdapter(this, flipper_data);
        flipper.setAdapter(flipper_baseadapter);

        //Few settings for controlling the flipper
        flipper.setAutoStart(true); //start when the application starts without the user click.
        flipper.setFlipInterval(3000); //3000 milliseconds = 3 seconds.

        amritsar = findViewById(R.id.amritsar_home);
        siruvani = findViewById(R.id.siruvani_home);
        vellia   = findViewById(R.id.velli);
        maruthu=findViewById(R.id.maruthamalai);
        kutralam=findViewById(R.id.kk);
        lake=findViewById(R.id.ulake);

        amritsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, City_Information.class));
            }
        });

        lake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ukkadam_lake.class));
            }
        });


        maruthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, maruthamalai.class));
            }
        });

        siruvani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Siruvani.class));
            }
        });

        vellia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, velliangiri.class));
            }
        });

        kutralam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, kovaikutralam.class));
            }
        });

        CardView searchButton = findViewById(R.id.cardView);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SearchResultsActivity
                Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
                startActivity(intent);
            }
        });

        CardView transportationCard = findViewById(R.id.cardView3);
        CardView shopping = findViewById(R.id.shopcard);
        transportationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Transportation.class));
            }
        });

        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, shop.class));
            }
        });


        CardView list = findViewById(R.id.cardView2);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, userlist.class)); //Last Game
            }
        });

    }
}