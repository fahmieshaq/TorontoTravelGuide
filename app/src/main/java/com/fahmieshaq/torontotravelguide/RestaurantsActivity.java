package com.fahmieshaq.torontotravelguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant(R.drawable.img_listitem_restaurants_pide, R.string.restaurants_title_pide,
                R.string.restaurants_address_pide, R.string.restaurants_city_pide, R.string.restaurants_phone_pide,
                R.string.restaurants_email_pide, R.string.restaurants_website_pide));
        restaurants.add(new Restaurant(R.drawable.img_listitem_restaurants_works, R.string.restaurants_title_works,
                R.string.restaurants_address_works, R.string.restaurants_city_works, R.string.restaurants_phone_works,
                R.string.restaurants_email_works, R.string.restaurants_website_works));
        restaurants.add(new Restaurant(R.drawable.img_listitem_restaurants_gilaneh, R.string.restaurants_title_gilaneh,
                R.string.restaurants_address_gilaneh, R.string.restaurants_city_gilaneh, R.string.restaurants_phone_gilaneh,
                R.string.restaurants_email_gilaneh, R.string.restaurants_website_gilaneh));
        restaurants.add(new Restaurant(R.drawable.img_listitem_restaurants_darband, R.string.restaurants_title_darband,
                R.string.restaurants_address_darband, R.string.restaurants_city_darband, R.string.restaurants_phone_darband,
                R.string.restaurants_email_darband, R.string.restaurants_website_darband));
        restaurants.add(new Restaurant(R.drawable.img_listitem_restaurants_messini, R.string.restaurants_title_messini,
                R.string.restaurants_address_messini, R.string.restaurants_city_messini, R.string.restaurants_phone_messini,
                R.string.restaurants_email_messini, R.string.restaurants_website_messini));

        RestaurantAdapter adapter = new RestaurantAdapter(this, restaurants);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
