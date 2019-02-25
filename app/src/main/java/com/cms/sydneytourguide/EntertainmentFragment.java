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
public class EntertainmentFragment extends Fragment
{


    public EntertainmentFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations =  new ArrayList<>();

        locations.add(new Location("Luna Park Sydney", "Sydney's most iconic amusement park", "1 Olympic Dr, Milsons Point", R.drawable.luna_park));
        locations.add(new Location("Darling Quarter", "Modern entertainment & leisure precinct with a kids' playground", "1-25 Harbour St, Sydney", R.drawable.darling_quarter));
        locations.add(new Location("The Star Sydney", "A famous world-class casino", "80 Pyrmont St, Pyrmont", R.drawable.the_star));
        locations.add(new Location("Event Cinemas George St", "Enjoy movies with the ultimate experience", "525 George St, Sydney", R.drawable.event_cinemas));
        locations.add(new Location("Sky Zone Alexandria", "An indoor playground with more than 100 interconnected trampolines", "75 O'Riordan St, Alexandria", R.drawable.sky_zone));
        locations.add(new Location("Sydney Indoor Climbing Gym", "The biggest climbing gym in Southern Hemisphere", "1-7 Unwins Bridge Road, St Peters", R.drawable.indoor_climbing_gym));
        locations.add(new Location("Wet'n'Wild Sydney", "Australia's biggest and best water park", "427 Reservoir Rd, Prospect", R.drawable.wet_n_wild));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorEntertainmentBG);

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
