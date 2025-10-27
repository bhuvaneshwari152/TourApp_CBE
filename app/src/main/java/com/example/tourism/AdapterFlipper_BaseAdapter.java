package com.example.tourism;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterFlipper_BaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<AdapterFlipperModel> flipperList;

    public AdapterFlipper_BaseAdapter(Context context, ArrayList<AdapterFlipperModel> flipperList) {
        this.context = context;
        this.flipperList = flipperList;
    }

    @Override
    public int getCount() {
        return flipperList.size();
    }

    @Override
    public Object getItem(int position) {
        return flipperList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.flipper_item, parent, false);

        ImageView imageView = view.findViewById(R.id.flipper_image);
        TextView title = view.findViewById(R.id.flipper_title);

        AdapterFlipperModel model = flipperList.get(position);

        imageView.setImageResource(model.getImage());
        title.setText(model.getTitle());

        return view;
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
//        rest = findViewById((R.id.button3));
//        hotel = findViewById(R.id.button2);
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
