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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.customview.CustomRV;
import com.ding.god.tingbei.model.bean.ChoicenessBean;
import com.ding.god.tingbei.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by god on 2017/4/11.
 */

public class ChoicenessRVAdapter extends BaseRVAdapter<ChoicenessBean, ChoicenessRVAdapter.BaseViewHolder> {

    private static final int TYPE_HEAD = 0;//头item
    private static final int TYPE_BODY = 1;//普通item
    private static final int TYPE_HOT_ATTENTION = 2;//最后的
    private static final int TYPE_RECOMMENT_CONTENT = 3;//精品推荐
    private static final int TYPE_LIVE_RADIO = 4;//正在直播
    private static final int TYPE_RECOMMENT_RADIO = 5;//电台推荐

    private List<ImageView> imageViews;


    public ChoicenessRVAdapter(Context context) {
        super(context);
        imageViews = new ArrayList<>();
    }


    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEAD;
            case 4:
                return TYPE_RECOMMENT_CONTENT;
            case 8:
                return TYPE_LIVE_RADIO;
            case 10:
                return TYPE_RECOMMENT_RADIO;
            case 11:
                return TYPE_HOT_ATTENTION;
            default:
                return TYPE_BODY;
        }
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        View bodyView = mInflater.inflate(R.layout.item_fragment_choiceness_rv_program, parent, false);
        switch (viewType) {
            case TYPE_HEAD:
                view = mInflater.inflate(R.layout.item_fragment_choiceness_rv_head, parent, false);
                return new HeadViewHolder(view);
            case TYPE_BODY:
                return new BodyViewHolder(bodyView);
            case TYPE_RECOMMENT_RADIO:
                view = mInflater.inflate(R.layout.item_fragment_choiceness_rvitem_recommend_radio, parent, false);
                return new BodyLLViewHolder(view);
            case TYPE_RECOMMENT_CONTENT:
                return new BodyViewHolder(bodyView);
            case TYPE_LIVE_RADIO:
                return new BodyViewHolder(bodyView);
            case TYPE_HOT_ATTENTION:
                view = mInflater.inflate(R.layout.item_fragment_choiceness_rvitem_hot_attention, parent, false);
                return new HotAttentionViewHolder(view);
        }
        return null;
    }

    private int getListPosition(int position) {
        switch (position) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 5:
                return 3;
            case 6:
                return 4;
            case 7:
                return 5;
            case 9:
                return 6;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getDatas().size() != 0) {
            ChoicenessBean data = getDatas().get(0);
            Log.d("data", data.toString());
            switch (getItemViewType(position)) {
                case TYPE_HEAD://头
                    final HeadViewHolder headHolder = (HeadViewHolder) holder;
                    final BannerVPAdapter vpAdapter = new BannerVPAdapter(imageViews);
                    headHolder.vpBanner.setAdapter(vpAdapter);
                    if (imageViews.size() == 0) {
                        Log.d("image", "imagesize:" + imageViews.size());
                        for (int i = 0; i < data.getBanner().size(); i++) {
                            ImageView imageView = new ImageView(mContext);
                            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                            mImageUtil.loadURLImage(data.getBanner().get(i).getImage_url(), imageView);
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            imageViews.add(imageView);
                            ImageView indicator = new ImageView(mContext);
                            //indicator.setButtonDrawable(null);
                            int width = DensityUtil.dp2px(mContext,10);
                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT);
                            int margin = DensityUtil.dp2px(mContext, 3);
                            indicator.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            lp.setMargins(margin,0,margin,0);
                            indicator.setLayoutParams(lp);
                            indicator.setImageResource(R.drawable.selector_banner_indicator);
                            headHolder.llBannerIndicator.addView(indicator);
                        }
                        vpAdapter.notifyDataSetChanged();
                    }
                    headHolder.vpBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                            int truePosition =  vpAdapter.getTruePositon(position);
                            for (int i=0;i<imageViews.size();i++){
                                headHolder.llBannerIndicator.getChildAt(i).setSelected(i==truePosition);
                            }
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
                    headHolder.vpBanner.setCurrentItem(Integer.MAX_VALUE/2-Integer.MAX_VALUE/imageViews.size());
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
                    float num = Math.round(data.getLocal_radio_recommend().getRadio_audience() / 10000 * 10 / 10);
                    headHolder.tvRadioListenNum.setText("收听人数：" + num + "万");
                    mImageUtil.loadURLImage(data.getLocal_radio_recommend().getImage_url(), headHolder.ivRadioIcon);
                    break;
                case TYPE_RECOMMENT_CONTENT://精品推荐
                    BodyViewHolder bodyHolder1 = (BodyViewHolder) holder;
                    bodyHolder1.tvItemProgramTitle.setText("精品推荐");
                    bodyHolder1.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                    RVChoicenessItemRCAdapter itemRCAdapter = new RVChoicenessItemRCAdapter(mContext);
                    bodyHolder1.rvItemChoicenessProgram.setAdapter(itemRCAdapter);
                    itemRCAdapter.addAll(data.getRecommend_content_list());
                    break;
                case TYPE_LIVE_RADIO://正在直播
                    BodyViewHolder bodyHolder2 = (BodyViewHolder) holder;
                    bodyHolder2.tvItemProgramTitle.setText("正在直播");
                    bodyHolder2.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext));
                    RVChoicenessItemLiveRadioAdapter itemLiveRadioAdapter = new RVChoicenessItemLiveRadioAdapter(mContext);
                    bodyHolder2.rvItemChoicenessProgram.setAdapter(itemLiveRadioAdapter);
                    itemLiveRadioAdapter.addAll(data.getLive_radio_random());
                    break;
                case TYPE_RECOMMENT_RADIO://电台推荐
                    BodyLLViewHolder bodyLLHolder = (BodyLLViewHolder) holder;
                    bodyLLHolder.tvItemProgramTitle.setText("电台推荐");
                    for (int i = 0; i < bodyLLHolder.llRecommendRadio.getChildCount(); i++) {
                        ImageView iv = (ImageView) ((LinearLayout) bodyLLHolder.llRecommendRadio.getChildAt(i)).getChildAt(0);
                        ((TextView) ((LinearLayout) bodyLLHolder.llRecommendRadio.getChildAt(i)).getChildAt(1)).setText(data.getRecommend_radio_list().get(i).getRadio_name());
                        mImageUtil.loadURLImage(data.getRecommend_radio_list().get(i).getImage_url(), iv);
                    }
                    break;
                case TYPE_BODY://普通的item
                    BodyViewHolder bodyHolder = (BodyViewHolder) holder;
                    int listPositon = getListPosition(position);
                    ChoicenessBean.ProgramRecommendBean programData = data.getProgram_recommend().get(listPositon);
                    bodyHolder.tvItemProgramTitle.setText(programData.getCategory_name());
                    bodyHolder.rvItemChoicenessProgram.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                    RVChoicenessItemProgramAdapter itemProgramAdapter = new RVChoicenessItemProgramAdapter(mContext);
                    bodyHolder.rvItemChoicenessProgram.setAdapter(itemProgramAdapter);
                    itemProgramAdapter.addAll(programData.getData());
                    break;
                case TYPE_HOT_ATTENTION://列表最后
                    HotAttentionViewHolder hotAttentionHolder = (HotAttentionViewHolder) holder;
                    hotAttentionHolder.tvItemProgramTitle.setText(data.getHot_attention().getCategory_name());
                    hotAttentionHolder.tvHotAttentionHead.setText(data.getHot_attention().getData().get(0).getProgram_name());
                    mImageUtil.loadURLImage(data.getHot_attention().getData().get(0).getProgram_img(), hotAttentionHolder.ivHotAttentionHead);
                    hotAttentionHolder.tvProgramName1.setText(data.getHot_attention().getData().get(1).getProgram_name());
                    hotAttentionHolder.tvDescribe1.setText(data.getHot_attention().getData().get(1).getProgram_describe());
                    mImageUtil.loadURLImage(data.getHot_attention().getData().get(1).getProgram_img(), hotAttentionHolder.ivProgram1);
                    hotAttentionHolder.tvProgramName2.setText(data.getHot_attention().getData().get(2).getProgram_name());
                    hotAttentionHolder.tvDescribe2.setText(data.getHot_attention().getData().get(2).getProgram_describe());
                    mImageUtil.loadURLImage(data.getHot_attention().getData().get(2).getProgram_img(), hotAttentionHolder.ivProgram2);
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
        @BindView(R.id.ll_banner_indicator)
        LinearLayout llBannerIndicator;

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

    static class BodyLLViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_item_program_title)
        TextView tvItemProgramTitle;
        @BindView(R.id.ll_recommend_radio)
        LinearLayout llRecommendRadio;

        BodyLLViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static class HotAttentionViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_item_program_title)
        TextView tvItemProgramTitle;
        @BindView(R.id.iv_hot_attention_head)
        ImageView ivHotAttentionHead;
        @BindView(R.id.tv_hot_attention_head)
        TextView tvHotAttentionHead;
        ImageView ivProgram1;
        TextView tvProgramName1;
        TextView tvDescribe1;
        ImageView ivProgram2;
        TextView tvProgramName2;
        TextView tvDescribe2;

        HotAttentionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            RelativeLayout rl1 = (RelativeLayout) view.findViewById(R.id.layout1);
            RelativeLayout rl2 = (RelativeLayout) view.findViewById(R.id.layout2);
            ivProgram1 = (ImageView) rl1.findViewById(R.id.iv_program);
            tvProgramName1 = (TextView) rl1.findViewById(R.id.tv_program_name);
            tvDescribe1 = (TextView) rl1.findViewById(R.id.tv_describe);
            ivProgram2 = (ImageView) rl2.findViewById(R.id.iv_program);
            tvProgramName2 = (TextView) rl2.findViewById(R.id.tv_program_name);
            tvDescribe2 = (TextView) rl2.findViewById(R.id.tv_describe);
        }

    }


}
