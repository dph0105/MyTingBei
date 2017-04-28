package com.ding.god.tingbei.view.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.PlayBarBaseActivity;
import com.ding.god.tingbei.presenter.SearchPresenter;
import com.ding.god.tingbei.view.iview.ISearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends PlayBarBaseActivity<SearchPresenter> implements ISearchView {


    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.fl_container)
    FrameLayout flContainer;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_search;
    }

    @Override
    protected void initpresenter() {
        presenter = new SearchPresenter(mContext, this);
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
