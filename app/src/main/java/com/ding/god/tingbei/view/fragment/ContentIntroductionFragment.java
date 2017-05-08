package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentIntroductionFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_content_introduction;
    }

    public static ContentIntroductionFragment newInstance() {
        Bundle args = new Bundle();
        ContentIntroductionFragment fragment = new ContentIntroductionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void initView() {
        Log.d("fragment","ContentIntroduction");
    }

    @Override
    public void initData() {

    }

    @Override
    public void bindListener() {

    }
}
