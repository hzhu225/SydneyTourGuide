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
import android.widget.Toast;

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

        locations.add(new Location("Opera House", "A multi-venue performing arts centre at Sydney Harbour", "Bennelong Point, Sydney", R.drawable.opera_house));
        locations.add(new Location("Sydney Harbour Bridge", "A heritage-listed steel through arch bridge across Sydney Harbour", "Sydney Harbour Bridge, Sydney", R.drawable.harbour_bridge));
        locations.add(new Location("Darling Harbour", "A beautiful harbour adjacent to the city centre of Sydney", "Darling Harbour, Sydney", R.drawable.darling_harbour));
        locations.add(new Location("Town Hall", "A late 19th-century heritage-listed town hall building", "483 George St, Sydney", R.drawable.town_hall));
        locations.add(new Location("Queen Victoria Building", "A heritage-listed building and also a shopping mall","455 George St, Sydney", R.drawable.qvb_building));
        locations.add(new Location("Bondi Beach", "One of Australia’s most iconic beaches", "Campbell Parade, Bondi Beach", R.drawable.bondi_beach));
        locations.add(new Location("Taronga Zoo", "Come to see koalas, kangaroos and other wild animals!", "Bradleys Head Rd, Mosman", R.drawable.taronga_zoo));


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
