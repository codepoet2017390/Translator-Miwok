package com.example.android.newmiwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordsAdapter extends ArrayAdapter<Word>  {

private int ColorResId;

    public WordsAdapter(Activity context, ArrayList<Word> words, int colorResId) {
        super(context,0,words);
        ColorResId=colorResId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitems=convertView;


        Word object=getItem(position);
        if(object.isHasImg()) {
            if (listitems == null) {
                listitems = LayoutInflater.from(getContext()).inflate(R.layout.listview_layout, parent, false);
            }
            //final MediaPlayer player=MediaPlayer.create(getContext(),object.getSoundId());
            View textcontainer=listitems.findViewById(R.id.impview);
            int color= ContextCompat.getColor(getContext(),ColorResId);
            textcontainer.setBackgroundColor(color);
//             LinearLayout layout=(LinearLayout) listitems.findViewById(R.id.bajadegana);
//             layout.setOnClickListener(new View.OnClickListener() {
//                 @Override
//                 public void onClick(View v) {
//                   player.start();
//                 }
//             });
            TextView EngTextView = (TextView) listitems.findViewById(R.id.english_word);
            ImageView imageView=(ImageView)listitems.findViewById(R.id.imageView);
            imageView.setImageResource(object.getResourceId());
            EngTextView.setText(object.getDefaultTranslation());
            TextView Miwok = (TextView) listitems.findViewById(R.id.miwok_word);
            Miwok.setText(object.getMiwokTranslation());
        }
        if (!object.isHasImg())
        {
            if (listitems == null) {
                listitems = LayoutInflater.from(getContext()).inflate(R.layout.phrase_layout, parent, false);
            }
            final MediaPlayer player=MediaPlayer.create(getContext(),object.getSoundId());
            LinearLayout layout=(LinearLayout) listitems.findViewById(R.id.impview1);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    player.start();
                }
            });
   View textcontainer=listitems.findViewById(R.id.impview1);
            int color= ContextCompat.getColor(getContext(),ColorResId);
            textcontainer.setBackgroundColor(color);


            TextView EngTextView = (TextView) listitems.findViewById(R.id.english_word);
            EngTextView.setText(object.getDefaultTranslation());
            TextView Miwok = (TextView) listitems.findViewById(R.id.miwok_word);
            Miwok.setText(object.getMiwokTranslation());
}

        return listitems;
        ///return super.getView(position, convertView, parent);
    }
}