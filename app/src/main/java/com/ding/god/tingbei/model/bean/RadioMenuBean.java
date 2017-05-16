package com.ding.god.tingbei.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/5/16.
 */
@Entity
public class RadioMenuBean {
    @Id(autoincrement = true)
    private Long id;
    private Long fid;
    /**
     * album_id : 8tKgyNXTHT9BWtP
     * program_name : 音乐More and More
     * program_describe : 为你私人定制的音乐电台，让我们一起来收听最好的音乐
     * start_time : 00:00
     * end_time : 05:00
     * program_host : RCS轮播
     * phone_no :
     * day : 7
     * live_stream : http://hls1.gzstv.com/livegztv/yinyue/index.m3u8
     * radio_name : 916 贵州音乐 iRadio
     * program_type : 1
     */

    private String album_id;
    private String program_name;
    private String program_describe;
    private String start_time;
    private String end_time;
    private String program_host;
    private String phone_no;
    private String day;
    private String live_stream;
    private String radio_name;
    private int program_type;

    @Generated(hash = 2078436703)
    public RadioMenuBean(Long id, Long fid, String album_id, String program_name,
            String program_describe, String start_time, String end_time,
            String program_host, String phone_no, String day, String live_stream,
            String radio_name, int program_type) {
        this.id = id;
        this.fid = fid;
        this.album_id = album_id;
        this.program_name = program_name;
        this.program_describe = program_describe;
        this.start_time = start_time;
        this.end_time = end_time;
        this.program_host = program_host;
        this.phone_no = phone_no;
        this.day = day;
        this.live_stream = live_stream;
        this.radio_name = radio_name;
        this.program_type = program_type;
    }

    @Generated(hash = 322703331)
    public RadioMenuBean() {
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
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

    public String getProgram_host() {
        return program_host;
    }

    public void setProgram_host(String program_host) {
        this.program_host = program_host;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public int getProgram_type() {
        return program_type;
    }

    public void setProgram_type(int program_type) {
        this.program_type = program_type;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return this.fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

}
