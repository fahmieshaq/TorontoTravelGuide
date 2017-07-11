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

public class MuseumAdapter extends ArrayAdapter<Museum> {

    public MuseumAdapter(Context context, ArrayList<Museum> museums) {
        super(context, 0, museums);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.museums_list_item, parent, false);
        }

        Museum currentMuseum = getItem(position);

        // Populate list items
        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_listitem_museums);
        imageView.setImageResource(currentMuseum.getImageResourceId());

        TextView titleTextView = (TextView) convertView.findViewById(R.id.museums_title);
        titleTextView.setText(currentMuseum.getTitle());

        TextView addressTextView = (TextView) convertView.findViewById(R.id.museums_address);
        addressTextView.setText(currentMuseum.getAddress());

        TextView cityTextView = (TextView) convertView.findViewById(R.id.museums_city);
        cityTextView.setText(currentMuseum.getCity());

        TextView phoneTextView = (TextView) convertView.findViewById(R.id.museums_phone);
        phoneTextView.setText(currentMuseum.getPhone());
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.museums_phone);
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

        TextView emailTextView = (TextView) convertView.findViewById(R.id.museums_email);
        emailTextView.setText(currentMuseum.getEmail());
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.museums_email);
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

        TextView websiteTextView = (TextView) convertView.findViewById(R.id.museums_website);
        websiteTextView.setText(currentMuseum.getWebsite());
        websiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.museums_website);
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