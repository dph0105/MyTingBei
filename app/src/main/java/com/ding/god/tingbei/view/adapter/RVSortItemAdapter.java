package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private String parent_name;
    private String parent_id;

    public RVSortItemAdapter(Context context,String parent_name,String parent_id) {
        super(context);
        this.parent_name = parent_name;
        this.parent_id = parent_id;
    }

    @Override
    public SortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_radio_rvitem_radiocategory, parent, false);
        return new SortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SortViewHolder holder, final int position) {
        final RadioTypeBean.SubCategoryBean data = getDatas().get(position);
        holder.tvCategory.setText(data.getCategory_name());
        holder.tvCategory.setTextColor(mContext.getResources().getColor(R.color.text_gray));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CategoryActivity.class);
                intent.putExtra("category_id", parent_id);
                intent.putExtra("category_name", parent_name);
                intent.putExtra("position",position+1);
                Log.d("category","id: "+ data.getCategory_id()+" name: "+ data.getCategory_name());
                mContext.startActivity(intent);
            }
        });

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
