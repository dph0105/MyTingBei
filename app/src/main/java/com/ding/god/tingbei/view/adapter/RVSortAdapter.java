package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.customview.DividerItemDecoration;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.util.DensityUtil;
import com.ding.god.tingbei.util.OnRecylerViewItemClickListener;
import com.ding.god.tingbei.view.activity.CategoryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/27.
 */

public class RVSortAdapter extends BaseRVAdapter<RadioTypeBean, RVSortAdapter.SortViewHolder> {



    public RVSortAdapter(Context context) {
        super(context);
    }

    @Override
    public SortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_sort_rv, parent, false);
        return new SortViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(SortViewHolder holder, int position) {
        final RadioTypeBean data = getDatas().get(position);
        mImageUtil.loadURLImage(data.getCategory_image(), holder.ivCategoryIcon);
        holder.tvCategoryName.setText(data.getCategory_name());
        holder.rvFragmentSortRvitem.setLayoutManager(new GridLayoutManager(mContext, 4));
        RVSortItemAdapter adapter = new RVSortItemAdapter(mContext);
        holder.rvFragmentSortRvitem.setAdapter(adapter);
        adapter.addAll(data.getSub_category());
        holder.rlMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toCategoryActivity(data);
            }
        });

        holder.rvFragmentSortRvitem.addOnItemTouchListener(new OnRecylerViewItemClickListener(holder.rvFragmentSortRvitem){
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                super.onItemClick(vh);
                toCategoryActivity(data);
            }
        });
    }

    public void toCategoryActivity(RadioTypeBean data){
        Intent intent = new Intent(mContext, CategoryActivity.class);
        intent.putExtra("category_id",data.getCategory_id());
        intent.putExtra("category_name",data.getCategory_name());
        mContext.startActivity(intent);
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
        @BindView(R.id.rl_more)
        RelativeLayout rlMore;

        SortViewHolder(View view, Context mContext) {
            super(view);
            ButterKnife.bind(this, view);
            rvFragmentSortRvitem.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.BOTH_SET, DensityUtil.dp2px(mContext, 5), mContext.getResources().getColor(R.color.white)));

        }
    }
}
