package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;


public class SortFragment extends BaseFragment {


    public SortFragment() {
    }

    public static SortFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SortFragment fragment = new SortFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sort;
    }

    @Override
    protected void initPresenter() {

    }
    

}
