package com.ding.god.tingbei.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.base.BaseModel;
import com.ding.god.tingbei.view.fragment.ContentIntroductionFragment;
import com.ding.god.tingbei.view.fragment.ProgramListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */

public class AlbumModel extends BaseModel {

    private List<BaseFragment> fragments;
    private String[] tabTitle = new String[]{"专辑介绍","节目详情"};
    public AlbumModel() {
        fragments = new ArrayList<>();
    }

    public void setData(String album_id, String album_type,String program_id){
        Bundle bundle = new Bundle();
        bundle.putString("album_id",album_id);
        bundle.putString("album_type",album_type);
        bundle.putString("program_id",program_id);
        fragments.add(ContentIntroductionFragment.newInstance());
        ProgramListFragment programListFragment = ProgramListFragment.newInstance();
        programListFragment.setArguments(bundle);
        fragments.add(programListFragment);
    }

    public List<BaseFragment> getFragments() {
        return fragments;
    }

    public String[] getTabTitle() {
        return tabTitle;
    }
}
