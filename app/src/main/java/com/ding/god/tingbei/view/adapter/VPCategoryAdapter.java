package com.ding.god.tingbei.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.view.fragment.CategoryDetailFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */

public class VPCategoryAdapter extends FragmentPagerAdapter {


    private List<CategoryDetailFragment> fragments;
    private List<RadioTypeBean> radioTypeBeanList;

    public VPCategoryAdapter(FragmentManager fm,List<CategoryDetailFragment> fragments,List<RadioTypeBean> radioTypeBeanList) {
        super(fm);
        this.fragments = fragments;
        this.radioTypeBeanList = radioTypeBeanList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return radioTypeBeanList.get(position).getCategory_name();
    }
}
