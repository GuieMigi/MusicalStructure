package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    private Boolean isClicked = false;
    private TextView musicLibrary, nowPlayingArtist, nowPlayingTrack;
    private ImageView previousButton, playButton, stopButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        musicLibrary = findViewById(R.id.musicLibraryTextView);
        nowPlayingArtist = findViewById(R.id.artistName);
        nowPlayingTrack = findViewById(R.id.trackTitle);
        previousButton = findViewById(R.id.previousButton);
        playButton = findViewById(R.id.playButton);
        stopButton = findViewById(R.id.stopButton);
        nextButton = findViewById(R.id.nextButton);

        nowPlayingArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openTrackDetails = new Intent(NowPlaying.this, TrackDetails.class);
                startActivity(openTrackDetails);
            }
        });

        nowPlayingTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openTrackDetails = new Intent(NowPlaying.this, TrackDetails.class);
                startActivity(openTrackDetails);
            }
        });

        musicLibrary.setOnClickListener(new View.OnClickListener() {
            // The code in this method will open the MusicLibrary activity when the Music Library TextView is clicked.
            @Override
            public void onClick(View view) {
                Intent openMusicLibrary = new Intent(NowPlaying.this, MusicLibrary.class);
                startActivity(openMusicLibrary);
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the previous button is clicked.
            @Override
            public void onClick(View view) {
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play button is clicked.
            @Override
            public void onClick(View view) {
                if(!isClicked){
                    playButton.setImageResource(R.drawable.pause_button);
                    isClicked = true;
                } else if(isClicked){
                    playButton.setImageResource(R.drawable.play_button);
                    isClicked = false;
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the stop button is clicked.
            @Override
            public void onClick(View view) {
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the next button is clicked.
            @Override
            public void onClick(View view) {
            }
        });
    }
}
