package com.ding.god.tingbei.model.bean;

/**
 * Created by Administrator on 2017/5/6.
 */

public class AlbumInfoBean {

    /**
     * album_id : 17838
     * album_logo : http://pic.qingting.fm/2015/0709/20150709175659947.jpg!400
     * album_name : 弃妃女法医
     * album_describe : 想她一介21世纪女法医，一朝穿越，居然被一个乳臭未干的王爷给耍了！NND，老虎不发威，你当我是HELLOKITTY！士可杀不可辱，想跟姑奶奶玩，她就跟他斗上一斗。将她赶出家门，成！她跟外放病秧子少爷去外地做官，名声鹊起。呦，小王爷追来了？可姑奶奶不想玩了，哪远滚哪！　演播：饭粥、言哥
     * show_episodes : 1
     * web_url : http://m.qingting.fm/vchannels/103028
     * album_host :
     * category_tip : 穿越架空
     * source_name : 蜻蜓FM
     * total : 167
     * page : {"1-20":"1","21-40":"2","41-60":"3","61-80":"4","81-100":"5","101-120":"6","121-140":"7","141-160":"8","161-167":"9"}
     */

    private String album_id;
    private String album_logo;
    private String album_name;
    private String album_describe;
    private String show_episodes;
    private String web_url;
    private String album_host;
    private String category_tip;
    private String source_name;
    private String total;
    private PageBean page;

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_logo() {
        return album_logo;
    }

    public void setAlbum_logo(String album_logo) {
        this.album_logo = album_logo;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getAlbum_describe() {
        return album_describe;
    }

    public void setAlbum_describe(String album_describe) {
        this.album_describe = album_describe;
    }

    public String getShow_episodes() {
        return show_episodes;
    }

    public void setShow_episodes(String show_episodes) {
        this.show_episodes = show_episodes;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getAlbum_host() {
        return album_host;
    }

    public void setAlbum_host(String album_host) {
        this.album_host = album_host;
    }

    public String getCategory_tip() {
        return category_tip;
    }

    public void setCategory_tip(String category_tip) {
        this.category_tip = category_tip;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class PageBean {
    }
}
