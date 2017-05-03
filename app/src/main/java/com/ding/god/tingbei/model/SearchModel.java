package com.ding.god.tingbei.model;

import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.base.BaseModel;
import com.ding.god.tingbei.dbbean.SearchHistory;
import com.ding.god.tingbei.gen.SearchHistoryDao;

import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */

public class SearchModel extends BaseModel {

    private SearchHistoryDao mSearchHistoryDao;

    public SearchModel() {
        mSearchHistoryDao = MyApplication.getInstance().getDaoSession().getSearchHistoryDao();
    }

    public List<SearchHistory> getSearchHistory(){
        List<SearchHistory> searchHistories = mSearchHistoryDao.loadAll();
        return searchHistories;
    }

    public void saveSearchHistory(SearchHistory searchHistory){
        mSearchHistoryDao.insert(searchHistory);
    }

}
