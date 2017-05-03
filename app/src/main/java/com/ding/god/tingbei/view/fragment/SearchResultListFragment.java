package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static android.R.attr.type;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultListFragment extends BaseFragment<SearchResultListPresenter> implements ISearchResultListView {


    @BindView(R.id.rv_fragment_search_list)
    RecyclerView rvFragmentSearchList;

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
        int type = getArguments().getInt("type");
        rvFragmentSearchList.setLayoutManager(new LinearLayoutManager(mContext));
        if (type == 0) {
            allAdapter = new RVSearchAllAdapter(mContext);
            rvFragmentSearchList.setAdapter(allAdapter);
        }else {
            typeAdatper = new RVSearchTypeAdatper(mContext);
            rvFragmentSearchList.setAdapter(typeAdatper);
        }
    }

    @Override
    public void initData() {
        RxBus.getRxBus().toFlowable(SearchEvent.class)
                .compose(RxTransfromer.<SearchEvent>observeOnToMain())
                .subscribe(new Consumer<SearchEvent>() {
                    @Override
                    public void accept(@NonNull SearchEvent searchEvent) throws Exception {
                        searchName = searchEvent.getSearchName();
                        presenter.initData(searchEvent.getSearchName(),type);
                        Log.d("searchName",searchName);
                    }
                });

    }

    @Override
    public void bindListener() {

    }

    @Override
    public void addData(List<SearchResultAllBean> datas) {
        allAdapter.clearAll();
        allAdapter.addAll(datas);
    }

    @Override
    public void addTypeData(List<SearchResultTypeBean> datas) {
        typeAdatper.clearAll();
        typeAdatper.addAll(datas);
    }

}
