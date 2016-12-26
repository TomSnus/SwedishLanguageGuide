package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        List<TextView> textViewList = new ArrayList<>();

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "yo", R.drawable.number_one));
        words.add(new Word("two", "yo", R.drawable.number_two));
        words.add(new Word("three", "yo", R.drawable.number_three));
        words.add(new Word("four", "yo", R.drawable.number_four));
        words.add(new Word("five", "yo", R.drawable.number_five));
        words.add(new Word("six", "yo", R.drawable.number_six));
        words.add(new Word("seven", "yo", R.drawable.number_seven));
        words.add(new Word("eight", "yo", R.drawable.number_eight));
        words.add(new Word("nince", "yo", R.drawable.number_nine));
        words.add(new Word("ten", "yo",R.drawable.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
