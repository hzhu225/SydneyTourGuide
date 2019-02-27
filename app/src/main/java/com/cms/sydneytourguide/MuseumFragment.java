package com.cms.sydneytourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumFragment extends Fragment
{


    public MuseumFragment()
    {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations =  new ArrayList<>();

        locations.add(new Location(getString(R.string.art_gallery_nsw_name), getString(R.string.art_gallery_nsw_description), getString(R.string.art_gallery_nsw_address), R.drawable.art_gallery_nsw));
        locations.add(new Location(getString(R.string.australian_museum_name), getString(R.string.australian_museum_description), getString(R.string.australian_museum_address), R.drawable.australian_museum));
        locations.add(new Location(getString(R.string.maritime_museum_name),getString(R.string.maritime_museum_description), getString(R.string.maritime_museum_address), R.drawable.maritime_museum));
        locations.add(new Location(getString(R.string.government_house_name), getString(R.string.government_house_description), getString(R.string.government_house_address), R.drawable.government_house));
        locations.add(new Location(getString(R.string.museum_sydney_name), getString(R.string.museum_sydney_description), getString(R.string.museum_sydney_address), R.drawable.museum_sydney));
        locations.add(new Location(getString(R.string.powerhouse_museum_name), getString(R.string.powerhouse_museum_description), getString(R.string.powerhouse_museum_address), R.drawable.powerhouse_museum));
        locations.add(new Location(getString(R.string.hyde_park_barracks_name), getString(R.string.hyde_park_barracks_description), getString(R.string.hyde_park_barracks_address), R.drawable.hyde_park_barracks));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorMuseumBG);

        ListView listView = rootView.findViewById(R.id.location_listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Location location = locations.get(position);
                //start google map navigation
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + location.getAddress() + " NSW"));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
