package com.example.provider.entiy.pojo;

import java.util.Date;

public class Teacher_task {
    private String id;
    private String describe;
    private Date start_time;
    private Date end_time;
    private String builder;
    private String already;

    public Teacher_task(String id, String describe, Date start_time, Date end_time, String builder, String already) {
        this.id = id;
        this.describe=describe;
        this.start_time=start_time;
        this.end_time=end_time;
        this.builder=builder;
        this.already=already;
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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getAlready() {
        return already;
    }

    public void setAlready(String already) {
        this.already = already;
    }

}
