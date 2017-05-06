package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.presenter.ProgramListPresenter;
import com.ding.god.tingbei.view.iview.IProgramListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramListFragment extends BaseFragment<ProgramListPresenter> implements IProgramListView{


    public ProgramListFragment() {
        // Required empty public constructor
    }
    public static ProgramListFragment newInstance() {
        Bundle args = new Bundle();
        ProgramListFragment fragment = new ProgramListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_program_list;
    }

    @Override
    protected void initPresenter() {
        presenter = new ProgramListPresenter(mContext,this);
        presenter.init();
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
