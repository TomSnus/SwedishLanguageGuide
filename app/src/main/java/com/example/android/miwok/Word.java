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

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    private static final int NO_IMAGE = -1;

    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word (String def, String miwok) {
        this.mDefaultTranslation = def;
        this.mMiwokTranslation = miwok;
    }

    public Word (String def, String miwok, int id) {
        this.mDefaultTranslation = def;
        this.mMiwokTranslation = miwok;
        this.mImageResourceId = id;
    }

    public boolean hasImage() {
        if(getmImageResourceId() == NO_IMAGE)
            return false;
        else return true;
    }
}
