package com.ding.god.tingbei.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ding.god.tingbei.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */

public class VPAlbumAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;
    private String[] tabTitle;

    public VPAlbumAdapter(FragmentManager fm, List<BaseFragment> fragments, String[] tabTitle) {
        super(fm);
        this.fragments = fragments;
        this.tabTitle = tabTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
