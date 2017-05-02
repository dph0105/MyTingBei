package com.ding.god.tingbei.presenter;

import android.content.Context;
import android.util.Log;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.SearchModel;
import com.ding.god.tingbei.view.iview.ISearchView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/28.
 */

public class SearchPresenter extends BasePresenter<SearchModel,ISearchView> {


    public SearchPresenter(Context context, ISearchView mView) {
        super(context, mView);
        mModel = new SearchModel();
    }

    public void getSearchHistory(){
        ArrayList<String> strings = mModel.getSearchHistory(context);
        if (strings.size() == 0) {
            mView.showNothing();
        }else {
            Log.d("aaa",strings.size()+"");
            mView.showHistory();
        }
    }
    public void saveSearchHistory(String searchName){
        mModel.saveSearchHistory(context,searchName);
    }


}
