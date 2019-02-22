package com.cms.sydneytourguide;

public class Location
{
    private String mLocationName;
    private String mAddress;
    private String mDescription;
    private int mImageResourceId;

    public Location (String locationName, String description, String address, int imageResourceId)
    {
        mLocationName = locationName;
        mDescription = description;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    public String getLocationName()
    {
        return mLocationName;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public String getAddress()
    {
        return mAddress;
    }

    public int getImageResourceId()
    {
        return mImageResourceId;
    }



}
