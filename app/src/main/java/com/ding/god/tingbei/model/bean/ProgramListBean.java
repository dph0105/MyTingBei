package com.ding.god.tingbei.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/5/6.
 */
@Entity
public class ProgramListBean {

    @Id(autoincrement = true)
    private Long id;
    /**
     * program_id : 3636488
     * program_file : http://od.qingting.fm/vod/00/00/0000000000000000000025760030_24.m4a
     * program_name : 弃妃女法医 预告
     * program_date : 2015-04-15 18:13:37
     * program_describe : 弃妃女法医 预告
     * program_host :
     * program_size : 1.0
     * program_duration :
     * program_logo : http://pic.qingting.fm/2015/0709/20150709175659947.jpg!400
     * radio_id :
     * radio_number :
     * program_type : 2
     * album_id : 17838
     * album_name : 弃妃女法医
     * album_logo : http://pic.qingting.fm/2015/0709/20150709175659947.jpg!400
     */

    private String program_id;
    private String program_file;
    private String program_name;
    private String program_date;
    private String program_describe;
    private String program_host;
    private String program_size;
    private String program_duration;
    private String program_logo;
    private String radio_id;
    private String radio_number;
    private String program_type;
    private String album_id;
    private String album_name;
    private String album_logo;

    @Generated(hash = 1936306292)
    public ProgramListBean(Long id, String program_id, String program_file,
            String program_name, String program_date, String program_describe,
            String program_host, String program_size, String program_duration,
            String program_logo, String radio_id, String radio_number, String program_type,
            String album_id, String album_name, String album_logo) {
        this.id = id;
        this.program_id = program_id;
        this.program_file = program_file;
        this.program_name = program_name;
        this.program_date = program_date;
        this.program_describe = program_describe;
        this.program_host = program_host;
        this.program_size = program_size;
        this.program_duration = program_duration;
        this.program_logo = program_logo;
        this.radio_id = radio_id;
        this.radio_number = radio_number;
        this.program_type = program_type;
        this.album_id = album_id;
        this.album_name = album_name;
        this.album_logo = album_logo;
    }

    @Generated(hash = 1015575514)
    public ProgramListBean() {
    }

    public String getProgram_id() {
        return program_id;
    }

    public void setProgram_id(String program_id) {
        this.program_id = program_id;
    }

    public String getProgram_file() {
        return program_file;
    }

    public void setProgram_file(String program_file) {
        this.program_file = program_file;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public String getProgram_date() {
        return program_date;
    }

    public void setProgram_date(String program_date) {
        this.program_date = program_date;
    }

    public String getProgram_describe() {
        return program_describe;
    }

    public void setProgram_describe(String program_describe) {
        this.program_describe = program_describe;
    }

    public String getProgram_host() {
        return program_host;
    }

    public void setProgram_host(String program_host) {
        this.program_host = program_host;
    }

    public String getProgram_size() {
        return program_size;
    }

    public void setProgram_size(String program_size) {
        this.program_size = program_size;
    }

    public String getProgram_duration() {
        return program_duration;
    }

    public void setProgram_duration(String program_duration) {
        this.program_duration = program_duration;
    }

    public String getProgram_logo() {
        return program_logo;
    }

    public void setProgram_logo(String program_logo) {
        this.program_logo = program_logo;
    }

    public String getRadio_id() {
        return radio_id;
    }

    public void setRadio_id(String radio_id) {
        this.radio_id = radio_id;
    }

    public String getRadio_number() {
        return radio_number;
    }

    public void setRadio_number(String radio_number) {
        this.radio_number = radio_number;
    }

    public String getProgram_type() {
        return program_type;
    }

    public void setProgram_type(String program_type) {
        this.program_type = program_type;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getAlbum_logo() {
        return album_logo;
    }

    public void setAlbum_logo(String album_logo) {
        this.album_logo = album_logo;
    }

    @Override
    public String toString() {
        return "ProgramListBean{" +
                "program_id='" + program_id + '\'' +
                ", program_file='" + program_file + '\'' +
                ", program_name='" + program_name + '\'' +
                ", program_date='" + program_date + '\'' +
                ", program_describe='" + program_describe + '\'' +
                ", program_host='" + program_host + '\'' +
                ", program_size='" + program_size + '\'' +
                ", program_duration='" + program_duration + '\'' +
                ", program_logo='" + program_logo + '\'' +
                ", radio_id='" + radio_id + '\'' +
                ", radio_number='" + radio_number + '\'' +
                ", program_type='" + program_type + '\'' +
                ", album_id='" + album_id + '\'' +
                ", album_name='" + album_name + '\'' +
                ", album_logo='" + album_logo + '\'' +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
