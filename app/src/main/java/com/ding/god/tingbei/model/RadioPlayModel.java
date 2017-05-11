package com.ding.god.tingbei.model;

import com.ding.god.tingbei.base.BaseModel;
import com.ding.god.tingbei.model.bean.RadioInfoBean;

/**
 * Created by Administrator on 2017/5/8.
 */

public class RadioPlayModel extends BaseModel {
    private RadioInfoBean radioInfoBean;

    public RadioInfoBean getRadioInfoBean() {
        return radioInfoBean;
    }

    public void setRadioInfoBean(RadioInfoBean radioInfoBean) {
        this.radioInfoBean = radioInfoBean;
    }
}
