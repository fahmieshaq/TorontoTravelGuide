package com.fahmieshaq.torontotravelguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout listRestaurants = (LinearLayout) findViewById(R.id.list_restaurants);
        listRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout listEntertainments = (LinearLayout) findViewById(R.id.list_entertainments);
        listEntertainments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EntertainmentsActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout listEvents = (LinearLayout) findViewById(R.id.list_events);
        listEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout listMuseums = (LinearLayout) findViewById(R.id.list_museums);
        listMuseums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MuseumsActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout listTranslation = (LinearLayout) findViewById(R.id.list_translation);
        listTranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TranslationActivity.class);
                startActivity(intent);
            }
        });
    }
}
