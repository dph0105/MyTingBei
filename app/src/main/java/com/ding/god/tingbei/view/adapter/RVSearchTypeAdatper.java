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
import com.ding.god.tingbei.model.bean.SearchResultTypeBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by god on 2017/5/2.
 */

public class RVSearchTypeAdatper extends BaseRVAdapter<SearchResultTypeBean,RVSearchTypeAdatper.SearchTyepViewHolder> {

    private int type;

    public RVSearchTypeAdatper(Context context) {
        super(context);

    }



    private void getType(SearchResultTypeBean data) {
        if (data.getAlbum_id()!=null){
            type = 1;
        }else if (data.getRadio_id()!=null){
            type = 2;
        }else if (data.getProgram_id()!=null){
            type = 3;
        }
    }

    @Override
    public SearchTyepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_item_liveradio, parent, false);
        return new SearchTyepViewHolder(view);
    }





    @Override
    public void onBindViewHolder(SearchTyepViewHolder holder, int position) {
        SearchResultTypeBean data = getDatas().get(position);
        getType(data);
        switch (type){
            case 1:
                holder.tvRadioName.setText(data.getAlbum_name());
                holder.tvRadioProgramInfo.setText(data.getAlbum_describe());
                mImageUtil.loadURLImage(data.getAlbum_logo(),holder.ivRadioIcon);
                break;
            case 2:
                holder.tvRadioName.setText(data.getRadio_name());
                holder.tvRadioProgramInfo.setText("暂无节目信息");
                holder.tvRadioListenNum.setText(data.getRadio_number());
                mImageUtil.loadURLImage(data.getAlbum_logo(),holder.ivRadioIcon);
                break;
            case 3:
                holder.tvRadioName.setText(data.getProgram_name());
                holder.tvRadioProgramInfo.setText(data.getProgram_describe());
                holder.tvRadioListenNum.setText(data.getProgram_date());
                mImageUtil.loadURLImage(data.getAlbum_logo(),holder.ivRadioIcon);
                break;
        }
    }

    static class SearchTyepViewHolder extends RecyclerView.ViewHolder {
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

        SearchTyepViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
