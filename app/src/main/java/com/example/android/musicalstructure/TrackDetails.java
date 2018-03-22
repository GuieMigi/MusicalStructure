package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TrackDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_details);

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
        TextView artistNameTextView = findViewById(R.id.artistNameTextViewTrackDetails);
        TextView trackTitleTextView = findViewById(R.id.trackTitleTextViewTrackDetails);
        TextView genreTextView = findViewById(R.id.genreTextViewTrackDetails);
        TextView launchYearTextView = findViewById(R.id.launchYearTextViewTrackDetails);
        TextView musicLibrary = findViewById(R.id.musicLibraryTextViewTrackDetails);
        ImageView albumCoverImageView = findViewById(R.id.imageViewTrackDetails);
        ImageView playButton = findViewById(R.id.playButtonImageViewTrackDetails);

        //Setting the Artist Name, Track Title, Album Cover, Genre and Launch Year.
        artistNameTextView.setText(artistName);
        trackTitleTextView.setText(trackTitle);
        albumCoverImageView.setImageResource(albumCover);
        genreTextView.setText("Genre: " + genre);
        launchYearTextView.setText("Year: " + launchYear);

        //onClickListener that opens the Music Library when the Music Library TextView is clicked.
        musicLibrary.setOnClickListener(new View.OnClickListener() {
            // The code in this method will open the MusicLibrary activity when the Music Library TextView is clicked.
            @Override
            public void onClick(View view) {
                Intent openMusicLibrary = new Intent(TrackDetails.this, MusicLibrary.class);
                startActivity(openMusicLibrary);
            }
        });

        //onClickListener that opens the Now Playing activity when the Play Button is clicked.
        //Passes the Artist Name, Track Title, Album Cover, Genre and Launch Year using Intent.
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openNowPlaying = new Intent(TrackDetails.this, NowPlaying.class);
                openNowPlaying.putExtra("ARTISTNAME", artistName);
                openNowPlaying.putExtra("TRACKTITLE", trackTitle);
                openNowPlaying.putExtra("ALBUMCOVER", albumCover);
                openNowPlaying.putExtra("GENRE", genre);
                openNowPlaying.putExtra("LAUNCHYEAR", launchYear);
                startActivity(openNowPlaying);
            }
        });
    }
}