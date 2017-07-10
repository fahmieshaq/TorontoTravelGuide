package com.fahmieshaq.torontotravelguide;

public class Translation {

    private int mEnglishTextResourceId;
    private int mChineseTextResourceId;
    private int mEnglishAudioResourceId;

    public Translation(int englishTextResourceId, int chineseTextResourceId, int englishAudioResourceId) {
        mEnglishTextResourceId = englishTextResourceId;
        mChineseTextResourceId = chineseTextResourceId;
        mEnglishAudioResourceId = englishAudioResourceId;
    }

    public int getEnglishTextResourceId() {
        return mEnglishTextResourceId;
    }

    public int getChineseTextResourceId() {
        return mChineseTextResourceId;
    }

    public int getEnglishAudioResourceId() {
        return mEnglishAudioResourceId;
    }
}
