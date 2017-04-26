package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.model.bean.RadioCategoryBean;
import com.ding.god.tingbei.model.bean.RadioGroupBean;
import com.ding.god.tingbei.presenter.RadioPresenter;
import com.ding.god.tingbei.view.adapter.RVRadioCategoryAdapter;
import com.ding.god.tingbei.view.adapter.RVRadioGroupAdapter;
import com.ding.god.tingbei.view.iview.IRadioView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RadioFragment extends BaseFragment<RadioPresenter> implements IRadioView {


    @BindView(R.id.tv_radio_local)
    TextView tvRadioLocal;
    @BindView(R.id.tv_radio_country)
    TextView tvRadioCountry;
    @BindView(R.id.tv_radio_province_city)
    TextView tvRadioProvinceCity;
    @BindView(R.id.tv_radio_net)
    TextView tvRadioNet;
    @BindView(R.id.rv_radio_category)
    RecyclerView rvRadioCategory;
    @BindView(R.id.rv_fragment_radio)
    RecyclerView rvFragmentRadio;
    @BindView(R.id.xrv)
    XRefreshView xrv;


    private  RVRadioCategoryAdapter categoryAdapter;
    private RVRadioGroupAdapter groupAdapter;
    public RadioFragment() {
    }


    public static RadioFragment newInstance() {

        Bundle args = new Bundle();
        RadioFragment fragment = new RadioFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_radio;
    }


    //初始化presenter
    @Override
    protected void initPresenter() {
        presenter = new RadioPresenter(mContext, this);
        presenter.init();
    }


    @Override
    public void initView() {
        xrv.setLoadComplete(true);
        xrv.setPinnedTime(1000);
        //设置电台分类的recyclerview
        rvRadioCategory.setLayoutManager(new GridLayoutManager(mContext, 4));
        categoryAdapter = new RVRadioCategoryAdapter(mContext);
        rvRadioCategory.setAdapter(categoryAdapter);

        //设置具体电台的recyclerview
        rvFragmentRadio.setLayoutManager(new LinearLayoutManager(mContext));
        groupAdapter = new RVRadioGroupAdapter(mContext);
        rvFragmentRadio.setAdapter(groupAdapter);
    }

    @Override
    public void initData() {
        presenter.initData();
    }

    @Override
    public void bindListener() {

    }


    @Override
    public void addCategoryData(List<RadioCategoryBean.StyleBean> datas) {
        categoryAdapter.addAll(datas);
    }

    @Override
    public void addRadioGroupData(RadioGroupBean data) {
        groupAdapter.add(data);
    }
}
