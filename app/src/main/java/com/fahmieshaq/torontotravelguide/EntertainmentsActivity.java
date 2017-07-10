package com.fahmieshaq.torontotravelguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class EntertainmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ArrayList<Entertainment> entertainments = new ArrayList<Entertainment>();
        entertainments.add(new Entertainment(R.drawable.img_listitem_entertainments_wonderland, R.string.entertainments_title_wonderland,
                R.string.entertainments_address_wonderland, R.string.entertainments_city_wonderland, R.string.entertainments_phone_wonderland,
                R.string.entertainments_email_wonderland, R.string.entertainments_website_wonderland));
        entertainments.add(new Entertainment(R.drawable.img_listitem_entertainments_safari, R.string.entertainments_title_safari,
                R.string.entertainments_address_safari, R.string.entertainments_city_safari, R.string.entertainments_phone_safari,
                R.string.entertainments_email_safari, R.string.entertainments_website_safari));
        entertainments.add(new Entertainment(R.drawable.img_listitem_entertainments_aquarium, R.string.entertainments_title_aquarium,
                R.string.entertainments_address_aquarium, R.string.entertainments_city_aquarium, R.string.entertainments_phone_aquarium,
                R.string.entertainments_email_aquarium, R.string.entertainments_website_aquarium));
        entertainments.add(new Entertainment(R.drawable.img_listitem_entertainments_playdium, R.string.entertainments_title_playdium,
                R.string.entertainments_address_playdium, R.string.entertainments_city_playdium, R.string.entertainments_phone_playdium,
                R.string.entertainments_email_playdium, R.string.entertainments_website_playdium));

        EntertainmentAdapter adapter = new EntertainmentAdapter(this, entertainments);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
