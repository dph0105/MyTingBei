package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.bean.RadioCategoryBean;
import com.ding.god.tingbei.model.bean.RadioGroupBean;

import java.util.List;

/**
 * Created by god on 2017/4/25.
 */

public interface IRadioView extends IBaseView {

    void addCategoryData(List<RadioCategoryBean.StyleBean> datas);

    void addRadioGroupData(RadioGroupBean data);

}
