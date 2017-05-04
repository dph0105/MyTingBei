package com.ding.god.tingbei.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.PlayBarBaseActivity;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.presenter.CategoryPresenter;
import com.ding.god.tingbei.view.adapter.VPCategoryAdapter;
import com.ding.god.tingbei.view.fragment.CategoryDetailFragment;
import com.ding.god.tingbei.view.iview.ICategoryView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends PlayBarBaseActivity<CategoryPresenter> implements ICategoryView {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_category_name)
    TextView tvCategoryName;
    @BindView(R.id.iv_category_down)
    ImageView ivCategoryDown;
    @BindView(R.id.activity_category)
    LinearLayout activityCategory;
    @BindView(R.id.vp_activity_category)
    ViewPager vpActivityCategory;
    @BindView(R.id.tl_activity_actegory)
    TabLayout tlActivityActegory;

    private String category_id;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_category;
    }

    @Override
    protected void initpresenter() {
        presenter = new CategoryPresenter(mContext, this);
        presenter.init();
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("category_name");
        category_id = intent.getStringExtra("category_id");
        tvCategoryName.setText(categoryName);
        tlActivityActegory.setTabMode(TabLayout.MODE_SCROLLABLE);
        tlActivityActegory.setSelectedTabIndicatorColor(getResources().getColor(R.color.red_indicator));
        tlActivityActegory.setTabTextColors(getResources().getColor(R.color.text_gray),getResources().getColor(R.color.red_indicator));
    }

    @Override
    public void initData() {
        presenter.initData(category_id);
    }

    @Override
    public void bindListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void setAdapter(List<RadioTypeBean> datas) {
        List<CategoryDetailFragment> fragments = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            if(i==0) {
                fragments.add(CategoryDetailFragment.newInstance(datas.get(i).getCategory_id(),"all"));
            }else {
                fragments.add(CategoryDetailFragment.newInstance(datas.get(i).getCategory_id(),"sub"));
            }
        }
        VPCategoryAdapter adapter = new VPCategoryAdapter(getSupportFragmentManager(), fragments, datas);
        vpActivityCategory.setAdapter(adapter);
        tlActivityActegory.setupWithViewPager(vpActivityCategory);

    }



}
