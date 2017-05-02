package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchHistoryFragment extends BaseFragment {


    public SearchHistoryFragment() {
        // Required empty public constructor
    }

    public static SearchHistoryFragment newInstance() {

        Bundle args = new Bundle();

        SearchHistoryFragment fragment = new SearchHistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_history;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void bindListener() {

    }
}
