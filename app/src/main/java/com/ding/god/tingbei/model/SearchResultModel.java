package com.ding.god.tingbei.model;

import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.base.BaseModel;
import com.ding.god.tingbei.view.fragment.SearchResultListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by god on 2017/5/2.
 */

public class SearchResultModel extends BaseModel {
    private String[] tabTitle = new String[]{"全部","专辑","电台","节目"};

    public String[] getTabTitle() {
        return tabTitle;
    }

    public List<BaseFragment> getFragments(){
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(SearchResultListFragment.newInstance(0));
        fragments.add(SearchResultListFragment.newInstance(1));
        fragments.add(SearchResultListFragment.newInstance(2));
        fragments.add(SearchResultListFragment.newInstance(3));
        return fragments;
    }
}
