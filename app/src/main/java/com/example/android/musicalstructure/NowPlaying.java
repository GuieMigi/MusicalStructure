package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    private Boolean isClicked = false;
    private ImageView playPauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        //Declaring the Intents to get the saved extras.
        Intent getArtistName = getIntent();
        Intent getTrackTitle = getIntent();
        Intent getAlbumCover = getIntent();
        Intent getGenre = getIntent();
        Intent getLaunchYear = getIntent();

        //Getting saved extras and storing them in variables.
        final String artistName = getArtistName.getStringExtra("ARTISTNAME");
        final String trackTitle = getTrackTitle.getStringExtra("TRACKTITLE");
        final int albumCover = getAlbumCover.getIntExtra("ALBUMCOVER", 0);
        final String genre = getGenre.getStringExtra("GENRE");
        final String launchYear = getLaunchYear.getStringExtra("LAUNCHYEAR");

        //Initialising the views.
        TextView artistNameTextView = findViewById(R.id.artistNameTextViewNowPlaying);
        TextView trackTitleTextView = findViewById(R.id.trackTitleTextViewNowPlaying);
        ImageView albumCoverImageView = findViewById(R.id.albumCoverImageViewNowPlaying);
        TextView musicLibrary = findViewById(R.id.musicLibraryTextViewNowPlaying);
        playPauseButton = findViewById(R.id.playPauseButtonNowPlaying);

        //Setting the Artist Name, Track Title and Album Cover resource.
        artistNameTextView.setText(artistName);
        trackTitleTextView.setText(trackTitle);
        albumCoverImageView.setImageResource(albumCover);

        //onClickListener that opens the Track Details when the artistNameTextView is clicked.
        //passes the Artist Name, Track Title, Album Cover, Genre and Launch Year using Intent.
        artistNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openTrackDetails = new Intent(NowPlaying.this, TrackDetails.class);
                openTrackDetails.putExtra("ARTISTNAME", artistName);
                openTrackDetails.putExtra("TRACKTITLE", trackTitle);
                openTrackDetails.putExtra("ALBUMCOVER", albumCover);
                openTrackDetails.putExtra("GENRE", genre);
                openTrackDetails.putExtra("LAUNCHYEAR", launchYear);
                startActivity(openTrackDetails);
            }
        });

        //onClickListener that opens the Track Details when the trackTitleTextView is clicked.
        //Passes the Artist Name, Track Title, Album Cover, Genre and Launch Year using Intent.
        trackTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openTrackDetails = new Intent(NowPlaying.this, TrackDetails.class);
                openTrackDetails.putExtra("ARTISTNAME", artistName);
                openTrackDetails.putExtra("TRACKTITLE", trackTitle);
                openTrackDetails.putExtra("ALBUMCOVER", albumCover);
                openTrackDetails.putExtra("GENRE", genre);
                openTrackDetails.putExtra("LAUNCHYEAR", launchYear);
                startActivity(openTrackDetails);
            }
        });

        //onClickListener that opens the Music Library when the Music Library TextView is clicked.
        musicLibrary.setOnClickListener(new View.OnClickListener() {
            // The code in this method will open the MusicLibrary activity when the Music Library TextView is clicked.
            @Override
            public void onClick(View view) {
                Intent openMusicLibrary = new Intent(NowPlaying.this, MusicLibrary.class);
                startActivity(openMusicLibrary);
            }
        });

        //onClickListener that switches between the play button and the pause button.
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play button is clicked.
            @Override
            public void onClick(View view) {
                if (!isClicked) {
                    playPauseButton.setImageResource(R.drawable.play_button);
                    isClicked = true;
                } else {
                    playPauseButton.setImageResource(R.drawable.pause_button);
                    isClicked = false;
                }
            }
        });
    }
}
