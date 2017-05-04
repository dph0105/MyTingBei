package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.SearchHistoryModel;
import com.ding.god.tingbei.model.SearchModel;
import com.ding.god.tingbei.view.iview.ISearchHistoryView;

/**
 * Created by Administrator on 2017/5/4.
 */

public class SearchHistoryPresenter extends BasePresenter<SearchHistoryModel,ISearchHistoryView> {
    public SearchHistoryPresenter(Context context, ISearchHistoryView mView) {
        super(context, mView);
        mModel = new SearchHistoryModel();
    }
}
