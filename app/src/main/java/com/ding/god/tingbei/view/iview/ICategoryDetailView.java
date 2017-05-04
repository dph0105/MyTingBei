package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.bean.RadioByTypeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */

public interface ICategoryDetailView extends IBaseView {
    void addData(List<RadioByTypeBean> datas);
    void loadMore();
    void refresh();
}
