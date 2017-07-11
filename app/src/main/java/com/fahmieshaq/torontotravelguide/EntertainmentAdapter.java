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

public class EntertainmentAdapter extends ArrayAdapter<Entertainment> {

    public EntertainmentAdapter(Context context, ArrayList<Entertainment> entertainments) {
        super(context, 0, entertainments);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.entertainments_list_item, parent, false);
        }

        Entertainment currentEntertainment = getItem(position);

        // Populate list items
        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_listitem_entertainments);
        imageView.setImageResource(currentEntertainment.getImageResourceId());

        TextView titleTextView = (TextView) convertView.findViewById(R.id.entertainments_title);
        titleTextView.setText(currentEntertainment.getTitle());

        TextView addressTextView = (TextView) convertView.findViewById(R.id.entertainments_address);
        addressTextView.setText(currentEntertainment.getAddress());

        TextView cityTextView = (TextView) convertView.findViewById(R.id.entertainments_city);
        cityTextView.setText(currentEntertainment.getCity());

        TextView phoneTextView = (TextView) convertView.findViewById(R.id.entertainments_phone);
        phoneTextView.setText(currentEntertainment.getPhone());
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.entertainments_phone);
                if (!textView.getText().toString().contains("N/A")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + textView.getText()));
                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        getContext().startActivity(intent);
                    }
                } else {
                    Toast.makeText(getContext(), getContext().getString(R.string.toast_msg_invalid_phone), Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView emailTextView = (TextView) convertView.findViewById(R.id.entertainments_email);
        emailTextView.setText(currentEntertainment.getEmail());
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.entertainments_email);
                if (textView.getText().toString().contains("@")) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + textView.getText()));
                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        getContext().startActivity(intent);
                    }
                } else {
                    Toast.makeText(getContext(), getContext().getString(R.string.toast_msg_invalid_email), Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView websiteTextView = (TextView) convertView.findViewById(R.id.entertainments_website);
        websiteTextView.setText(currentEntertainment.getWebsite());
        websiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.entertainments_website);
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
