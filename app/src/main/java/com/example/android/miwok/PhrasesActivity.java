package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        List<TextView> textViewList = new ArrayList<>();

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "yo"));
        words.add(new Word("two", "yo"));
        words.add(new Word("three", "yo"));
        words.add(new Word("four", "yo"));
        words.add(new Word("five", "yo"));
        words.add(new Word("six", "yo"));
        words.add(new Word("seven", "yo"));
        words.add(new Word("eight", "yo"));
        words.add(new Word("two", "yo"));
        words.add(new Word("three", "yo"));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);
        if(listView != null)
            listView.setAdapter(itemsAdapter);
        else
            Log.v("listview not found", "listview not found");

    }
}
