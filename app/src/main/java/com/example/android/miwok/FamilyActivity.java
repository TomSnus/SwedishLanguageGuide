package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        List<TextView> textViewList = new ArrayList<>();

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "yo", R.drawable.family_father));
        words.add(new Word("two", "yo", R.drawable.family_daughter));
        words.add(new Word("three", "yo", R.drawable.family_grandfather));
        words.add(new Word("four", "yo", R.drawable.family_grandmother));
        words.add(new Word("five", "yo", R.drawable.family_mother));
        words.add(new Word("six", "yo", R.drawable.family_older_brother));
        words.add(new Word("seven", "yo", R.drawable.family_older_sister));
        words.add(new Word("eight", "yo", R.drawable.family_son));
        words.add(new Word("two", "yo", R.drawable.family_younger_brother));
        words.add(new Word("three", "yo", R.drawable.family_younger_sister));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);
        if(listView != null)
            listView.setAdapter(itemsAdapter);
        else
            Log.v("listview not found", "listview not found");

    }
}
