package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.model.bean.RadioByTypeBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/5/4.
 */

public class RVCategoryDetailAdapter extends BaseRVAdapter<RadioByTypeBean,RVCategoryDetailAdapter.CategoryDetailViewHolder> {

    public RVCategoryDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public CategoryDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_category_detail, parent, false);
        return new CategoryDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryDetailViewHolder holder, int position) {
        RadioByTypeBean data = getDatas().get(position);
        holder.tvAlbumName.setText(data.getAlbum_name());
        holder.tvCategoryTip.setText(data.getCategory_tip());
        holder.tvAppPlayAmount.setText(data.getApp_play_amount());
        mImageUtil.loadURLImage(data.getAlbum_logo(),holder.ivAlbumLogo);
    }

    static class CategoryDetailViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_album_logo)
        ImageView ivAlbumLogo;
        @BindView(R.id.tv_album_name)
        TextView tvAlbumName;
        @BindView(R.id.tv_category_tip)
        TextView tvCategoryTip;
        @BindView(R.id.tv_app_play_amount)
        TextView tvAppPlayAmount;

        CategoryDetailViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
