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
public class AttractionFragment extends Fragment
{
    public AttractionFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations =  new ArrayList<>();

        locations.add(new Location(getString(R.string.opera_house_name),getString(R.string.opera_house_description), getString(R.string.opera_house_address), R.drawable.opera_house));
        locations.add(new Location(getString(R.string.harbour_bridge_name), getString(R.string.harbour_bridge_description), getString(R.string.harbour_bridge_address), R.drawable.harbour_bridge));
        locations.add(new Location(getString(R.string.darling_harbour_name), getString(R.string.darling_harbour_description), getString(R.string.darling_harbour_address), R.drawable.darling_harbour));
        locations.add(new Location(getString(R.string.town_hall_name), getString(R.string.town_hall_description), getString(R.string.town_hall_address), R.drawable.town_hall));
        locations.add(new Location(getString(R.string.qvb_building_name), getString(R.string.qvb_building_description),getString(R.string.qvb_building_address), R.drawable.qvb_building));
        locations.add(new Location(getString(R.string.bondi_beach_name), getString(R.string.bondi_beach_description), getString(R.string.bondi_beach_address), R.drawable.bondi_beach));
        locations.add(new Location(getString(R.string.taronga_zoo_name), getString(R.string.taronga_zoo_description), getString(R.string.taronga_zoo_address), R.drawable.taronga_zoo));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorAttractionBG);

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
