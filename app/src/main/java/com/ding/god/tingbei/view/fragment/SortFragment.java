package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.customview.DividerItemDecoration;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.presenter.SortPresenter;
import com.ding.god.tingbei.util.DensityUtil;
import com.ding.god.tingbei.view.adapter.RVSortAdapter;
import com.ding.god.tingbei.view.iview.ISortView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SortFragment extends BaseFragment<SortPresenter> implements ISortView{


    @BindView(R.id.rv_fragment_sort)
    RecyclerView rvFragmentSort;
    @BindView(R.id.xrv)
    XRefreshView xrv;
    private RVSortAdapter sortAdapter;
    public SortFragment() {
    }

    public static SortFragment newInstance() {
        Bundle args = new Bundle();
        SortFragment fragment = new SortFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sort;
    }

    @Override
    protected void initPresenter() {
        presenter = new SortPresenter(mContext,this);
        presenter.init();
    }



    @Override
    public void initView() {
        xrv.setLoadComplete(true);

        rvFragmentSort.setLayoutManager(new LinearLayoutManager(mContext));
        sortAdapter = new RVSortAdapter(mContext);
        rvFragmentSort.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.HORIZONTAL_LINE, DensityUtil.dp2px(mContext,10),mContext.getResources().getColor(R.color.bg_gray_f5f5f6)));
        rvFragmentSort.setAdapter(sortAdapter);
    }

    @Override
    public void initData() {
        presenter.initData();
    }

    @Override
    public void bindListener() {
        xrv.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                presenter.refresh();
            }
        });
    }

    @Override
    public void refreshComplete() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                xrv.stopRefresh();
            }
        },1000);
    }

    @Override
    public void addData(List<RadioTypeBean> datas) {
        sortAdapter.addAll(datas);
    }

    @Override
    public void clear() {
        sortAdapter.clearAll();
    }
}
