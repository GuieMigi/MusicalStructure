package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    private Boolean isClicked = false;
    private ImageView playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        Intent getArtistName = getIntent();
        Intent getTrackTitle = getIntent();
        Intent getAlbumCover = getIntent();
        final String artistName = getArtistName.getStringExtra("ARTISTNAME");
        final String trackTitle = getTrackTitle.getStringExtra("TRACKTITLE");
        final int albumCover = getAlbumCover.getIntExtra("ALBUMCOVER", 0);
        TextView artistNameTextView = findViewById(R.id.artistNameTextViewNowPlaying);
        TextView trackTitleTextView = findViewById(R.id.trackTitleTextViewNowPlaying);
        ImageView albumCoverImageView = findViewById(R.id.albumCoverImageViewNowPlaying);
        TextView musicLibrary = findViewById(R.id.musicLibraryTextViewNowPlaying);
        ImageView previousButton = findViewById(R.id.previousButtonNowPlaying);
        playButton = findViewById(R.id.playButtonNowPlaying);
        ImageView stopButton = findViewById(R.id.stopButtonNowPlaying);
        ImageView nextButton = findViewById(R.id.nextButtonNowPlaying);

        artistNameTextView.setText(artistName);
        trackTitleTextView.setText(trackTitle);
        albumCoverImageView.setImageResource(albumCover);

        artistNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openTrackDetails = new Intent(NowPlaying.this, TrackDetails.class);
                openTrackDetails.putExtra("ARTISTNAME", artistName);
                openTrackDetails.putExtra("TRACKTITLE", trackTitle);
                openTrackDetails.putExtra("ALBUMCOVER", albumCover);
                startActivity(openTrackDetails);
            }
        });

        trackTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openTrackDetails = new Intent(NowPlaying.this, TrackDetails.class);
                openTrackDetails.putExtra("ARTISTNAME", artistName);
                openTrackDetails.putExtra("TRACKTITLE", trackTitle);
                openTrackDetails.putExtra("ALBUMCOVER", albumCover);
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
