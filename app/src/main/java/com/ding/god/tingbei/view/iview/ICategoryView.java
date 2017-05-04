package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.bean.RadioTypeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */

public interface ICategoryView extends IBaseView {

    void setAdapter(List<RadioTypeBean> datas);
}
