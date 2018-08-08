package com.example.android.newmiwok;

public class Word {

   private String DefaultTranslation;
    private String MiwokTranslation;
    private int mResourceId;
    private boolean hasImg;
    private int SoundId;

    public Word(String miwok, String english,int Resid,int Sound)
    {
        DefaultTranslation=english;
        MiwokTranslation=miwok;
        mResourceId=Resid;
        hasImg=true;
        SoundId=Sound;

    }
    public Word(String miwok, String english,int soundId)
    {
         DefaultTranslation=english;
         MiwokTranslation=miwok;
         hasImg=false;
         SoundId=soundId;

    }

    public String getMiwokTranslation() {
        return MiwokTranslation;
    }

    public String getDefaultTranslation() {
        return DefaultTranslation;
    }

    public int getResourceId() {
        return mResourceId;
    }

    public boolean isHasImg() {
        return hasImg;
    }

    public int getSoundId() {
        return SoundId;
    }
}
