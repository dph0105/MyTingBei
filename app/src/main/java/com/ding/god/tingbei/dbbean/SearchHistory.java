package com.ding.god.tingbei.dbbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by Administrator on 2017/5/3.
 */
@Entity
public class SearchHistory {
    @Id(autoincrement = true)
    private Long id;
    private String searchName;


    @Generated(hash = 241337904)
    public SearchHistory(Long id, String searchName) {
        this.id = id;
        this.searchName = searchName;
    }
    @Generated(hash = 1905904755)
    public SearchHistory() {
    }


    public Long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSearchName() {
        return this.searchName;
    }
    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
