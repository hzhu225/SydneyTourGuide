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

        locations.add(new Location(getString(R.string.luna_park_name), getString(R.string.luna_park_description), getString(R.string.luna_park_address), R.drawable.luna_park));
        locations.add(new Location(getString(R.string.darling_quarter_name), getString(R.string.darling_quarter_description), getString(R.string.darling_quarter_address), R.drawable.darling_quarter));
        locations.add(new Location(getString(R.string.the_star_name), getString(R.string.the_star_description), getString(R.string.the_star_address), R.drawable.the_star));
        locations.add(new Location(getString(R.string.event_cinemas_name), getString(R.string.event_cinemas_description), getString(R.string.event_cinemas_address), R.drawable.event_cinemas));
        locations.add(new Location(getString(R.string.sky_zone_name), getString(R.string.sky_zone_description), getString(R.string.sky_zone_address), R.drawable.sky_zone));
        locations.add(new Location(getString(R.string.indoor_climbing_gym_name), getString(R.string.indoor_climbing_gym_description), getString(R.string.indoor_climbing_gym_address), R.drawable.indoor_climbing_gym));
        locations.add(new Location(getString(R.string.wet_n_wild_name), getString(R.string.wet_n_wild_description), getString(R.string.wet_n_wild_address), R.drawable.wet_n_wild));


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
