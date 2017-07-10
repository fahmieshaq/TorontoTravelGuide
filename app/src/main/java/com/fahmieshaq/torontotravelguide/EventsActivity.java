package com.fahmieshaq.torontotravelguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(R.drawable.img_listitem_events_royalcircus, R.string.events_title_royalcircus,
                R.string.events_address_royalcircus, R.string.events_city_royalcircus, R.string.events_phone_royalcircus,
                R.string.events_email_royalcircus, R.string.events_website_royalcircus));
        events.add(new Event(R.drawable.img_listitem_events_greek, R.string.events_title_greek,
                R.string.events_address_greek, R.string.events_city_greek, R.string.events_phone_greek,
                R.string.events_email_greek, R.string.events_website_greek));
        events.add(new Event(R.drawable.img_listitem_events_magic, R.string.events_title_magic,
                R.string.events_address_magic, R.string.events_city_magic, R.string.events_phone_magic,
                R.string.events_email_magic, R.string.events_website_magic));

        EventAdapter adapter = new EventAdapter(this, events);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
