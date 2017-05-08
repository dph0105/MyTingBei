package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

import com.ding.god.tingbei.base.BaseFragment;

import java.util.List;

/**
 * Created by god on 2017/3/26.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;
    private String[] tabTitle;

    public HomePagerAdapter(FragmentManager fm, List<BaseFragment> fragments, String[] tabTitle) {
        super(fm);
        this.fragments = fragments;
        this.tabTitle = tabTitle;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments!=null){
            return fragments.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (fragments!=null){
            return fragments.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
