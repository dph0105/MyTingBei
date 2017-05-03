package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.presenter.SearchResultPresenter;
import com.ding.god.tingbei.view.adapter.VPSearchResultAdapter;
import com.ding.god.tingbei.view.iview.ISearchResultView;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultFragment extends BaseFragment<SearchResultPresenter> implements ISearchResultView {


    @BindView(R.id.tablayout_fragment_search_result)
    TabLayout tablayoutFragmentSearchResult;
    @BindView(R.id.vp_fragment_search_result)
    ViewPager vpFragmentSearchResult;

    public SearchResultFragment() {
        // Required empty public constructor
    }

    public static SearchResultFragment newInstance() {

        Bundle args = new Bundle();
        SearchResultFragment fragment = new SearchResultFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_result;
    }

    @Override
    protected void initPresenter() {
        presenter = new SearchResultPresenter(mContext, this);
        presenter.init();
    }

    @Override
    public void initView() {
       presenter.setVPAdapter();
    }

    @Override
    public void initData() {

    }

    @Override
    public void bindListener() {

    }


    @Override
    public void setVPAdapter(List<BaseFragment> fragments, String[] tabTitle) {
        VPSearchResultAdapter adapter = new VPSearchResultAdapter(getFragmentManager(),fragments,tabTitle);
        vpFragmentSearchResult.setAdapter(adapter);
        tablayoutFragmentSearchResult.setupWithViewPager(vpFragmentSearchResult);
    }
}
