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

    //Track title.
    int mAlbumCover;

    //Track genre.
    String mGenre;

    //Track launch year.
    String mLaunchYear;

    public TrackList(String artistName, String trackTitle, int albumCover, String genre, String launchYear) {
        mArtistName = artistName;
        mTrackTitle = trackTitle;
        mAlbumCover = albumCover;
        mGenre = genre;
        mLaunchYear = launchYear;
    }

    // Get the artist's name.
    public String getArtistName(){return mArtistName;}

    // Get the track title.
    public String getTrackTitle(){return mTrackTitle;}

    //Get the album cover.
    public int getAlbumCover() {
        return mAlbumCover;
    }

    //Get the genre.
    public String getGenre() {
        return mGenre;
    }

    //Get the launch year.
    public String getLaunchYear() {
        return mLaunchYear;
    }
}