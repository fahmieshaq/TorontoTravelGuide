package com.fahmieshaq.torontotravelguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> {

    public EventAdapter(Context context, ArrayList<Event> events) {
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.events_list_item, parent, false);
        }

        Event currentEvent = getItem(position);

        // Populate list items
        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_listitem_events);
        imageView.setImageResource(currentEvent.getImageResourceId());

        TextView titleTextView = (TextView) convertView.findViewById(R.id.events_title);
        titleTextView.setText(currentEvent.getTitle());

        TextView addressTextView = (TextView) convertView.findViewById(R.id.events_address);
        addressTextView.setText(currentEvent.getAddress());

        TextView cityTextView = (TextView) convertView.findViewById(R.id.events_city);
        cityTextView.setText(currentEvent.getCity());

        TextView phoneTextView = (TextView) convertView.findViewById(R.id.events_phone);
        phoneTextView.setText(currentEvent.getPhone());
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.events_phone);
                if (!textView.getText().toString().contains("N/A")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + textView.getText()));
                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        getContext().startActivity(intent);
                    }
                } else {
                    Toast.makeText(getContext(), "Invalid phone. Visit our website", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView emailTextView = (TextView) convertView.findViewById(R.id.events_email);
        emailTextView.setText(currentEvent.getEmail());
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.events_email);
                if (textView.getText().toString().contains("@")) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + textView.getText()));
                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        getContext().startActivity(intent);
                    }
                } else {
                    Toast.makeText(getContext(), "Invalid rmail. Please call us", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView websiteTextView = (TextView) convertView.findViewById(R.id.events_website);
        websiteTextView.setText(currentEvent.getWebsite());
        websiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.events_website);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http:" + textView.getText()));
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    getContext().startActivity(intent);
                }
            }
        });

        return convertView;
    }
}
