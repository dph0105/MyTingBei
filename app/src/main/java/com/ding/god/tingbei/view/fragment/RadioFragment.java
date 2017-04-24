package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;

public class RadioFragment extends BaseFragment {


    public RadioFragment() {
    }


    public static RadioFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RadioFragment fragment = new RadioFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_radio;
    }

    @Override
    protected void initPresenter() {

    }


}
