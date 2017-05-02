package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.bean.SearchResultAllBean;
import com.ding.god.tingbei.model.bean.SearchResultTypeBean;

import java.util.List;

/**
 * Created by god on 2017/5/2.
 */

public interface ISearchResultListView extends IBaseView {
    void addData(List<SearchResultAllBean> datas);

    void addTypeData(List<SearchResultTypeBean> datas);
}
