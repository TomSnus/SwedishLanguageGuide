package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer player;

    @Override
    protected void onStop() {
        super.onStop();
        if(player != null)
            player.release();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);

        List<TextView> textViewList = new ArrayList<>();

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "yo", R.drawable.color_black, R.raw.swedish_blue));
        words.add(new Word("two", "yo", R.drawable.color_brown, R.raw.swedish_brown));
        words.add(new Word("three", "yo", R.drawable.color_dusty_yellow, R.raw.swedish_blue));
        words.add(new Word("four", "yo", R.drawable.color_gray, R.raw.swedish_grey));
        words.add(new Word("five", "yo", R.drawable.color_green,R.raw.swedish_green));
        words.add(new Word("six", "yo", R.drawable.color_mustard_yellow, R.raw.swedish_yellow));
        words.add(new Word("seven", "yo", R.drawable.color_red, R.raw.swedish_red));
        words.add(new Word("eight", "yo", R.drawable.color_white, R.raw.swedish_white));


        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        if(listView != null)
            listView.setAdapter(itemsAdapter);
        else
            Log.v("listview not found", "listview not found");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                player = MediaPlayer.create(ColorsActivity.this, word.getAudioId());
                player.start();
            }
        });

    }


}
