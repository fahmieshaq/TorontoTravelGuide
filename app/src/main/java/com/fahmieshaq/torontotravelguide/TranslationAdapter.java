package com.fahmieshaq.torontotravelguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TranslationAdapter extends ArrayAdapter<Translation> {

    public TranslationAdapter(Context context, ArrayList<Translation> translations) {
        super(context, 0, translations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.translation_list_item, parent, false);
        }

        Translation currentTranslation = getItem(position);

        // Populate list items
        TextView englishTextView = (TextView) convertView.findViewById(R.id.translation_english);
        englishTextView.setText(currentTranslation.getEnglishTextResourceId());

        TextView chineseTextView = (TextView) convertView.findViewById(R.id.translation_chinese);
        chineseTextView.setText(currentTranslation.getChineseTextResourceId());

        return convertView;
    }
}
