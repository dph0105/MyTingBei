package com.ding.god.tingbei.view.adapter;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.customview.CustomRV;
import com.ding.god.tingbei.model.bean.RadioGroupBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/26.
 */

public class RVRadioGroupAdapter extends BaseRVAdapter<RadioGroupBean,RVRadioGroupAdapter.RadioGroupViewHolder> {

    private static final int TYPE_RECOMMENT = 0;
    private static final int TYPE_LOCAL_MUSIC = 1;
    private static final int TYPE_MUSIC_RADIO = 2;
    private static final int TYPE_COUNTRY_RADIO = 3;
    public RVRadioGroupAdapter(Context context) {
        super(context);
    }

    private String getItemTitle(int viewType){
        switch (viewType){
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
                return TYPE_RECOMMENT;
            case 1:
                return TYPE_LOCAL_MUSIC;
            case 2:
                return TYPE_MUSIC_RADIO;
            case 3:
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public RadioGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_choiceness_rv_program, parent, false);
        return new RadioGroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RadioGroupViewHolder holder, int position) {
        holder.tvItemProgramTitle.setText(getItemTitle(getItemViewType(position)));
        if(getDatas().size()!=0) {

        RadioGroupBean data = getDatas().get(0);
        switch (getItemViewType(position)){
            case TYPE_RECOMMENT:
                RVRadioGroupItemAdapter adapter = new RVRadioGroupItemAdapter(mContext);
                holder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
                holder.rvItemChoicenessProgram.setAdapter(adapter);
                adapter.addAll(data.getRecommend());
               break;
            case TYPE_LOCAL_MUSIC:
                RVRadioGroupItemAdapter adapter1 = new RVRadioGroupItemAdapter(mContext);
                holder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext));
                holder.rvItemChoicenessProgram.setAdapter(adapter1);
               adapter1.addAll(data.getLocal_radio());
                break;
            case TYPE_MUSIC_RADIO:
                RVRadioGroupItemAdapter adapter2 = new RVRadioGroupItemAdapter(mContext);
                holder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext));
                holder.rvItemChoicenessProgram.setAdapter(adapter2);
                adapter2.addAll(data.getMusic_radio());
            case TYPE_COUNTRY_RADIO:
                RVRadioGroupItemAdapter adapter3 = new RVRadioGroupItemAdapter(mContext);
                holder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext));
                holder.rvItemChoicenessProgram.setAdapter(adapter3);
               adapter3.addAll(data.getNational_radio());
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
}
