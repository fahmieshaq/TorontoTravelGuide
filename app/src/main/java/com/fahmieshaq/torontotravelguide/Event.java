package com.fahmieshaq.torontotravelguide;

public class Event {

    private int mImageResourceId;
    private int mTitle;
    private int mAddress;
    private int mCity;
    private int mPhone;
    private int mEmail;
    private int mWebsite;

    public Event(int imageResourceId, int title, int address,
                 int city, int phone, int email, int website) {
        mImageResourceId = imageResourceId;
        mTitle = title;
        mAddress = address;
        mCity = city;
        mPhone = phone;
        mEmail = email;
        mWebsite = website;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getTitle() {
        return mTitle;
    }

    public int getAddress() {
        return mAddress;
    }

    public int getCity() {
        return mCity;
    }

    public int getPhone() {
        return mPhone;
    }

    public int getEmail() {
        return mEmail;
    }

    public int getWebsite() {
        return mWebsite;
    }

}
