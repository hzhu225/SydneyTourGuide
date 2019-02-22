package com.cms.sydneytourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location>
{
    private int bgColor;
    public LocationAdapter(Context context, ArrayList<Location> resource, int color)
    {
        super(context,0, resource);
        bgColor = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);

        ImageView image = listItemView.findViewById(R.id.image);
        image.setImageResource(currentLocation.getImageResourceId());

        TextView nameTV = listItemView.findViewById(R.id.name_TV);
        nameTV.setText(currentLocation.getLocationName());

        TextView descriptionTV = listItemView.findViewById(R.id.description_TV);
        descriptionTV.setText(currentLocation.getDescription());

        TextView addressTV = listItemView.findViewById(R.id.address_TV);
        addressTV.setText(currentLocation.getAddress());

        View textContainer = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundResource(bgColor);

        return listItemView;
    }
}
