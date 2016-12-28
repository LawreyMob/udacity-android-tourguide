package com.lawrey.tourguide;

import java.io.Serializable;

/**
 * Created by Lawrey on 28/12/16.
 */

public class TGItem implements Serializable {

    private String mTitle;
    private String mDescription;
    private int mImageResourceID = NO_IMAGE_CONSTANT;

    private double latitude;
    private double longitude;

    private String url;

    private static final int NO_IMAGE_CONSTANT = -1;

    /* Constructors */

    public TGItem(String mTitle, String mDescription, int mImageResourceID) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mImageResourceID = mImageResourceID;
    }

    public TGItem(String mTitle, String mDescription, int mImageResourceID, double latitude, double longitude) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mImageResourceID = mImageResourceID;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public TGItem(String mTitle, String mDescription, int mImageResourceID, String url) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mImageResourceID = mImageResourceID;
        this.url = url;
    }

    /* Getters & Setters */

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getmImageResourceID() {
        return mImageResourceID;
    }

    public void setmImageResourceID(int mImageResourceID) {
        this.mImageResourceID = mImageResourceID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUrl() {
        return url;
    }

    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_CONSTANT;
    }
}
