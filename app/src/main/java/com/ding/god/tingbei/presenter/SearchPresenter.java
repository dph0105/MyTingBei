package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.SearchModel;
import com.ding.god.tingbei.view.iview.ISearchView;

/**
 * Created by Administrator on 2017/4/28.
 */

public class SearchPresenter extends BasePresenter<SearchModel,ISearchView> {


    public SearchPresenter(Context context, ISearchView mView) {
        super(context, mView);
        mModel = new SearchModel();
    }


}
