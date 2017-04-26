package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.model.bean.RadioGroupBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/26.
 */

public class RVRadioGroupItemAdapter extends BaseRVAdapter<RadioGroupBean.RadioBean, RecyclerView.ViewHolder> {

    public static final int TYPE_RECOMMEND = 0;
    public static final int TYPE_RADIO = 1;
    private int type;

    public RVRadioGroupItemAdapter(Context context,int type) {
        super(context);
        this.type = type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (type) {
            case TYPE_RECOMMEND:
                view = mInflater.inflate(R.layout.item_fragment_radio_rvitem_recommend, parent, false);
                return new RadioRecommendViewHolder(view);
            case TYPE_RADIO:
                view = mInflater.inflate(R.layout.layout_item_liveradio, parent, false);
                return new RadioViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RadioGroupBean.RadioBean data = getDatas().get(position);
        String s = "直播中:%s";
        switch (type){
            case TYPE_RECOMMEND:
                RadioRecommendViewHolder recommendHolder = (RadioRecommendViewHolder) holder;
                recommendHolder.tvRadioName.setText(data.getRadio_name());
                recommendHolder.tvProgramName.setText(String.format(s,data.getProgram_name()));
                mImageUtil.loadURLImage(data.getImage_url(),recommendHolder.ivRadioBg);
                break;
            case TYPE_RADIO:
                RadioViewHolder radioHolder = (RadioViewHolder) holder;
                radioHolder.tvRadioName.setText(data.getRadio_name());
                radioHolder.tvRadioProgramInfo.setText(String.format(s,data.getProgram_name()));
                float num = Math.round(data.getRadio_audience() / 10000 * 10 / 10);
                String listenNum = "收听人数:%f万";
                radioHolder.tvRadioListenNum.setText(String.format(listenNum,num));
                mImageUtil.loadURLImage(data.getRadio_img_url(),radioHolder.ivRadioIcon);
                break;
        }
    }

    static class RadioViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_radio_icon)
        ImageView ivRadioIcon;
        @BindView(R.id.cv)
        CardView cv;
        @BindView(R.id.tv_radio_name)
        TextView tvRadioName;
        @BindView(R.id.tv_radio_program_info)
        TextView tvRadioProgramInfo;
        @BindView(R.id.tv_radio_listen_num)
        TextView tvRadioListenNum;

        RadioViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class RadioRecommendViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_radio_bg)
        ImageView ivRadioBg;
        @BindView(R.id.tv_radio_name)
        TextView tvRadioName;
        @BindView(R.id.tv_program_name)
        TextView tvProgramName;

        RadioRecommendViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
