package com.ding.god.tingbei.model.bean;

import org.greenrobot.greendao.annotation.Entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/28.
 */

public class RadioBean{
    /**
     * radio_id : 517WLWrj6Gem8JR
     * live_stream : http://hls1.gzstv.com/livegztv/yinyue/index.m3u8
     * radio_name : 916 贵州音乐 iRadio
     * radio_number : FM91.6
     * start_time : 22:00
     * end_time : 23:59
     * program_name : 音乐夜飞行
     * program_describe : 最具有年代感的经典音乐，与深夜的静谧气氛融为一体。与尔东一同聆听那些属于过去的音乐故事~
     * album_id : z32QQp5KfdSghxI
     * program_list_id :
     * image_url : http://image.tinberfm.com/radiobackground/1.png
     * radio_img_url : http://image.tinberfm.com/radiobackground/1.png
     * area_short_name : 贵州
     * ts_diffence : 3705
     * program_type : 1
     * order_num : 3
     * radio_audience : 193552
     */


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

    public String getRadio_id() {
        return radio_id;
    }

    public void setRadio_id(String radio_id) {
        this.radio_id = radio_id;
    }

    public String getLive_stream() {
        return live_stream;
    }

    public void setLive_stream(String live_stream) {
        this.live_stream = live_stream;
    }

    public String getRadio_name() {
        return radio_name;
    }

    public void setRadio_name(String radio_name) {
        this.radio_name = radio_name;
    }

    public String getRadio_number() {
        return radio_number;
    }

    public void setRadio_number(String radio_number) {
        this.radio_number = radio_number;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public String getProgram_describe() {
        return program_describe;
    }

    public void setProgram_describe(String program_describe) {
        this.program_describe = program_describe;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getProgram_list_id() {
        return program_list_id;
    }

    public void setProgram_list_id(String program_list_id) {
        this.program_list_id = program_list_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getRadio_img_url() {
        return radio_img_url;
    }

    public void setRadio_img_url(String radio_img_url) {
        this.radio_img_url = radio_img_url;
    }

    public String getArea_short_name() {
        return area_short_name;
    }

    public void setArea_short_name(String area_short_name) {
        this.area_short_name = area_short_name;
    }

    public int getTs_diffence() {
        return ts_diffence;
    }

    public void setTs_diffence(int ts_diffence) {
        this.ts_diffence = ts_diffence;
    }

    public int getProgram_type() {
        return program_type;
    }

    public void setProgram_type(int program_type) {
        this.program_type = program_type;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public int getRadio_audience() {
        return radio_audience;
    }

    public void setRadio_audience(int radio_audience) {
        this.radio_audience = radio_audience;
    }
}
