package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);

        List<TextView> textViewList = new ArrayList<>();

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "yo", R.drawable.number_one, R.raw.swedish_white));
        words.add(new Word("two", "yo", R.drawable.number_two, R.raw.swedish_white));
        words.add(new Word("three", "yo", R.drawable.number_three, R.raw.swedish_white));
        words.add(new Word("four", "yo", R.drawable.number_four, R.raw.swedish_white));
        words.add(new Word("five", "yo", R.drawable.number_five, R.raw.swedish_white));
        words.add(new Word("six", "yo", R.drawable.number_six, R.raw.swedish_white));
        words.add(new Word("seven", "yo", R.drawable.number_seven, R.raw.swedish_white));
        words.add(new Word("eight", "yo", R.drawable.number_eight, R.raw.swedish_white));
        words.add(new Word("nince", "yo", R.drawable.number_nine, R.raw.swedish_white));
        words.add(new Word("ten", "yo",R.drawable.number_ten, R.raw.swedish_white));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                player = MediaPlayer.create(NumbersActivity.this, word.getAudioId());
                player.start();
            }
        });
    }
}
