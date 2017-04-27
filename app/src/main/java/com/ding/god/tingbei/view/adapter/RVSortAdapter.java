package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.customview.DividerItemDecoration;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.util.DensityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/27.
 */

public class RVSortAdapter extends BaseRVAdapter<RadioTypeBean,RVSortAdapter.SortViewHolder> {

    public RVSortAdapter(Context context) {
        super(context);
    }

    @Override
    public SortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_sort_rv, parent, false);
        return new SortViewHolder(view,mContext);
    }

    @Override
    public void onBindViewHolder(SortViewHolder holder, int position) {
        RadioTypeBean data =getDatas().get(position);
        mImageUtil.loadURLImage(data.getCategory_image(),holder.ivCategoryIcon);
        holder.tvCategoryName.setText(data.getCategory_name());
        holder.rvFragmentSortRvitem.setLayoutManager(new GridLayoutManager(mContext,4));
        RVSortItemAdapter adapter = new RVSortItemAdapter(mContext);
        holder.rvFragmentSortRvitem.setAdapter(adapter);
        adapter.addAll(data.getSub_category());
    }

    static class SortViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_category_icon)
        ImageView ivCategoryIcon;
        @BindView(R.id.tv_category_name)
        TextView tvCategoryName;
        @BindView(R.id.tv_category_more)
        ImageView tvCategoryMore;
        @BindView(R.id.rv_fragment_sort_rvitem)
        RecyclerView rvFragmentSortRvitem;

        SortViewHolder(View view,Context mContext) {
            super(view);
            ButterKnife.bind(this, view);
            rvFragmentSortRvitem.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.BOTH_SET, DensityUtil.dp2px(mContext,5),mContext.getResources().getColor(R.color.white)));

        }
    }
}
