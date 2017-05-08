package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.bean.RadioBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public interface IRadioListView extends IBaseView {

    void addData(List<RadioBean> datas);
}
