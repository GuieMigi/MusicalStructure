package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TrackDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_details);
        Intent getArtistName = getIntent();
        Intent getTrackTitle = getIntent();
        String artistName = getArtistName.getStringExtra("ARTISTNAME");
        String trackTitle = getTrackTitle.getStringExtra("TRACKTITLE");
        TextView artistNameTextView = findViewById(R.id.artistNameTextViewTrackDetails);
        TextView trackTitleTextView = findViewById(R.id.trackTitleTextViewTrackDetails);
        artistNameTextView.setText(artistName);
        trackTitleTextView.setText(trackTitle);

    }
}
