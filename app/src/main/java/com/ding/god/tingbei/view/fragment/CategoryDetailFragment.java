package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.customview.DividerItemDecoration;
import com.ding.god.tingbei.model.bean.RadioByTypeBean;
import com.ding.god.tingbei.presenter.CategoryDetailPresenter;
import com.ding.god.tingbei.util.DensityUtil;
import com.ding.god.tingbei.view.adapter.RVCategoryDetailAdapter;
import com.ding.god.tingbei.view.iview.ICategoryDetailView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryDetailFragment extends BaseFragment<CategoryDetailPresenter> implements ICategoryDetailView {


    @BindView(R.id.rv_fragment_category_detail)
    RecyclerView rvFragmentCategoryDetail;
    @BindView(R.id.xrv)
    XRefreshView xrv;
    private RVCategoryDetailAdapter rvCategoryDetailAdapter;
    private int page =1;
    private String category_id;
    private String category_type;
    public CategoryDetailFragment() {

    }

    public static CategoryDetailFragment newInstance(String category_id, String category_type) {
        Bundle args = new Bundle();
        args.putString("category_id", category_id);
        args.putString("category_type", category_type);
        CategoryDetailFragment fragment = new CategoryDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category_detail;
    }

    @Override
    protected void initPresenter() {
        presenter = new CategoryDetailPresenter(mContext, this);
        presenter.init();
    }

    @Override
    public void initView() {

        Bundle bundle = getArguments();
        category_id = bundle.getString("category_id");
        category_type = bundle.getString("category_type");

        xrv.setPullLoadEnable(true);

        rvFragmentCategoryDetail.setLayoutManager(new GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false));
        int dividerHeight = DensityUtil.dp2px(mContext, 10);
        rvFragmentCategoryDetail.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.BOTH_SET, dividerHeight, getResources().getColor(R.color.white)));
        rvCategoryDetailAdapter = new RVCategoryDetailAdapter(mContext);
        rvFragmentCategoryDetail.setAdapter(rvCategoryDetailAdapter);
    }

    @Override
    public void initData() {

        page=1;
        presenter.initData(category_id, category_type, page);
    }



    @Override
    public void bindListener() {
        xrv.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onRefresh(boolean isPullDown) {
                refresh();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xrv.stopRefresh();
                    }
                },500);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                loadMore();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xrv.stopLoadMore();
                    }
                },500);super.onLoadMore(isSilence);
            }
        });
    }

    @Override
    public void addData(List<RadioByTypeBean> datas) {
        if(datas.size()==0) {
            xrv.setLoadComplete(true);
        }
        rvCategoryDetailAdapter.addAll(datas);
    }

    @Override
    public void loadMore() {
        page++;
        presenter.initData(category_id, category_type, page);
    }

    @Override
    public void refresh() {
        xrv.setLoadComplete(false);
        rvCategoryDetailAdapter.clearAll();
        initData();
    }
}
