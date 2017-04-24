package com.ding.god.tingbei.view.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.ding.god.tingbei.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */

public class BannerVPAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener{

    private final ViewPager vp;
    private List<ImageView> imageViews;
    private RadioGroup indicator;
    private boolean canLoob = true;
    private Context context;
    public BannerVPAdapter(Context context,List<ImageView> imageViews,ViewPager vp) {
        this.imageViews = imageViews;
        this.vp = vp;
        this.context = context;
        initView(context);
        vp.addOnPageChangeListener(this);
    }

    private void initView(Context context) {
        indicator = new RadioGroup(context);
        ViewGroup.LayoutParams vplp = vp.getLayoutParams();
        RelativeLayout  rl= new RelativeLayout(context);

        rl.setLayoutParams(vplp);
        ViewGroup vg = (ViewGroup) vp.getParent();

        vg.addView(rl,0);
        vg.removeView(vp);
        rl.addView(vp);
        rl.addView(indicator);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.bottomMargin = dp2px(context,5);
        indicator.setLayoutParams(layoutParams);
        indicator.setOrientation(OrientationHelper.HORIZONTAL);
        addIndicator();
//        ((RadioButton) indicator.getChildAt(0)).setChecked(true);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void addIndicator(){
        for (int i=0;i<imageViews.size();i++){
            RadioButton iv_indicator = new RadioButton(context);
            iv_indicator.setButtonDrawable(null);
            Drawable drawable = context.getDrawable(R.drawable.selector_banner_indicator);
            iv_indicator.setBackground(drawable);
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(50,50);
            iv_indicator.setLayoutParams(lp2);
              iv_indicator.setGravity(Gravity.CENTER);
            indicator.addView(iv_indicator);
            imageViews.get(i).setTag(iv_indicator);
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        addIndicator();
    }

    @Override
    public int getCount() {
        if(imageViews==null||imageViews.size()==0) {
            return 0;
        }
        return canLoob?Integer.MAX_VALUE:imageViews.size();
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imageViews.get(position%imageViews.size());
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView imageView = imageViews.get(position%imageViews.size());
        container.removeView(imageView);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public void setCanLoop(boolean canLoop){
        this.canLoob = canLoop;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("positon", String.valueOf(position%imageViews.size()));
        ImageView iv = imageViews.get(position % imageViews.size());
        ((RadioButton) iv.getTag()).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public int dp2px(Context context,int dp){
        float density = context.getResources().getDisplayMetrics().density;
        return ((int) (dp * density + 0.5f));
    }
}
