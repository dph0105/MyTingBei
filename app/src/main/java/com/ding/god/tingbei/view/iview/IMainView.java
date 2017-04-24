package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.base.IBaseView;

import java.util.List;

/**
 * Created by god on 2017/4/6.
 */

public interface IMainView extends IBaseView {

    /**
     * 点击搜索按钮跳转到搜索页面
     */
    void toSearchActivity();

    /**
     *
     */
    void setVPAdapter(List<BaseFragment> fragments,String[] tabTitle);
}
