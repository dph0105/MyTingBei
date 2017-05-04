package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.presenter.SearchHistoryPresenter;
import com.ding.god.tingbei.view.iview.ISearchHistoryView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchHistoryFragment extends BaseFragment<SearchHistoryPresenter> implements ISearchHistoryView {


    @BindView(R.id.tv_clear_history)
    TextView tvClearHistory;
    @BindView(R.id.rv_fragment_search_history)
    RecyclerView rvFragmentSearchHistory;

    public SearchHistoryFragment() {

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
        presenter = new SearchHistoryPresenter(mContext, this);
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
        tvClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getInstance().getDaoSession().getSearchHistoryDao().deleteAll();
            }
        });
    }
}
