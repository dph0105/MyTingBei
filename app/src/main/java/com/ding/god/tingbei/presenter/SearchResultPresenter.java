package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.SearchResultModel;
import com.ding.god.tingbei.view.iview.ISearchResultView;

/**
 * Created by god on 2017/5/2.
 */

public class SearchResultPresenter extends BasePresenter<SearchResultModel,ISearchResultView> {
    public SearchResultPresenter(Context context, ISearchResultView mView) {
        super(context, mView);
        mModel = new SearchResultModel();
    }

    public void initData(String searchName,int type){

    }

    public void setVPAdapter(){
        mView.setVPAdapter(mModel.getFragments(),mModel.getTabTitle());
    }
}
