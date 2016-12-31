package com.example.android.miwok;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    public FamilyFragment() {
        // Required empty public constructor
    }


    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

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

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        if(listView != null)
            listView.setAdapter(itemsAdapter);
        else
            Log.v("listview not found", "listview not found");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioId());
                mMediaPlayer.start();
            }
        });
        return rootView;

    }


    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if(mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
