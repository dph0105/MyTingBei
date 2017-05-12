package com.ding.god.tingbei.model;

import com.ding.god.tingbei.base.BaseModel;
import com.ding.god.tingbei.model.bean.ProgramInfoBean;

/**
 * Created by Administrator on 2017/5/12.
 */

public class ProgramPlayModel extends BaseModel {

    private ProgramInfoBean programInfoBean;

    public ProgramInfoBean getProgramInfoBean() {
        return programInfoBean;
    }

    public void setProgramInfoBean(ProgramInfoBean programListBean) {
        this.programInfoBean = programListBean;
    }

}
