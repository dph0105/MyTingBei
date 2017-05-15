package com.ding.god.tingbei.dbbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/5/15.
 */
@Entity
public class PlayRadioHistory {
    @Id(autoincrement = true)
    private Long id;

    private String radio_id;
    private String live_stream;
    private String radio_name;
    private String radio_number;
    private String start_time;
    private String end_time;
    private String program_name;
    private String program_describe;
    private String album_id;
    private String program_list_id;
    private String image_url;
    private String radio_img_url;
    private String area_short_name;
    private int ts_diffence;
    private int program_type;
    private int order_num;
    private int radio_audience;
    private long listenTime;
    @Generated(hash = 1611884484)
    public PlayRadioHistory(Long id, String radio_id, String live_stream,
            String radio_name, String radio_number, String start_time,
            String end_time, String program_name, String program_describe,
            String album_id, String program_list_id, String image_url,
            String radio_img_url, String area_short_name, int ts_diffence,
            int program_type, int order_num, int radio_audience, long listenTime) {
        this.id = id;
        this.radio_id = radio_id;
        this.live_stream = live_stream;
        this.radio_name = radio_name;
        this.radio_number = radio_number;
        this.start_time = start_time;
        this.end_time = end_time;
        this.program_name = program_name;
        this.program_describe = program_describe;
        this.album_id = album_id;
        this.program_list_id = program_list_id;
        this.image_url = image_url;
        this.radio_img_url = radio_img_url;
        this.area_short_name = area_short_name;
        this.ts_diffence = ts_diffence;
        this.program_type = program_type;
        this.order_num = order_num;
        this.radio_audience = radio_audience;
        this.listenTime = listenTime;
    }
    @Generated(hash = 1420153886)
    public PlayRadioHistory() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRadio_id() {
        return this.radio_id;
    }
    public void setRadio_id(String radio_id) {
        this.radio_id = radio_id;
    }
    public String getLive_stream() {
        return this.live_stream;
    }
    public void setLive_stream(String live_stream) {
        this.live_stream = live_stream;
    }
    public String getRadio_name() {
        return this.radio_name;
    }
    public void setRadio_name(String radio_name) {
        this.radio_name = radio_name;
    }
    public String getRadio_number() {
        return this.radio_number;
    }
    public void setRadio_number(String radio_number) {
        this.radio_number = radio_number;
    }
    public String getStart_time() {
        return this.start_time;
    }
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getEnd_time() {
        return this.end_time;
    }
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    public String getProgram_name() {
        return this.program_name;
    }
    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }
    public String getProgram_describe() {
        return this.program_describe;
    }
    public void setProgram_describe(String program_describe) {
        this.program_describe = program_describe;
    }
    public String getAlbum_id() {
        return this.album_id;
    }
    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }
    public String getProgram_list_id() {
        return this.program_list_id;
    }
    public void setProgram_list_id(String program_list_id) {
        this.program_list_id = program_list_id;
    }
    public String getImage_url() {
        return this.image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public String getRadio_img_url() {
        return this.radio_img_url;
    }
    public void setRadio_img_url(String radio_img_url) {
        this.radio_img_url = radio_img_url;
    }
    public String getArea_short_name() {
        return this.area_short_name;
    }
    public void setArea_short_name(String area_short_name) {
        this.area_short_name = area_short_name;
    }
    public int getTs_diffence() {
        return this.ts_diffence;
    }
    public void setTs_diffence(int ts_diffence) {
        this.ts_diffence = ts_diffence;
    }
    public int getProgram_type() {
        return this.program_type;
    }
    public void setProgram_type(int program_type) {
        this.program_type = program_type;
    }
    public int getOrder_num() {
        return this.order_num;
    }
    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }
    public int getRadio_audience() {
        return this.radio_audience;
    }
    public void setRadio_audience(int radio_audience) {
        this.radio_audience = radio_audience;
    }
    public long getListenTime() {
        return this.listenTime;
    }
    public void setListenTime(long listenTime) {
        this.listenTime = listenTime;
    }

}
