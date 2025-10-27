package com.example.tourism;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import com.google.firebase.firestore.DocumentReference;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class LastGame extends AppCompatActivity {

    private EditText placeNameEditText;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Button saveButton;

    private FirebaseFirestore db;
    private FirebaseAuth auth;

    private LinearLayout tripsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_game);

        // Initialize Firebase Firestore and Authentication
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        placeNameEditText = findViewById(R.id.editTextPlaceName);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        saveButton = findViewById(R.id.buttonSave);
        tripsContainer = findViewById(R.id.tripsContainer);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTripDetails();
            }
        });

        // Load trip details when the activity is created
        loadTripDetails();
    }

    private void saveTripDetails() {
        String userId = auth.getCurrentUser().getUid();
        String placeName = placeNameEditText.getText().toString();

        // Get selected date and time
        Calendar calendar = Calendar.getInstance();
        calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                timePicker.getCurrentHour(), timePicker.getCurrentMinute());

        // Create a map to store trip details
        Map<String, Object> tripDetails = new HashMap<>();
        tripDetails.put("userId", userId);
        tripDetails.put("placeName", placeName);
        tripDetails.put("timestamp", calendar.getTimeInMillis());

        // Save trip details to Firestore
        db.collection("trips")
                .add(tripDetails)

                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LastGame.this,"Trip Added Successfully",Toast.LENGTH_SHORT).show();
                            // Trip details saved successfully
                            // You can add any additional logic here

                            // Update TextView with place name
                            addTripToView(placeName);
                        } else {
                            // Handle error
                        }
                    }
                });
    }

    private void loadTripDetails() {
        // Load trip details from Firestore
        db.collection("trips")
                .whereEqualTo("userId", auth.getCurrentUser().getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Retrieve place name from Firestore and add it to the view
                                String placeName = document.getString("placeName");
                                addTripToView(placeName);
                            }
                        } else {
                            // Handle error
                        }
                    }
                });
    }

    private void addTripToView(String placeName) {
        // Create a new TextView to display the place name
        TextView tripTextView = new TextView(this);
        tripTextView.setText(placeName);

        // Add onClickListener to delete the trip when clicked
        tripTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove trip from Firestore and from the view
                // You can implement the deletion logic here
                tripsContainer.removeView(tripTextView);
            }
        });

        // Add the TextView to the tripsContainer
        tripsContainer.addView(tripTextView);
    }
}
