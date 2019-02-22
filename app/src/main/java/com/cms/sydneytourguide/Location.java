package com.cms.sydneytourguide;

public class Location
{
    private String mLocationName;
    private String mAddress;
    private String mDescription;
    private int mImageResourceId;

    public Location (String locationName, String address, String description, int imageResourceId)
    {
        mLocationName = locationName;
        mAddress = address;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public String getLocationName()
    {
        return mLocationName;
    }

    public String getAddress()
    {
        return mAddress;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public int getImageResourceId()
    {
        return mImageResourceId;
    }



}
