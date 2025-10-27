package com.example.tourism;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SearchResultsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> places;
    private ArrayList<String> filteredPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        listView = findViewById(R.id.listView);
        SearchView searchView = findViewById(R.id.searchView);

        // Initialize places
        places = new ArrayList<>(Arrays.asList("Isha", "Siruvani", "Maruthamalai", "Kovai Kutralam", "Ukkadam Lake", "Vellaingiri"));
        filteredPlaces = new ArrayList<>(places);

        // Create adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filteredPlaces);
        listView.setAdapter(adapter);

        // Set up item click listener for ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPlace = filteredPlaces.get(position);
                Intent intent;
                switch (selectedPlace) {
                    case "Siruvani":
                        intent = new Intent(SearchResultsActivity.this, Siruvani.class);
                        break;
                    case "Isha":
                        intent = new Intent(SearchResultsActivity.this, City_Information.class);
                        break;
                    case "Ukkadam Lake":
                        intent = new Intent(SearchResultsActivity.this, ukkadam_lake.class);
                        break;
                    case "Vellaingiri":
                        intent = new Intent(SearchResultsActivity.this, velliangiri.class);
                        break;
                    case "Maruthamalai":
                        intent = new Intent(SearchResultsActivity.this, maruthamalai.class);
                        break;
                    case "Kovai Kutralam":
                        intent = new Intent(SearchResultsActivity.this, kovaikutralam.class);
                        break;
                    default:
                        intent = null;
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });

        // Set up search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String query) {
        filteredPlaces.clear();
        for (String place : places) {
            if (place.toLowerCase().contains(query.toLowerCase())) {
                filteredPlaces.add(place);
            }
        }

        // Sort filteredPlaces based on the index of the typed letters
        Collections.sort(filteredPlaces, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int index1 = s1.toLowerCase().indexOf(query.toLowerCase());
                int index2 = s2.toLowerCase().indexOf(query.toLowerCase());
                if (index1 == -1 && index2 == -1) {
                    return s1.compareToIgnoreCase(s2);
                } else if (index1 == -1) {
                    return 1;
                } else if (index2 == -1) {
                    return -1;
                }
                return Integer.compare(index1, index2);
            }
        });

        adapter.notifyDataSetChanged();
    }
}
