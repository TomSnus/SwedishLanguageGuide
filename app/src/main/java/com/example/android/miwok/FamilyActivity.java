package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer player;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);

        List<TextView> textViewList = new ArrayList<>();

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "yo", R.drawable.family_father, R.raw.swedish_white));
        words.add(new Word("two", "yo", R.drawable.family_daughter, R.raw.swedish_white));
        words.add(new Word("three", "yo", R.drawable.family_grandfather, R.raw.swedish_white));
        words.add(new Word("four", "yo", R.drawable.family_grandmother, R.raw.swedish_white));
        words.add(new Word("five", "yo", R.drawable.family_mother, R.raw.swedish_white));
        words.add(new Word("six", "yo", R.drawable.family_older_brother, R.raw.swedish_white));
        words.add(new Word("seven", "yo", R.drawable.family_older_sister, R.raw.swedish_white));
        words.add(new Word("eight", "yo", R.drawable.family_son, R.raw.swedish_white));
        words.add(new Word("two", "yo", R.drawable.family_younger_brother, R.raw.swedish_white));
        words.add(new Word("three", "yo", R.drawable.family_younger_sister, R.raw.swedish_white));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);
        if(listView != null)
            listView.setAdapter(itemsAdapter);
        else
            Log.v("listview not found", "listview not found");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                player = MediaPlayer.create(FamilyActivity.this, word.getAudioId());
                player.start();
            }
        });
    }
}
