package com.ding.god.tingbei.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
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
        ivIcon.setImageResource(R.mipmap.ic_launcher);
        ivIcon.setId(generateViewId());
        LayoutParams lpIvIcon = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpIvIcon.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(ivIcon,lpIvIcon);
        //节目名称
        tvTitle = new TextView(context);
        tvTitle.setText("欢迎来到听呗");
        tvTitle.setId(generateViewId());
        LayoutParams lpTvTitle = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpTvTitle.addRule(RelativeLayout.RIGHT_OF,ivIcon.getId());
        lpTvTitle.addRule(RelativeLayout.ALIGN_TOP,ivIcon.getId());
        lpTvTitle.leftMargin=100;
        addView(tvTitle,lpTvTitle);
        //节目描述
        tvDescription = new TextView(context);
        tvDescription.setText("终于等到您了");
        tvDescription.setId(generateViewId());
        LayoutParams lpTvDescription = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpTvDescription.addRule(RelativeLayout.ALIGN_START,tvTitle.getId());
        lpTvDescription.addRule(RelativeLayout.ALIGN_BOTTOM,ivIcon.getId());
        addView(tvDescription,lpTvDescription);
        //播放列表按钮
        ivPlayList = new ImageView(context);
        ivPlayList.setImageResource(R.mipmap.ic_launcher);
        ivPlayList.setId(generateViewId());
        LayoutParams lpIvPlayList = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpIvPlayList.addRule(RelativeLayout.ALIGN_PARENT_END);
        lpIvPlayList.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(ivPlayList,lpIvPlayList);
        //播放暂停按钮
        ivPlaybtn = new ImageView(context);
        ivPlaybtn.setImageResource(R.mipmap.ic_launcher);
        ivPlaybtn.setId(generateViewId());
        LayoutParams lpIvPlayBtn = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
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


    public int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }



}
