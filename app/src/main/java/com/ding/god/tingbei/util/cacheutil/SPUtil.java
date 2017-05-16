package com.ding.god.tingbei.util.cacheutil;

import android.content.Context;
import android.content.SharedPreferences;

import static android.R.attr.value;

/**
 * Created by Administrator on 2017/5/16.
 */

public class SPUtil {

    public static final String SP_NAME = "tingbei";

    /**
     * 储存boolean
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context,String key,boolean value){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).apply();
    }

    /**
     * 获得boolean
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }


    /**
     * 储存int
     * @param context
     * @param key
     * @param value
     */
    public static void putInt(Context context,String key,int value){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).apply();
    }

    /**
     * 获得int
     * @param context
     * @param key
     * @return
     */
    public static int getInt(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key,-1);
    }

    /**
     * 储存String
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context,String key,String value){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).apply();
    }

    /**
     * 获得String
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getString(key,null);
    }

}
