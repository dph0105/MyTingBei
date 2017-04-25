package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.bean.ChoicenessBean;

/**
 * Created by god on 2017/4/11.
 */

public interface IChoicenessView extends IBaseView {


    void addData(ChoicenessBean data);

    void clearData();

    void refreshComplete();
}
