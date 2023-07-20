package com.example.provider.entiy.pojo;

import java.util.Date;

public class Sys {
    private String id;
    private String operate;
    private String waste_time;
    private String url;
    private String operate_name;
    private Date start_time;

    public Sys(String id,String operate,String waste_time,String url,String operate_name,Date start_time) {
        this.id=id;
        this.operate = operate;
        this.waste_time=waste_time;
        this.url=url;
        this.operate_name=operate_name;
        this.start_time=start_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getWaste_time() {
        return waste_time;
    }

    public void setWaste_time(String waste_time) {
        this.waste_time = waste_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOperate_name() {
        return operate_name;
    }

    public void setOperate_name(String operate_name) {
        this.operate_name = operate_name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
}
