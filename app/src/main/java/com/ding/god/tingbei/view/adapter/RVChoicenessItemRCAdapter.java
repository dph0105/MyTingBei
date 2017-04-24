package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.model.bean.ChoicenessBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by god on 2017/4/23.
 */

public class RVChoicenessItemRCAdapter extends BaseRVAdapter<ChoicenessBean.RecommendContentListBean,RVChoicenessItemRCAdapter.RecommendContentViewHolder> {

    public RVChoicenessItemRCAdapter(Context context) {
        super(context);
    }

    @Override
    public RecommendContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_choiceness_rvitem_recommend_content, parent, false);
        return new RecommendContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecommendContentViewHolder holder, int position) {
        ChoicenessBean.RecommendContentListBean data = getDatas().get(position);
        mImageUtil.loadURLImage(data.getImage_url(),holder.ivRecommendContent);
    }

    static class RecommendContentViewHolder  extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_recommend_content)
        ImageView ivRecommendContent;

        RecommendContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
