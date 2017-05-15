package com.ding.god.tingbei.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;


/**
 * Created by Administrator on 2017/3/21.
 */

public class PlayBar extends RelativeLayout {

    private int mHeight;
    private int mWidth;
    //playerBar中的控件
    private ImageView ivIcon;
    private TextView tvTitle;
    private TextView tvDescription;
    private ImageView ivPlaybtn;
    private ImageView ivPlayList;

    /**
     * 设置icon
     * @param bitmap
     */
    public void setIcon(Bitmap bitmap){
        ivIcon.setImageBitmap(bitmap);
    }
    public void setIcon(int ResId){
        ivIcon.setImageResource(ResId);
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }

    public void setDescription(String description){
        tvDescription.setText(description);
    }

    public void setPlayListener(OnClickListener playListener){
        ivPlaybtn.setOnClickListener(playListener);
    }

    public void setPlayListListener(OnClickListener playListListener){
        ivPlayList.setOnClickListener(playListListener);
    }

    public void setPlayBtnClickable(boolean isClickable){
        ivPlaybtn.setClickable(isClickable);
    }

    public void setPlayBtnSelected(boolean isSelected){
        ivPlaybtn.setSelected(isSelected);
    }



    //playerbar的属性
    private int textSize;
    private String title;
    private Drawable icon;
    private String description;
    private int widthPixel;

    public PlayBar(Context context) {
        super(context);
    }

    public PlayBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }



    private void initView(Context context) {
        //icon
        ivIcon = new ImageView(context);
        ivIcon.setImageResource(R.mipmap.play_logo);
        ivIcon.setId(generateViewId());
        ivIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LayoutParams lpIvIcon = new LayoutParams(dip2px(context,40),dip2px(context,40));
        lpIvIcon.leftMargin = dip2px(context,10);
        lpIvIcon.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(ivIcon,lpIvIcon);

        //节目名称
        tvTitle = new TextView(context);
        tvTitle.setText("欢迎来到听呗");
        tvTitle.setId(generateViewId());
        tvTitle.setLines(1);
        tvTitle.setTextSize(14);
        tvTitle.setEllipsize(TextUtils.TruncateAt.END);
        LayoutParams lpTvTitle = new LayoutParams(dip2px(context,180), LayoutParams.WRAP_CONTENT);
        lpTvTitle.addRule(RelativeLayout.RIGHT_OF,ivIcon.getId());
        lpTvTitle.addRule(RelativeLayout.ALIGN_TOP,ivIcon.getId());
        lpTvTitle.leftMargin= dip2px(context,15);
        addView(tvTitle,lpTvTitle);
        //节目描述
        tvDescription = new TextView(context);
        tvDescription.setText("终于等到您了");
        tvDescription.setId(generateViewId());
        tvDescription.setLines(1);
        tvDescription.setTextSize(14);
        tvDescription.setEllipsize(TextUtils.TruncateAt.END);
        LayoutParams lpTvDescription = new LayoutParams(dip2px(context,180), LayoutParams.WRAP_CONTENT);
        lpTvDescription.addRule(RelativeLayout.ALIGN_START,tvTitle.getId());
        lpTvDescription.addRule(RelativeLayout.BELOW,tvTitle.getId());
        addView(tvDescription,lpTvDescription);

        //播放列表按钮
        ivPlayList = new ImageView(context);
        ivPlayList.setImageResource(R.mipmap.playlist);
        ivPlayList.setId(generateViewId());
        LayoutParams lpIvPlayList = new LayoutParams(dip2px(context,30), dip2px(context,30));
        lpIvPlayList.rightMargin = dip2px(context,10);
        lpIvPlayList.addRule(RelativeLayout.ALIGN_PARENT_END);
        lpIvPlayList.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(ivPlayList,lpIvPlayList);
        //播放暂停按钮
        ivPlaybtn = new ImageView(context);
        ivPlaybtn.setImageResource(R.drawable.selector_play_conrol);
        ivPlaybtn.setId(generateViewId());
        LayoutParams lpIvPlayBtn = new LayoutParams(dip2px(context,30), dip2px(context,30));
        lpIvPlayBtn.rightMargin = dip2px(context,20);
        lpIvPlayBtn.addRule(RelativeLayout.CENTER_VERTICAL);
        lpIvPlayBtn.addRule(RelativeLayout.START_OF,ivPlayList.getId());
        addView(ivPlaybtn,lpIvPlayBtn);


    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = MeasureSpec.makeMeasureSpec(150,MeasureSpec.UNSPECIFIED);
        LayoutParams lp = (LayoutParams) getLayoutParams();
        lp.height = height;
        lp.width = getResources().getDisplayMetrics().widthPixels;
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        setLayoutParams(lp);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }


    private int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    private int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    private static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }



}
