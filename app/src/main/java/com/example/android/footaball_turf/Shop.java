package com.example.android.footaball_turf;

public class Shop {
    private String mName;

    private String mDetail;

    private int mshopimage;


    public Shop(String name, String detail,int shopimage) {
        mName = name;
        mDetail = detail;
        mshopimage=shopimage;
    }


    public String getmName()
    {
        return mName;
    }

    public String getmDetail()
    {
        return  mDetail;
    }

    public int getimage()
    {
        return  mshopimage;
    }
}

