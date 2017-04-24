package com.ding.god.tingbei.model;

import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.base.BaseModel;
import com.ding.god.tingbei.view.fragment.ChoicenessFragment;
import com.ding.god.tingbei.view.fragment.MineFragment;
import com.ding.god.tingbei.view.fragment.RadioFragment;
import com.ding.god.tingbei.view.fragment.SortFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by god on 2017/4/6.
 */

public class MainModel extends BaseModel{
    public String[] getTabTitle() {
        String[] tabTitle = {"精选", "电台", "分类", "我的"};
        return tabTitle;
    }

    public List<BaseFragment> getFragments(){
        //初始化ViewPager中的Fragment集合
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(ChoicenessFragment.newInstance());
        fragments.add(RadioFragment.newInstance());
        fragments.add(SortFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        return fragments;
    }
}
