package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicLibrary extends AppCompatActivity {

    String artistName, trackTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_library);

        //Create an ArrayList containing the Artist's name and the track title.
        ArrayList<TrackList> musicTrackList = new ArrayList<TrackList>();
        musicTrackList.add(new TrackList("Above & Beyond feat. Zoe Johnston", "We're All We Need"));
        musicTrackList.add(new TrackList("Armin van Buuren", "Blue Fear"));
        musicTrackList.add(new TrackList("Deep Dish feat. Stevie Nicks", "Dreams"));
        musicTrackList.add(new TrackList("DJ Project", "Spune-mi tot ce vrei"));
        musicTrackList.add(new TrackList("Faithless", "Salva Mea 2.0 (Above & Beyond Remix)"));
        musicTrackList.add(new TrackList("Faithless", "Insomnia (Blissy vs. Armand van Helden 2005 Rework)"));
        musicTrackList.add(new TrackList("Gabriel & Dresden", "Dangerous Power"));
        musicTrackList.add(new TrackList("Haito & Diringer", "Perception (Simon Baker Remix)"));
        musicTrackList.add(new TrackList("John Digweed", "Gridlock (Digweed And Muir's Stereo Club Mix)"));
        musicTrackList.add(new TrackList("Kings of Tomorrow feat. Elzi Hall", "Show Me"));
        musicTrackList.add(new TrackList("Motorcycle", "As The Rush Comes (Armin van Buuren's Universal Religion Mix)"));
        musicTrackList.add(new TrackList("Paul van Dyk  feat. Ashley Tomberlin", "New York City"));
        musicTrackList.add(new TrackList("Perpetuous Dreamer", "Dust.wav (Armin Van Buuren Rising Star Remix)"));
        musicTrackList.add(new TrackList("Rank 1", "Airwave"));
        musicTrackList.add(new TrackList("Sunlounger", "Another Day On The Terrace (Intro Club Mix)"));
        musicTrackList.add(new TrackList("The Thrillseekers vs. Sam Mitcham", "All The Little Things"));
        musicTrackList.add(new TrackList("Tiesto", "A Tear in the Open"));
        musicTrackList.add(new TrackList("Tiesto", "Adagio For Strings"));
        musicTrackList.add(new TrackList("Underher feat. Marton Harvest", "Time"));
        musicTrackList.add(new TrackList("Zaki feat. Joseph Chisanga", "Dancing With The Clouds"));

        //Create a TrackListAdapter whose data source is a musicTrackList ArrayList.
        TrackListAdapter adapter = new TrackListAdapter(this, musicTrackList);
        final ListView musicLibraryListView = findViewById(R.id.musicLibraryListView);
        // Make the musicLibraryListView use the TrackListAdapter created above, so that the
        // ListView will display list items for each TrackList in the list.
        musicLibraryListView.setAdapter(adapter);

        //Get the artistName and the trackTitle.
        TrackList trackList = new TrackList("", "");
        artistName = trackList.getArtistName();
        trackTitle = trackList.getTrackTitle();

        musicLibraryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openTrackDetails = new Intent(MusicLibrary.this, TrackDetails.class);
                openTrackDetails.putExtra("ARTISTNAME", artistName);
                openTrackDetails.putExtra("TRACKTITLE", trackTitle);
                startActivity(openTrackDetails);
            }
        });
    }
}
