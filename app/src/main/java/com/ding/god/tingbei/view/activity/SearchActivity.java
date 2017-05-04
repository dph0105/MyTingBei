package com.ding.god.tingbei.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatEditText;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.PlayBarBaseActivity;
import com.ding.god.tingbei.dbbean.SearchHistory;
import com.ding.god.tingbei.presenter.SearchPresenter;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.event.SearchEvent;
import com.ding.god.tingbei.view.fragment.SearchHistoryFragment;
import com.ding.god.tingbei.view.fragment.SearchResultFragment;
import com.ding.god.tingbei.view.iview.ISearchView;

import butterknife.BindView;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class SearchActivity extends PlayBarBaseActivity<SearchPresenter> implements ISearchView {


    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.et_search)
    AppCompatEditText etSearch;
    @BindView(R.id.rl_searchBar)
    RelativeLayout rlSearchBar;
    @BindView(R.id.ll_nothing)
    LinearLayout llNothing;
    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.activity_search)
    RelativeLayout activitySearch;

    private FragmentManager fm;
    private SearchHistoryFragment historyFragment;
    private SearchResultFragment resultFragment;

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
        fm = getSupportFragmentManager();
        historyFragment = SearchHistoryFragment.newInstance();
        resultFragment = SearchResultFragment.newInstance();
        fm.beginTransaction().add(R.id.fl_container, resultFragment).commit();
        fm.beginTransaction().add(R.id.fl_container, historyFragment).commit();

        presenter.getSearchHistory();
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
                    if(etSearch.getText()!=null&&!etSearch.getText().toString().equals("")) {
                        SearchHistory searchHistory = new SearchHistory(null, etSearch.getText().toString());
                        presenter.saveSearchHistory(searchHistory);
                        showResult(etSearch.getText().toString());
                        SearchEvent searchEvent = new SearchEvent(etSearch.getText().toString());
                        RxBus.getRxBus().post(searchEvent);
                    }
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void showNothing() {
        llNothing.setVisibility(View.VISIBLE);
    }

    @Override
    public void showHistory() {
        llNothing.setVisibility(View.GONE);

        fm.beginTransaction().show(historyFragment).commit();
        //fm.beginTransaction().hide(resultFragment).commit();
    }

    @Override
    public void showResult(String searchName) {
        llNothing.setVisibility(View.GONE);
        fm.beginTransaction().hide(historyFragment).commit();
        fm.beginTransaction().show(resultFragment).commit();
    }


}
