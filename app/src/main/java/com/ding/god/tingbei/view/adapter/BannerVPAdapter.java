package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.List;

/**
 * Created by Administrator on 2017/4/25.
 */

public class BannerVPAdapter extends PagerAdapter {

    private List<ImageView> imageViews;
    private Context context;
    private boolean canLoob = true;


    public BannerVPAdapter(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        if(imageViews==null||imageViews.size()==0) {
            return 0;
        }
        return canLoob?Integer.MAX_VALUE:imageViews.size();
    }

    public int getTruePositon(int position){
        return position%imageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
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


}
