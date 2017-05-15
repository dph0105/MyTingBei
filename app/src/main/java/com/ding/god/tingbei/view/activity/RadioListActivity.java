package com.ding.god.tingbei.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseActivity;
import com.ding.god.tingbei.base.PlayBarBaseActivity;
import com.ding.god.tingbei.customview.PlayBar;
import com.ding.god.tingbei.model.bean.RadioBean;
import com.ding.god.tingbei.presenter.RadioListPresenter;
import com.ding.god.tingbei.view.adapter.RVChoicenessItemLiveRadioAdapter;
import com.ding.god.tingbei.view.iview.IRadioListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RadioListActivity extends PlayBarBaseActivity<RadioListPresenter> implements IRadioListView {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_radiolist_top_title)
    TextView tvRadiolistTopTitle;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.rv_activity_radio_list)
    RecyclerView rvActivityRadioList;
    @BindView(R.id.activity_radio_list)
    LinearLayout activityRadioList;
    @BindView(R.id.xrv)
    XRefreshView xrv;
    private RVChoicenessItemLiveRadioAdapter adapter;
    private String category_id;
    private String category_name;
    private int localOrCountry;
    private int page = 1;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_radio_list;
    }

    @Override
    protected void initpresenter() {
        presenter = new RadioListPresenter(mContext, this);
        presenter.init();
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        localOrCountry = intent.getIntExtra("localOrCountry",0);
        category_id = intent.getStringExtra("category_id");
        category_name = intent.getStringExtra("category_name");
        tvRadiolistTopTitle.setText(category_name);

        xrv.setPullRefreshEnable(false);
        xrv.setPullLoadEnable(true);
        rvActivityRadioList.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new RVChoicenessItemLiveRadioAdapter(mContext);
        rvActivityRadioList.setAdapter(adapter);
    }

    @Override
    public void initData() {
        presenter.initData(category_id, page,localOrCountry);
    }

    @Override
    public void bindListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        xrv.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onLoadMore(boolean isSilence) {
                page++;
                initData();
            }
        });
    }


    @Override
    public void addData(List<RadioBean> datas) {
        adapter.addAll(datas);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                xrv.stopLoadMore();
            }
        },500);
        if(datas.size()<20) {
            xrv.setLoadComplete(true);
        }
    }
}
