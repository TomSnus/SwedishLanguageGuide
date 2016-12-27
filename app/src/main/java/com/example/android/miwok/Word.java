package com.example.android.miwok;

import android.media.Image;

/**
 * Created by Faßreiter on 26.12.2016.
 */

public class Word {

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    private int mImageResourceId = NO_IMAGE;
    private int audioId = NO_AUDIO;

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    private static final int NO_IMAGE = -1;
    private static final int NO_AUDIO = -1;
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word (String def, String miwok, int audioId) {
        this.mDefaultTranslation = def;
        this.mMiwokTranslation = miwok;
        this.audioId = audioId;
    }

    public Word (String def, String miwok, int id, int audioId) {
        this.mDefaultTranslation = def;
        this.mMiwokTranslation = miwok;
        this.mImageResourceId = id;
        this.audioId = audioId;
    }

    public boolean hasImage() {
        if(getmImageResourceId() == NO_IMAGE)
            return false;
        else return true;
    }



    public boolean hasAudio() {
        if(getAudioId() == NO_AUDIO)
            return false;
        else return true;
    }

    public int getAudioId() {
        return audioId;
    }
}
