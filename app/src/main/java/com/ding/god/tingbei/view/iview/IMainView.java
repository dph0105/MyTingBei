package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.base.IBaseView;

import java.util.List;

/**
 * Created by god on 2017/4/6.
 */

public interface IMainView extends IBaseView {


    /**
     *
     */
    void setVPAdapter(List<BaseFragment> fragments,String[] tabTitle);
}
