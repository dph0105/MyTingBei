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
import com.ding.god.tingbei.model.bean.ChoicenessBean;
import com.ding.god.tingbei.model.bean.RadioBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by god on 2017/4/23.
 */

public class RVChoicenessItemLiveRadioAdapter extends BaseRVAdapter<RadioBean,RVChoicenessItemLiveRadioAdapter.LiveRadioViewHolder> {
    public RVChoicenessItemLiveRadioAdapter(Context context) {
        super(context);
    }

    @Override
    public LiveRadioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_item_liveradio, parent, false);

        return new LiveRadioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LiveRadioViewHolder holder, int position) {
        RadioBean data = getDatas().get(position);
        holder.tvRadioName.setText(data.getRadio_name());
        holder.tvRadioProgramInfo.setText(data.getProgram_describe());
        float num = Math.round(data.getRadio_audience()/10000*10/10);
        holder.tvRadioListenNum.setText("收听人数："+num+"万");
        mImageUtil.loadURLImage(data.getImage_url(),holder.ivRadioIcon);
    }

    static class LiveRadioViewHolder extends RecyclerView.ViewHolder {
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

        LiveRadioViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
