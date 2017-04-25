package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.model.bean.ChoicenessBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/25.
 */

public class RVChoicenessItemProgramAdapter extends BaseRVAdapter<ChoicenessBean.ProgramRecommendBean.DataBeanX,RVChoicenessItemProgramAdapter.ChoicenessProgramViewHolder> {

    public RVChoicenessItemProgramAdapter(Context context) {
        super(context);
    }

    @Override
    public ChoicenessProgramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_choiceness_rvitem_program, parent, false);
        return new ChoicenessProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChoicenessProgramViewHolder holder, int position) {
        ChoicenessBean.ProgramRecommendBean.DataBeanX data = getDatas().get(position);
        holder.tvItemChoicenessProgram.setText(data.getProgram_name());
        mImageUtil.loadURLImage(data.getProgram_img(),holder.ivItemChoicenessProgram);

    }

    static class ChoicenessProgramViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_item_choiceness_program)
        ImageView ivItemChoicenessProgram;
        @BindView(R.id.tv_item_choiceness_program)
        TextView tvItemChoicenessProgram;

        ChoicenessProgramViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
