package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.bean.RadioTypeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */

public interface ISortView extends IBaseView {
    void addData(List<RadioTypeBean> datas);

    void clear();
    void refreshComplete();

}
