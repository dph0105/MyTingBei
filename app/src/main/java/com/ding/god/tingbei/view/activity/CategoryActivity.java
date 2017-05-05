package com.ding.god.tingbei.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.PlayBarBaseActivity;
import com.ding.god.tingbei.customview.DividerItemDecoration;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.presenter.CategoryPresenter;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.ClickEvent;
import com.ding.god.tingbei.util.DensityUtil;
import com.ding.god.tingbei.util.OnRecylerViewItemClickListener;
import com.ding.god.tingbei.view.adapter.RVCategoryPopupAdapter;
import com.ding.god.tingbei.view.adapter.VPCategoryAdapter;
import com.ding.god.tingbei.view.fragment.CategoryDetailFragment;
import com.ding.god.tingbei.view.iview.ICategoryView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

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
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;

    //popupwindow中的控件
    ImageView ivCategoryUp;
    RecyclerView rvCategory;

    private String category_id;
    private int position;
    private  PopupWindow popupWindow;
    private RVCategoryPopupAdapter rvCategoryPopupAdapter;

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
        position = intent.getIntExtra("position", 0);
        tvCategoryName.setText(categoryName);
        //设置tablayout
        tlActivityActegory.setTabMode(TabLayout.MODE_SCROLLABLE);
        tlActivityActegory.setSelectedTabIndicatorColor(getResources().getColor(R.color.red_indicator));
        tlActivityActegory.setTabTextColors(getResources().getColor(R.color.text_gray), getResources().getColor(R.color.red_indicator));
        //设置popupwindow
        setPopupWindow();


    }

    private void setPopupWindow() {
        final View popupView = LayoutInflater.from(mContext).inflate(R.layout.popupwindow_category_down, null);
        ivCategoryUp = (ImageView) popupView.findViewById(R.id.iv_category_up);
        rvCategory = (RecyclerView) popupView.findViewById(R.id.rv_popup_category);
         popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置点击popupWindow以外的地方,消失
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        //popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        ivCategoryUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        rvCategory.setLayoutManager(new GridLayoutManager(mContext,4));
        rvCategory.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.BOTH_SET, DensityUtil.dp2px(mContext,10),getResources().getColor(R.color.white)));
        rvCategoryPopupAdapter = new RVCategoryPopupAdapter(mContext);
        rvCategory.setAdapter(rvCategoryPopupAdapter);
        RxBus.getRxBus().toFlowable(ClickEvent.CategoryPopupClickEvent.class)
                .compose(RxTransfromer.<ClickEvent.CategoryPopupClickEvent>observeOnToMain())
                .subscribe(new Consumer<ClickEvent.CategoryPopupClickEvent>() {

                    @Override
                    public void accept(@NonNull ClickEvent.CategoryPopupClickEvent categoryPopupClickEvent) throws Exception {
                        if(vpActivityCategory!=null) {
                            vpActivityCategory.setCurrentItem(categoryPopupClickEvent.position);
                        }
                        popupWindow.dismiss();
                    }
                });


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
        ivCategoryDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<rvCategory.getChildCount();i++){
                    rvCategory.getChildAt(i).setSelected(i==vpActivityCategory.getCurrentItem());
                }
                popupWindow.showAsDropDown(rlTop);
            }
        });
    }

    @Override
    public void setAdapter(List<RadioTypeBean> datas) {
        List<CategoryDetailFragment> fragments = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            if (i == 0) {
                fragments.add(CategoryDetailFragment.newInstance(datas.get(i).getCategory_id(), "all"));
            } else {
                fragments.add(CategoryDetailFragment.newInstance(datas.get(i).getCategory_id(), "sub"));
            }
        }
        VPCategoryAdapter adapter = new VPCategoryAdapter(getSupportFragmentManager(), fragments, datas);
        vpActivityCategory.setAdapter(adapter);
        tlActivityActegory.setupWithViewPager(vpActivityCategory);
        vpActivityCategory.setCurrentItem(position);

        rvCategoryPopupAdapter.addAll(datas);
        rvCategoryPopupAdapter.setSelectPosition(position);
    }



}
