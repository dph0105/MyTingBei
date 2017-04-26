package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.model.bean.RadioCategoryBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/26.
 */

public class RVRadioCategoryAdapter extends BaseRVAdapter<RadioCategoryBean.StyleBean,RVRadioCategoryAdapter.CategoryViewHolder> {
    public RVRadioCategoryAdapter(Context context) {
        super(context);
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_radio_rvitem_radiocategory, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tvCategory.setText(getDatas().get(position).getCategory_name());
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_category)
        TextView tvCategory;

        CategoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
