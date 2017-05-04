package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.event.IntentEvent;
import com.ding.god.tingbei.view.activity.CategoryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.data;

/**
 * Created by Administrator on 2017/4/27.
 */

public class RVSortItemAdapter extends BaseRVAdapter<RadioTypeBean.SubCategoryBean,RVSortItemAdapter.SortViewHolder> {

    public RVSortItemAdapter(Context context) {
        super(context);
    }

    @Override
    public SortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_radio_rvitem_radiocategory, parent, false);
        return new SortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SortViewHolder holder, final int position) {
        holder.tvCategory.setText(getDatas().get(position).getCategory_name());
        holder.tvCategory.setTextColor(mContext.getResources().getColor(R.color.text_gray));
    }

    static class SortViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_category)
        TextView tvCategory;

        SortViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
