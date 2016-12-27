package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {


    private MediaPlayer player;
    private AudioManager audioManager;
    private MediaPlayer.OnCompletionListener playingCompleted = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Toast.makeText(PhrasesActivity.this, "Done!", Toast.LENGTH_SHORT);
            releasePlayer();

        }
    };
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focus) {
                    if(focus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        player.pause();
                        player.seekTo(0);
                    } else if (focus == AudioManager.AUDIOFOCUS_GAIN) {
                        player.start();
                    } else if (focus == AudioManager.AUDIOFOCUS_LOSS) {
                        player.stop();
                        releasePlayer();
                    }
                }
            };



    protected void onStop() {
        super.onStop();
        releasePlayer();

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);
        audioManager = (AudioManager)  getSystemService(Context.AUDIO_SERVICE);
        List<TextView> textViewList = new ArrayList<>();

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "yo", R.raw.swedish_white));
        words.add(new Word("two", "yo", R.raw.swedish_white));
        words.add(new Word("three", "yo", R.raw.swedish_white));
        words.add(new Word("four", "yo", R.raw.swedish_white));
        words.add(new Word("five", "yo", R.raw.swedish_white));
        words.add(new Word("six", "yo", R.raw.swedish_white));
        words.add(new Word("seven", "yo", R.raw.swedish_white));
        words.add(new Word("eight", "yo", R.raw.swedish_white));
        words.add(new Word("two", "yo", R.raw.swedish_white));
        words.add(new Word("three", "yo", R.raw.swedish_white));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);
        if (listView != null)
            listView.setAdapter(itemsAdapter);
        else
            Log.v("listview not found", "listview not found");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                //Audio Focus
                int result = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    player = MediaPlayer.create(PhrasesActivity.this, word.getAudioId());
                    player.start();
                    player.setOnCompletionListener(playingCompleted);
                }





            }
        });
    }
        private void releasePlayer() {
            if(player != null) {
                player.release();
                player = null;
            }
            audioManager.abandonAudioFocus(audioFocusChangeListener);

        }
}

