package com.example.android.musicalstructure;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Florin on 14.03.2018.
 */

public class TrackListAdapter extends ArrayAdapter<TrackList>{

    public TrackListAdapter(Activity context, ArrayList<TrackList>musicTrackList){super(context, 0, musicTrackList);}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Tracklist object located at a certain position in the list.
        TrackList currentItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID artistNameTextView.
        TextView artistNameTextView = listItemView.findViewById(R.id.artistNameTextView);

        // Get the artistName from the current Tracklist object and
        // set this text on the artistName TextView.
        artistNameTextView.setText(currentItem.getArtistName());

        // Find the TextView in the list_item.xml layout with the ID trackTitleTextView.
        TextView trackTitleTextView = listItemView.findViewById(R.id.trackTitleTextView);

        // Get the trackTitle from the current Tracklist object and
        // set this text on the trackTitle TextView.
        trackTitleTextView.setText(currentItem.getTrackTitle());

        return listItemView;
    }
}
