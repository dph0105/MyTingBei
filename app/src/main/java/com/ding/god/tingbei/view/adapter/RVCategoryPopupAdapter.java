package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.event.ClickEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/5/5.
 */

public class RVCategoryPopupAdapter extends BaseRVAdapter<RadioTypeBean,RVCategoryPopupAdapter.CategoryPopupViewHolder> {


    private int selectPosition;


    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }

    public RVCategoryPopupAdapter(Context context) {
        super(context);
    }

    @Override
    public CategoryPopupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_tv_category_popup, parent, false);
        return new CategoryPopupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoryPopupViewHolder holder, final int position) {
        if(position==selectPosition) {
            holder.itemView.setSelected(true);
        }
        holder.tvPopupCategoryName.setText(getDatas().get(position).getCategory_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxBus.getRxBus().post(new ClickEvent.CategoryPopupClickEvent(position));

            }
        });
    }

    static class CategoryPopupViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_popup_category_name)
        TextView tvPopupCategoryName;

        CategoryPopupViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
