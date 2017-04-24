package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.customview.CustomRV;
import com.ding.god.tingbei.model.bean.ChoicenessBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by god on 2017/4/11.
 */

public class ChoicenessRVAdapter extends BaseRVAdapter<ChoicenessBean, ChoicenessRVAdapter.BaseViewHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_BODY = 1;


    public ChoicenessRVAdapter(Context context) {
        super(context);
    }


    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_HEAD : TYPE_BODY;
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case TYPE_HEAD:
                view = mInflater.inflate(R.layout.item_fragment_choiceness_rv_head, parent, false);
                return new HeadViewHolder(view);
            case TYPE_BODY:
                view = mInflater.inflate(R.layout.item_fragment_choiceness_rv_program, parent, false);
                return new BodyViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getDatas().size() != 0) {
            ChoicenessBean data = getDatas().get(0);
            Log.d("data", data.toString());
            if (holder instanceof HeadViewHolder) {
                HeadViewHolder headHolder = (HeadViewHolder) holder;
                List<ImageView> imageViews = new ArrayList<>();
                BannerVPAdapter vpAdapter = new BannerVPAdapter(mContext, imageViews, headHolder.vpBanner);
                headHolder.vpBanner.setAdapter(vpAdapter);
                for (int i = 0; i < data.getBanner().size(); i++) {
                    ImageView imageView = new ImageView(mContext);
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                    mImageUtil.loadURLImage(data.getBanner().get(i).getImage_url(), imageView);
                    Log.d("banner", data.getBanner().get(i).getImage_url());
                    imageViews.add(imageView);
                }
                vpAdapter.notifyDataSetChanged();

                for (int i = 0; i < data.getFast_entry().size(); i++) {
                    ViewGroup view = (ViewGroup) headHolder.llFastentry.getChildAt(i);
                    ImageView ivIcon = (ImageView) view.getChildAt(0);
                    TextView tvName = (TextView) view.getChildAt(1);
                    ChoicenessBean.FastEntryBean fastEntryBean = data.getFast_entry().get(i);
                    mImageUtil.loadURLImage(fastEntryBean.getIcon(), ivIcon);
                    tvName.setText(fastEntryBean.getTitle());
                }
                headHolder.tvRadioName.setText(data.getLocal_radio_recommend().getRadio_name());
                headHolder.tvRadioProgramInfo.setText(data.getLocal_radio_recommend().getProgram_describe());
                float num = Math.round(data.getLocal_radio_recommend().getRadio_audience()/10000*10/10);
                headHolder.tvRadioListenNum.setText("收听人数："+num+"万");
                mImageUtil.loadURLImage(data.getLocal_radio_recommend().getImage_url(),headHolder.ivRadioIcon);

            } else if (holder instanceof BodyViewHolder) {
                BodyViewHolder bodyHolder = (BodyViewHolder) holder;
                if (position == 4) {
                    bodyHolder.tvItemProgramTitle.setText("精品推荐");
                    bodyHolder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                    RVChoicenessItemRCAdapter adapter = new RVChoicenessItemRCAdapter(mContext);
                    bodyHolder.rvItemChoicenessProgram.setAdapter(adapter);
                    adapter.addAll(data.getRecommend_content_list());
                } else if (position == 8) {
                    bodyHolder.tvItemProgramTitle.setText("正在直播");
                    bodyHolder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext));
                    RVChoicenessItemLiveRadioAdapter adapter = new RVChoicenessItemLiveRadioAdapter(mContext);
                    bodyHolder.rvItemChoicenessProgram.setAdapter(adapter);
                    adapter.addAll(data.getLive_radio_random());
                }
            }
        }
    }


    static class BaseViewHolder extends RecyclerView.ViewHolder {
        BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class HeadViewHolder extends BaseViewHolder {
        @BindView(R.id.vp_banner)
        ViewPager vpBanner;
        @BindView(R.id.ll_fastentry)
        LinearLayout llFastentry;
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
        HeadViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class BodyViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_item_program_title)
        TextView tvItemProgramTitle;
        @BindView(R.id.rv_item_choiceness_program)
        CustomRV rvItemChoicenessProgram;

        BodyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
