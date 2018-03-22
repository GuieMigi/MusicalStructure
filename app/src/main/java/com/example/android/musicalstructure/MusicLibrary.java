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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_library);

        //Create an ArrayList containing the Artist Name, Track Title, Album Cover, Genre and Launch Year.
        ArrayList<TrackList> musicTrackList = new ArrayList<TrackList>();
        musicTrackList.add(new TrackList("Above & Beyond feat. Zoe Johnston", "We're All We Need",
                R.drawable.above_and_beyond_we_are_all_we_need, "Trance", "2015"));
        musicTrackList.add(new TrackList("Armin van Buuren", "Blue Fear",
                R.drawable.armin_van_buuren_blue_fear, "Trance", "1997"));
        musicTrackList.add(new TrackList("Deep Dish feat. Stevie Nicks", "Dreams",
                R.drawable.deep_dish_feat_stevie_nicks_dreams, "House", "2006"));
        musicTrackList.add(new TrackList("DJ Project", "Spune-mi tot ce vrei",
                R.drawable.dj_project_spune_mi_tot_ce_vrei, "Euro House", "2002"));
        musicTrackList.add(new TrackList("Faithless", "Salva Mea 2.0 (Above & Beyond Remix)",
                R.drawable.faithless_salva_mea_2_0_above_beyond_remix, "Progressive Trance", "2015"));
        musicTrackList.add(new TrackList("Faithless", "Insomnia (Blissy vs. Armand van Helden 2005 Rework)",
                R.drawable.faithless_insomnia_blissy_vs_armand_van_helden_2005_rework, "Trance", "2005"));
        musicTrackList.add(new TrackList("Gabriel & Dresden", "Dangerous Power",
                R.drawable.gabriel_and_dresden_dangerous_power, "Trance", "2006"));
        musicTrackList.add(new TrackList("Haito & Diringer", "Perception (Simon Baker Remix)",
                R.drawable.haito_and_diringer_perception_simon_baker_remix, "Tech House", "2008"));
        musicTrackList.add(new TrackList("John Digweed", "Gridlock (Digweed And Muir's Stereo Club Mix)",
                R.drawable.john_digweed_gridlock_digweed_and_muir_stereo_club_mix, "Tech House", "2007"));
        musicTrackList.add(new TrackList("Kings of Tomorrow feat. Elzi Hall", "Show Me",
                R.drawable.kings_of_tomorrow_feat_elzi_hall_show_me, "Deep House", "2012"));
        musicTrackList.add(new TrackList("Motorcycle", "As The Rush Comes (Armin van Buuren's Universal Religion Mix)",
                R.drawable.motorcycle_as_the_rush_comes_armin_van_buuren_universal_religion_mix, "Trance", "2007"));
        musicTrackList.add(new TrackList("Paul van Dyk  feat. Ashley Tomberlin", "New York City",
                R.drawable.paul_van_dyk_feat_ashley_tomberlin_new_york_city, "Trance", "2007"));
        musicTrackList.add(new TrackList("Perpetuous Dreamer", "Dust.wav (Armin Van Buuren Rising Star Remix)",
                R.drawable.perpetuous_dreamer_dust_wav_armin_van_buuren_rising_star_remix, "Trance", "2003"));
        musicTrackList.add(new TrackList("Rank 1", "Airwave",
                R.drawable.rank_1_airwave, "Trance", "1999"));
        musicTrackList.add(new TrackList("Sunlounger", "Another Day On The Terrace (Intro Club Mix)",
                R.drawable.sunlounger_another_day_on_the_terrace_intro_club_mix, "Trance", "2007"));
        musicTrackList.add(new TrackList("The Thrillseekers vs. Sam Mitcham", "All The Little Things",
                R.drawable.the_thrillseekers_vs_sam_mitcham_all_the_little_things, "Trance", "2014"));
        musicTrackList.add(new TrackList("Tiesto", "A Tear in the Open",
                R.drawable.tiesto_a_tear_in_the_open, "Progressive Trance", "2005"));
        musicTrackList.add(new TrackList("Tiesto", "Adagio For Strings",
                R.drawable.tiesto_adagio_for_strings, "Trance", "2005"));
        musicTrackList.add(new TrackList("Underher feat. Marton Harvest", "Time",
                R.drawable.underher_feat_marton_harvest_time, "Deep House", "2017"));
        musicTrackList.add(new TrackList("Zaki feat. Joseph Chisanga", "Dancing With The Clouds",
                R.drawable.zaki_feat_joseph_chisanga_dancing_with_the_clouds, "Deep House", "2017"));

        //Create a TrackListAdapter whose data source is a musicTrackList ArrayList.
        TrackListAdapter adapter = new TrackListAdapter(this, musicTrackList);
        final ListView musicLibraryListView = findViewById(R.id.musicLibraryListView);
        // Make the musicLibraryListView use the TrackListAdapter created above, so that the
        // ListView will display list items for each TrackList in the list.
        musicLibraryListView.setAdapter(adapter);

        //onItemClickListener used to get the position of the item clicked in the ListView
        //and use it to pass the correct information in the Track Details activity.
        musicLibraryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TrackList trackList = (TrackList) musicLibraryListView.getItemAtPosition(position);
                Intent openTrackDetails = new Intent(MusicLibrary.this, TrackDetails.class);
                openTrackDetails.putExtra("ARTISTNAME", trackList.getArtistName());
                openTrackDetails.putExtra("TRACKTITLE", trackList.getTrackTitle());
                openTrackDetails.putExtra("ALBUMCOVER", trackList.getAlbumCover());
                openTrackDetails.putExtra("GENRE", trackList.getGenre());
                openTrackDetails.putExtra("LAUNCHYEAR", trackList.getLaunchYear());
                startActivity(openTrackDetails);
            }
        });
    }
}