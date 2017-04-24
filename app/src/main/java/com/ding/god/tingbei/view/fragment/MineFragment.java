package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;


public class MineFragment extends BaseFragment {


    public MineFragment() {
    }

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initPresenter() {

    }
}
