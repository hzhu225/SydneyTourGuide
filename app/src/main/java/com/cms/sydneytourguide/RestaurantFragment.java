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

        locations.add(new Location("Quay Restaurant Sydney", "One of Australia's most celebrated restaurants", "Overseas Passenger Terminal, The Rocks", R.drawable.quay_restaurant));
        locations.add(new Location("Pancakes On The Rocks", "Renowned around the world for its famous buttermilk pancakes", "4 Hickson Rd, The Rocks", R.drawable.pancakes_on_the_rocks));
        locations.add(new Location("Hurricane's Grill", "A vibrant, modern and delicious steakhouse", "433-436 Darling Dr, Sydney", R.drawable.hurricanes_grill));
        locations.add(new Location("Chefs Gallery", "A multi-award winning Chinese restaurant", "Shop 12/501 George St, Sydney", R.drawable.chefs_gallery));
        locations.add(new Location("Chat Thai", "A high-rated traditional Thai food restaurant", "L05/1 Macquarie Pl, Sydney", R.drawable.chat_thai));
        locations.add(new Location("678 Korean BBQ", "Korean BBQ with great taste and good quality", "Level 1/396 Pitt St, Haymarket", R.drawable.korean_bbq));
        locations.add(new Location("YAYOI", "A Japanese chain restaurant which serves Teishoku", "500 George St, Sydney", R.drawable.yayoi));


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
