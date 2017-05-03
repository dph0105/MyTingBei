package com.ding.god.tingbei.rx.event;

/**
 * Created by Administrator on 2017/5/3.
 */

public class SearchEvent {
    private String searchName;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public SearchEvent(String searchName) {
        this.searchName = searchName;
    }
}
