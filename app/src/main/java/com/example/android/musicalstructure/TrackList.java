package com.example.android.musicalstructure;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Florin on 14.03.2018.
 */

public class TrackList extends AppCompatActivity {

    //Artist name.
    String mArtistName;

    //Track title.
    String mTrackTitle;

    public TrackList(String artistName, String trackTitle){
        mArtistName = artistName;
        mTrackTitle = trackTitle;
    }

    // Get the artist's name.
    public String getArtistName(){return mArtistName;}

    // Get the track title.
    public String getTrackTitle(){return mTrackTitle;}
}
