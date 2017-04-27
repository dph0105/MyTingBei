package com.ding.god.tingbei.view.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.customview.CustomRV;
import com.ding.god.tingbei.customview.DividerItemDecoration;
import com.ding.god.tingbei.model.bean.RadioCategoryBean;
import com.ding.god.tingbei.model.bean.RadioGroupBean;
import com.ding.god.tingbei.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/26.
 */

public class RVRadioAdapter extends BaseRVAdapter<RadioGroupBean, RecyclerView.ViewHolder> {

    private static final int TYPE_RECOMMENT = 0;
    private static final int TYPE_LOCAL_MUSIC = 1;
    private static final int TYPE_MUSIC_RADIO = 2;
    private static final int TYPE_COUNTRY_RADIO = 3;
    private static final int TYPE_CATEGORY = 4;
    private boolean first1 = true;
    private boolean first2 = true;
    private List<RadioCategoryBean.StyleBean> categoryDatas;

    public RVRadioAdapter(Context context) {
        super(context);
        categoryDatas = new ArrayList<>();
    }

    public void addCategoryDataAll(List<RadioCategoryBean.StyleBean> categoryDatas){
        this.categoryDatas.addAll(categoryDatas);
        notifyDataSetChanged();
    }

    public void clearCategoryData(){
        this.categoryDatas.clear();
    }

    private String getItemTitle(int viewType) {
        switch (viewType) {
            case TYPE_RECOMMENT:
                return "推荐电台";
            case TYPE_LOCAL_MUSIC:
                return "本地电台";
            case TYPE_MUSIC_RADIO:
                return "音乐电台";
            case TYPE_COUNTRY_RADIO:
                return "全国电台";
            default:
                return "";
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_CATEGORY;
            case 1:
                return TYPE_RECOMMENT;
            case 2:
                return TYPE_LOCAL_MUSIC;
            case 3:
                return TYPE_MUSIC_RADIO;
            case 4:
                return TYPE_COUNTRY_RADIO;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == TYPE_CATEGORY) {
            view = mInflater.inflate(R.layout.item_fragment_radio_category, parent, false);
            return new CategoryViewHolder(view);
        } else {
            view = mInflater.inflate(R.layout.item_fragment_choiceness_rv_program, parent, false);
            return new RadioGroupViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==TYPE_CATEGORY){
            CategoryViewHolder categoryViewHolder = (CategoryViewHolder) holder;
            //设置电台分类的recyclerview
            categoryViewHolder.rvRadioCategory.setLayoutManager(new GridLayoutManager(mContext, 4));
            RVRadioCategoryAdapter categoryAdapter = new RVRadioCategoryAdapter(mContext);
            int dividerH = DensityUtil.dp2px(mContext, 5);
            if(first1) {
                categoryViewHolder.rvRadioCategory.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.BOTH_SET,dividerH,mContext.getResources().getColor(R.color.white)));
                first1 = false;
            }
            categoryViewHolder.rvRadioCategory.setAdapter(categoryAdapter);
            categoryAdapter.addAll(categoryDatas);
        }else {
            RadioGroupViewHolder groupViewHolder = (RadioGroupViewHolder) holder;
            groupViewHolder.tvItemProgramTitle.setText(getItemTitle(getItemViewType(position)));
            if (getDatas().size() != 0) {
                RadioGroupBean data = getDatas().get(0);
                switch (getItemViewType(position)) {
                    case TYPE_RECOMMENT:
                        RVRadioGroupItemAdapter adapter = new RVRadioGroupItemAdapter(mContext, RVRadioGroupItemAdapter.TYPE_RECOMMEND);
                        groupViewHolder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                        if(first2) {
                            groupViewHolder.rvItemChoicenessProgram.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL_LINE,20,mContext.getResources().getColor(R.color.white)));
                            first2 = false;
                        }
                        groupViewHolder.rvItemChoicenessProgram.setAdapter(adapter);
                        adapter.addAll(data.getRecommend());
                        break;
                    case TYPE_LOCAL_MUSIC:
                        RVRadioGroupItemAdapter adapter1 = new RVRadioGroupItemAdapter(mContext, RVRadioGroupItemAdapter.TYPE_RADIO);
                        groupViewHolder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext));
                        groupViewHolder.rvItemChoicenessProgram.setAdapter(adapter1);
                        adapter1.addAll(data.getLocal_radio());
                        break;
                    case TYPE_MUSIC_RADIO:
                        RVRadioGroupItemAdapter adapter2 = new RVRadioGroupItemAdapter(mContext, RVRadioGroupItemAdapter.TYPE_RADIO);
                        groupViewHolder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext));
                        groupViewHolder.rvItemChoicenessProgram.setAdapter(adapter2);
                        adapter2.addAll(data.getMusic_radio());
                    case TYPE_COUNTRY_RADIO:
                        RVRadioGroupItemAdapter adapter3 = new RVRadioGroupItemAdapter(mContext, RVRadioGroupItemAdapter.TYPE_RADIO);
                        groupViewHolder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext));
                        groupViewHolder.rvItemChoicenessProgram.setAdapter(adapter3);
                        adapter3.addAll(data.getNational_radio());
                }

            }
        }
    }

    static class RadioGroupViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_program_title)
        TextView tvItemProgramTitle;
        @BindView(R.id.rv_item_choiceness_program)
        CustomRV rvItemChoicenessProgram;

        RadioGroupViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
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

        CategoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}
