package com.example.tourism;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class guide_activity extends AppCompatActivity {
    private TextView guideNameTextView;
    private TextView guideContactTextView;
    private DatabaseReference guideRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        guideNameTextView = findViewById(R.id.textViewGuideName);
        guideContactTextView = findViewById(R.id.textViewGuideContact);

        // Get reference to Firebase Realtime Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        guideRef = database.getReference("guides/guide1"); // Change guide1 to the actual guide ID

        // Read data from Firebase Database
        guideRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Guide guide = dataSnapshot.getValue(Guide.class);
                if (guide != null) {
                    guideNameTextView.setText(guide.getName());
                    guideContactTextView.setText(guide.getContact());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database error
            }
        });
    }
}
