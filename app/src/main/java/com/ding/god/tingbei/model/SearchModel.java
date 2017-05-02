package com.ding.god.tingbei.model;

import android.content.Context;

import com.ding.god.tingbei.base.BaseModel;
import com.ding.god.tingbei.util.cacheutil.CacheUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/28.
 */

public class SearchModel extends BaseModel {

    private static final String SEARCH_HISTORY = "searchHistory";

    public ArrayList<String> getSearchHistory(Context mContext){
        ArrayList<String> strings = CacheUtil.getStringArray(mContext, SEARCH_HISTORY);
        return strings;
    }

    public void saveSearchHistory(Context mContext,String searchName){
        ArrayList<String> strings = CacheUtil.getStringArray(mContext, SEARCH_HISTORY);
        strings.add(searchName);
        CacheUtil.postStringArray(mContext,SEARCH_HISTORY,strings);
    }

}
