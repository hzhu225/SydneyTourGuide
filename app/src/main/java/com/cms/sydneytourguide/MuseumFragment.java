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
import android.widget.TextView;

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

        locations.add(new Location("Art Gallery of NSW", "The most important public gallery in Sydney", "Art Gallery Rd, Sydney", R.drawable.art_gallery_nsw));
        locations.add(new Location("Australian Museum", "Animals, dinosaurs, mummies, aboriginal peoples, geology, insects", "1 William St, Sydney", R.drawable.australian_museum));
        locations.add(new Location("Australian National Maritime Museum","Australia's maritime history and the nation's ongoing involvement", "2 Murray St, Sydney", R.drawable.maritime_museum));
        locations.add(new Location("Government House", "Official residence of the Governor of New South Wales", "Royal Botanic Gardens, Sydney", R.drawable.government_house));
        locations.add(new Location("Museum of Sydney", "City's history and culture", "Bridge St & Phillip St, Sydney", R.drawable.museum_sydney));
        locations.add(new Location("Powerhouse Museum", "Science and technology including computers, steam power and transport", "500 Harris St, Ultimo", R.drawable.powerhouse_museum));
        locations.add(new Location("Hyde Park Barracks", "Australia's convict system, daily lives of convicts and other occupants", "12 Macquarie Street, Sydney", R.drawable.hyde_park_barracks));

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
