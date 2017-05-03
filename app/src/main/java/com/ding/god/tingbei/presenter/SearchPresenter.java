package com.ding.god.tingbei.presenter;

import android.content.Context;
import android.util.Log;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.SearchModel;
import com.ding.god.tingbei.dbbean.SearchHistory;
import com.ding.god.tingbei.view.iview.ISearchView;

import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */

public class SearchPresenter extends BasePresenter<SearchModel,ISearchView> {


    public SearchPresenter(Context context, ISearchView mView) {
        super(context, mView);
        mModel = new SearchModel();

    }

    public void getSearchHistory(){
        List<SearchHistory> searchHistories = mModel.getSearchHistory();
        Log.d("size",searchHistories.size()+"");
        if (searchHistories.size() == 0) {
            mView.showNothing();
        }else {
            mView.showHistory();
        }
    }
    public void saveSearchHistory(SearchHistory searchHistory){
        mModel.saveSearchHistory(searchHistory);
    }


}
