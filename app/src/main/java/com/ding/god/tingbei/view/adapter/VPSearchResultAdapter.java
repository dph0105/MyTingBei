package com.ding.god.tingbei.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ding.god.tingbei.base.BaseFragment;

import java.util.List;

/**
 * Created by god on 2017/5/2.
 */

public class VPSearchResultAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;
    private String[] tabTitle;

    public VPSearchResultAdapter(FragmentManager fm, List<BaseFragment> fragments, String[] tabTitle) {
        super(fm);
        this.fragments = fragments;
        this.tabTitle = tabTitle;
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
        return tabTitle[position];
    }
}
