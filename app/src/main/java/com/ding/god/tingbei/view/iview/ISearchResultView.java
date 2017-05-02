package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.base.IBaseView;

import java.util.List;

/**
 * Created by god on 2017/5/2.
 */

public interface ISearchResultView extends IBaseView {

    void setVPAdapter(List<BaseFragment> fragments,String[] tabTitle);

}
