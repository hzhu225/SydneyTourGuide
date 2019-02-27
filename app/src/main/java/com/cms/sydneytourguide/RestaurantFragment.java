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
public class RestaurantFragment extends Fragment
{


    public RestaurantFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations =  new ArrayList<>();

        locations.add(new Location(getString(R.string.quay_restaurant_name), getString(R.string.quay_restaurant_description), getString(R.string.quay_restaurant_address), R.drawable.quay_restaurant));
        locations.add(new Location(getString(R.string.pancakes_on_the_rocks_name), getString(R.string.pancakes_on_the_rocks_description), getString(R.string.pancakes_on_the_rocks_address), R.drawable.pancakes_on_the_rocks));
        locations.add(new Location(getString(R.string.hurricanes_grill_name), getString(R.string.hurricanes_grill_description), getString(R.string.hurricanes_grill_address), R.drawable.hurricanes_grill));
        locations.add(new Location(getString(R.string.chefs_gallery_name), getString(R.string.chefs_gallery_description), getString(R.string.chefs_gallery_address), R.drawable.chefs_gallery));
        locations.add(new Location(getString(R.string.chat_thai_name), getString(R.string.chat_thai_description), getString(R.string.chat_thai_address), R.drawable.chat_thai));
        locations.add(new Location(getString(R.string.korean_bbq_name), getString(R.string.korean_bbq_description), getString(R.string.korean_bbq_address), R.drawable.korean_bbq));
        locations.add(new Location(getString(R.string.yayoi_name), getString(R.string.yayoi_description), getString(R.string.yayoi_address), R.drawable.yayoi));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorRestaurantBG);

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
