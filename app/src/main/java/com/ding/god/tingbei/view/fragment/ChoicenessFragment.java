package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.model.bean.ChoicenessBean;
import com.ding.god.tingbei.presenter.ChoicenessPresenter;
import com.ding.god.tingbei.view.adapter.ChoicenessRVAdapter;
import com.ding.god.tingbei.view.iview.IChoicenessView;

import butterknife.BindView;


public class ChoicenessFragment extends BaseFragment<ChoicenessPresenter> implements IChoicenessView {


    @BindView(R.id.swipe_target)
    RecyclerView recyclerView;
    @BindView(R.id.swipToLoadLayout)
    SwipeToLoadLayout swipToLoadLayout;
    private ChoicenessRVAdapter rvAdapter;


    public ChoicenessFragment() {

    }

    public static ChoicenessFragment newInstance() {
        Bundle args = new Bundle();
        ChoicenessFragment fragment = new ChoicenessFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_choiceness;
    }


    //初始化presenter
    @Override
    protected void initPresenter() {
        presenter = new ChoicenessPresenter(mContext,this);
        presenter.init();
    }

    //view的初始化处理
    @Override
    public void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        rvAdapter = new ChoicenessRVAdapter(mContext);
        recyclerView.setAdapter(rvAdapter);
    }

    @Override
    public void initData() {
        presenter.initData();
    }


    //在presenter中给viewpager添加数据的操作
    @Override
    public void addData(ChoicenessBean data) {
        rvAdapter.add(data);
    }


}