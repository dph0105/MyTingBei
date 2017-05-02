package com.ding.god.tingbei.util.cacheutil;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


/**
 * Created by god on 2017/5/2.
 */

public class CacheUtil {
    public static void postStringArray(Context context,String name,ArrayList<String> strings){
        SharedPreferences sp = context.getSharedPreferences("TingBei",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        JSONArray jsonArray = new JSONArray();
        for(String s: strings){
            jsonArray.put(s);
        }
        editor.putString(name,jsonArray.toString());
        editor.apply();
        editor.putString(name,strings.toString());
        editor.apply();
    }

    public static ArrayList<String> getStringArray(Context context,String name) {
        SharedPreferences sp = context.getSharedPreferences("TingBei", Context.MODE_PRIVATE);
        sp.getString(name, null);
        JSONArray jsonArray = null;
        ArrayList<String> strings = new ArrayList<>();
        try {
            jsonArray = new JSONArray(sp.getString(name,"[]"));
            for (int i = 0; i < jsonArray.length(); i++) {
                strings.add(jsonArray.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
