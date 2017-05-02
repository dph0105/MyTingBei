package com.ding.god.tingbei.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.PlayBarBaseActivity;
import com.ding.god.tingbei.presenter.SearchPresenter;
import com.ding.god.tingbei.view.fragment.SearchHistoryFragment;
import com.ding.god.tingbei.view.fragment.SearchResultFragment;
import com.ding.god.tingbei.view.iview.ISearchView;

import butterknife.BindView;

public class SearchActivity extends PlayBarBaseActivity<SearchPresenter> implements ISearchView {


    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.rl_searchBar)
    RelativeLayout rlSearchBar;
    @BindView(R.id.ll_nothing)
    LinearLayout llNothing;
    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.activity_search)
    RelativeLayout activitySearch;

    private FragmentManager fm;
    private FragmentTransaction ft;
    private SearchHistoryFragment searchHistoryFragment;
    private SearchResultFragment searchResultFragment;
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
        presenter.getSearchHistory();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        searchHistoryFragment = SearchHistoryFragment.newInstance();
        searchResultFragment = SearchResultFragment.newInstance();
        ft.add(R.id.fl_container,searchHistoryFragment);
        ft.add(R.id.fl_container, searchResultFragment);
        ft.commit();
    }

    @Override
    public void initData() {

    }

    @Override
    public void bindListener() {
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (KeyEvent.KEYCODE_ENTER == keyCode && KeyEvent.ACTION_DOWN == event.getAction()) {
                    //处理事件
                    presenter.saveSearchHistory(etSearch.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void showNothing() {
        llNothing.setVisibility(View.VISIBLE);
        flContainer.setVisibility(View.GONE);
    }

    @Override
    public void showHistory() {
        llNothing.setVisibility(View.GONE);
        flContainer.setVisibility(View.VISIBLE);
//        ft = fm.beginTransaction();
//        ft.hide(searchResultFragment);
//        ft.show(searchHistoryFragment);
//        ft.commit();
    }

    @Override
    public void showResult() {
        llNothing.setVisibility(View.GONE);
        flContainer.setVisibility(View.VISIBLE);
//        ft = fm.beginTransaction();
//        ft.hide(searchHistoryFragment);
//        ft.show(searchResultFragment);
//        ft.commit();
    }

}
