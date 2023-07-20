package com.example.provider.service;

import com.example.provider.entiy.pojo.PageHelper;
import com.example.provider.entiy.pojo.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface UserService {
    public User uquery(String username) ;
//    public  void secondQuery();
public User uqueryYx(String email);
    public String save(String name, String address, String eamil) throws SQLException;
    public String saveDescribe(Date start_time,String describe,Date end,String builder,int already);
    public String man_emitTask(String id, String describe, String stu_name) throws SQLException;
    public void updated(String address,String name);
    public void updatedTask(String id,String describe,String end);
    public void deleted(String id,String role);
    public String[][] selectd(String name,String builder,Date start_time,Date end_time);
    public String getUserROle(String name);
    public String getUserROleYx(String id);
    public String getUserid_role(String id);

    public String[][] getUserROleMenu(String name) throws SQLException;
    public String[][] getUserTjBiao(String id,String role) throws SQLException;

    public String[][] getUserList();
    public String[][] getSysList();
    public List<User> getPageListUser(PageHelper pageHelper);
}
