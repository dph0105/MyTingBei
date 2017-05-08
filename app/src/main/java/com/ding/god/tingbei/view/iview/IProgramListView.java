package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.bean.ProgramListBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */

public interface IProgramListView extends IBaseView {

    void addData(List<ProgramListBean> datas);

}
