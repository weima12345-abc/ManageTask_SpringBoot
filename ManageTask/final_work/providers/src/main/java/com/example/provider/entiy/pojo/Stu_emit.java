package com.example.provider.entiy.pojo;

public class Stu_emit {
    private String biao_id;
    private String id;
    private String describe;
    private String stu_name;
    private String stu_time;

    public Stu_emit(String biao_id,String id,String describe,String stu_name,String stu_time) {
        this.biao_id=biao_id;
        this.id = id;
        this.describe=describe;
        this.stu_name=stu_name;
        this.stu_time=stu_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_time() {
        return stu_time;
    }

    public void setStu_time(String stu_time) {
        this.stu_time = stu_time;
    }

    public String getBiao_id() {
        return biao_id;
    }

    public void setBiao_id(String biao_id) {
        this.biao_id = biao_id;
    }
}
