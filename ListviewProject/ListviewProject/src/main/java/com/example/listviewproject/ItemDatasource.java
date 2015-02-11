package com.example.listviewproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kavitha on 12/29/13.
 */
public class ItemDatasource
{
    public static List<String> mList = new ArrayList<String>();

    public ItemDatasource()
    {

    }

    public void setString(String str)
    {
        mList.add(str);
    }

    public String getString(int position)
    {
        return mList.get(position);
    }

    public List<String> getAllList()
    {
        return mList;
    }

    public int getSize()
    {
        return mList.size();
    }


}
