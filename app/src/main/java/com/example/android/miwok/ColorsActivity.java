package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        List<TextView> textViewList = new ArrayList<>();

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "yo", R.drawable.color_black));
        words.add(new Word("two", "yo", R.drawable.color_brown));
        words.add(new Word("three", "yo", R.drawable.color_dusty_yellow));
        words.add(new Word("four", "yo", R.drawable.color_gray));
        words.add(new Word("five", "yo", R.drawable.color_green));
        words.add(new Word("six", "yo", R.drawable.color_mustard_yellow));
        words.add(new Word("seven", "yo", R.drawable.color_red));
        words.add(new Word("eight", "yo", R.drawable.color_white));


        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        if(listView != null)
            listView.setAdapter(itemsAdapter);
        else
            Log.v("listview not found", "listview not found");

    }


}
