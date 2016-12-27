package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Faßreiter on 26.12.2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int color_category;
    public WordAdapter(Activity numbersActivity, ArrayList<Word> words, int category_family) {
        super(numbersActivity, 0, words);
        this.color_category = category_family;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Word currentWord = getItem(position);

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView tvDefault = (TextView) listItemView.findViewById(R.id.default_text_view);
        tvDefault.setText(currentWord.getmDefaultTranslation());

        TextView tvMiwok = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        tvMiwok.setText(currentWord.getmMiwokTranslation());

        ImageView iv = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            iv.setImageResource(currentWord.getmImageResourceId());
            iv.setVisibility(View.VISIBLE);
        } else {
            iv.setVisibility(View.GONE);
        }





        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), color_category);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);



        return listItemView;
    }
}
