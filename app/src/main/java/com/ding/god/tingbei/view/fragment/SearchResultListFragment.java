package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.andview.refreshview.XRefreshView;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.model.bean.SearchResultAllBean;
import com.ding.god.tingbei.model.bean.SearchResultTypeBean;
import com.ding.god.tingbei.presenter.SearchResultListPresenter;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.SearchEvent;
import com.ding.god.tingbei.view.adapter.RVSearchAllAdapter;
import com.ding.god.tingbei.view.adapter.RVSearchTypeAdatper;
import com.ding.god.tingbei.view.iview.ISearchResultListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultListFragment extends BaseFragment<SearchResultListPresenter> implements ISearchResultListView {


    @BindView(R.id.rv_fragment_search_list)
    RecyclerView rvFragmentSearchList;
    @BindView(R.id.rl_nothing)
    RelativeLayout rlNothing;
    @BindView(R.id.xrv)
    XRefreshView xrv;

    private int type;
    private String searchName;

    private RVSearchAllAdapter allAdapter;
    private RVSearchTypeAdatper typeAdatper;

    public SearchResultListFragment() {
        // Required empty public constructor
    }

    public static SearchResultListFragment newInstance(int type) {

        Bundle args = new Bundle();
        args.putInt("type", type);
        SearchResultListFragment fragment = new SearchResultListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_result_list;
    }

    @Override
    protected void initPresenter() {
        presenter = new SearchResultListPresenter(mContext, this);
        presenter.init();
    }

    @Override
    public void initView() {
        type = getArguments().getInt("type");

        xrv.setPullRefreshEnable(false);
        if(type==0) {
            xrv.setLoadComplete(true);
        }else {
            xrv.setLoadComplete(false);
        }

        Log.d("type", "" + type);
        rvFragmentSearchList.setLayoutManager(new LinearLayoutManager(mContext));
        if (type == 0) {
            allAdapter = new RVSearchAllAdapter(mContext);
            rvFragmentSearchList.setAdapter(allAdapter);
        } else {
            typeAdatper = new RVSearchTypeAdatper(mContext);
            rvFragmentSearchList.setAdapter(typeAdatper);
        }
    }

    @Override
    public void initData() {
        RxBus.getRxBus().toFlowableSticky(SearchEvent.class)
                .compose(RxTransfromer.<SearchEvent>observeOnToMain())
                .subscribe(new Consumer<SearchEvent>() {
                    @Override
                    public void accept(@NonNull SearchEvent searchEvent) throws Exception {
                        searchName = searchEvent.getSearchName();
                        presenter.initData(searchEvent.getSearchName(), type);
                    }
                });

    }

    @Override
    public void bindListener() {

    }

    @Override
    public void addData(List<SearchResultAllBean> datas) {
        if (datas.size() == 0) {
            rlNothing.setVisibility(View.VISIBLE);
        } else {
            rlNothing.setVisibility(View.GONE);
            allAdapter.clearAll();
            allAdapter.addAll(datas);
        }

    }

    @Override
    public void addTypeData(List<SearchResultTypeBean> datas) {
        if (datas.size() == 0) {
            rlNothing.setVisibility(View.VISIBLE);
        } else {
            rlNothing.setVisibility(View.GONE);
            typeAdatper.clearAll();
            typeAdatper.addAll(datas);
        }
    }

}
