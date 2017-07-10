package com.fahmieshaq.torontotravelguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ArrayList<Museum> museums = new ArrayList<Museum>();

        museums.add(new Museum(R.drawable.img_listitem_museums_fortyork, R.string.museums_title_fortyork,
                R.string.museums_address_fortyork, R.string.museums_city_fortyork, R.string.museums_phone_fortyork,
                R.string.museums_email_fortyork, R.string.museums_website_fortyork));
        museums.add(new Museum(R.drawable.img_listitem_museums_gibson, R.string.museums_title_gibson,
                R.string.museums_address_gibson, R.string.museums_city_gibson, R.string.museums_phone_gibson,
                R.string.museums_email_gibson, R.string.museums_website_gibson));
        museums.add(new Museum(R.drawable.img_listitem_museums_mack, R.string.museums_title_mack,
                R.string.museums_address_mack, R.string.museums_city_mack, R.string.museums_phone_mack,
                R.string.museums_email_mack, R.string.museums_website_mack));

        MuseumAdapter adapter = new MuseumAdapter(this, museums);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
