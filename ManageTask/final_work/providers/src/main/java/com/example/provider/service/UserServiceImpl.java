package com.example.provider.service;

import com.example.provider.dao.UserDao;
import com.example.provider.entiy.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {

//    @Autowired////依赖注入，非创建对象，是从ioc容器拿对象
    @Resource
    private UserDao userDao;
//    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);


    /**
     * 查询数据库数据
     * @throws Exception
     */
    @Override
    public User uquery(String username)  {

        User u = userDao.query(username);
        return  u;

    }
    @Override
    public User uqueryYx(String email)  {

        User u = userDao.queryYx(email);
        return  u;

    }
    /**
     * 查询数据库数据
     * @throws Exception
     */
//    @Override
//    public  void secondQuery()  {
//        System.out.println("查询数据库1");
//        User s= userDao.secondQuery("张三");
//        System.out.println(s);
//
//    }

    @Override
    public String save(String name, String address, String eamil) {
try {
    userDao.save(name,address,eamil);
    return "添加用户成功";
}catch (Exception e){
    e.printStackTrace();
    System.out.println("添加用户失败");
    return "添加用户失败";
}

    }

    //教师布置作业
    @Override
    public String saveDescribe(Date start_time, String describe, Date end,String builder,int already) {

//            long before = System.currentTimeMillis();
            userDao.saveDescribe(describe,start_time,end,builder,already);
            System.out.println(builder);
//            long later = System.currentTimeMillis();
//            long waste_time=later-before;
//            Date date=new Date();
            //加入系统日志
//            userDao.saveSys("布置作业",waste_time,"/showUserListPage",builder,date);
            return "布置作业成功";



    }
    //学生提交作业
    @Override
    public String man_emitTask(String id,String describe,String stu_name) throws SQLException {
        Date date=new Date();

        try {
            long before = System.currentTimeMillis();
            userDao.emitDescribe(id,describe,stu_name,date);
            userDao.updated_alreadyId(id);
            long later = System.currentTimeMillis();
            long waste_time=later-before;
            //加入系统日志
//            userDao.saveSys("提交作业",waste_time,"/man_registerPage",stu_name,date);
            return "提交作业成功";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("提交作业失败");
            return "提交作业失败";
        }
    }

//修改密码
    @Override
    public void updated(String address,String name) {
        long before = System.currentTimeMillis();
        userDao.updated(address,name);
        long later = System.currentTimeMillis();
        long waste_time=later-before;
        Date date=new Date();
        //加入系统日志
//        userDao.saveSys("修改密码",waste_time,"/changePage",name,date);
    }
    //修改作业信息
    @Override
    public void updatedTask(String id,String describe,String end) {
        long before = System.currentTimeMillis();
        userDao.updatedTask(id,describe,end);
        long later = System.currentTimeMillis();
        long waste_time=later-before;
        Date date=new Date();
        //加入系统日志
//        userDao.saveSys("修改作业信息",waste_time,"/changePage","老师",date);
    }

//删除用户
    @Override
    public void deleted(String id,String role) {
        long before = System.currentTimeMillis();
        userDao.deleted(id);
        long later = System.currentTimeMillis();
        long waste_time=later-before;
        Date date=new Date();
        //加入系统日志
//        userDao.saveSys(role+"删除作业",waste_time,"/showUserListPage",role,date);

    }

    //获取当前点击的用户能否删除
    @Override
    public String getUserid_role(String id) {

       String role= userDao.getUserid_role(id);
       return role;
    }
//查询学生作业提交列表
//@Override
//public String[][] getUserTjBiao(String id,String role) {
//    long before = System.currentTimeMillis();
//
//    Date date=new Date();
//
//    int number= userDao.getstu_tj_List(id).length;
//    String[][] r=new  String[number][5];
//    Stu_emit[] rs= userDao.getstu_tj_List(id);
//
////        Menu menu=new Menu(rs[i].getMenuName(),rs[i].getUrl());
//
//    for (int i = 0; i < rs.length; i++) {
//        for (int j=0;j<6;j++){
//            if(j==0){
//                r[i][j]= rs[i].getBiao_id();
//
//            }
//            if(j==1){
//                r[i][j]= rs[i].getId();
//
//            } if(j==2){
//                r[i][j]= rs[i].getDescribe();
//
//            } if(j==3){
//
//                r[i][j]=rs[i].getStu_name();
//
//            } if(j==4){
//                SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                r[i][j]=rs[i].getStu_time();
//
//            }
//
//
//        }
//
//
//    }
//    long later = System.currentTimeMillis();
//
//    long waste_time=later-before;
//    //加入系统日志
//    userDao.saveSys("查询学生作业提交列表",waste_time,"/showUserListPage",role,date);
//   return r;
//}

    //查询学生作业列表
    @Override
    public String[][] selectd(String name,String builder,Date start_time,Date end_time) {
        long before = System.currentTimeMillis();

        Date date=new Date();
        int number= userDao.getUserSelectList(name,builder,start_time,end_time).length;
        String[][] r=new  String[number][6];
        Teacher_task[] rs= userDao.getUserSelectList(name,builder,start_time,end_time);

//        Menu menu=new Menu(rs[i].getMenuName(),rs[i].getUrl());

        for (int i = 0; i < rs.length; i++) {
            for (int j=0;j<6;j++){
                if(j==0){
                    r[i][j]= rs[i].getId();

                } if(j==1){
                    r[i][j]= rs[i].getDescribe();

                } if(j==2){
                    SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    r[i][j]= format0.format(rs[i].getStart_time());

                } if(j==3){
                    SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println(r[i][j]);
                    r[i][j]= format0.format(rs[i].getEnd_time());

                }
                if(j==4) {
                    r[i][j]=rs[i].getBuilder();


                }if(j==5){
                    r[i][j]=rs[i].getAlready();

                }


            }


        }
        long later = System.currentTimeMillis();

        long waste_time=later-before;
        //加入系统日志
//        userDao.saveSys("查询学生作业列表",waste_time,"/showUserListPage",builder,date);
        return r;
    }
    @Override
    public String getUserROle(String name) {
       String role= userDao.getUserROle(name);
        return  role;
    }
    @Override
    public String getUserROleYx(String name) {
        String role= userDao.getUserROleYx(name);
        return  role;
    }

    @Override
    public String[][] getUserROleMenu(String name) throws SQLException {
//Menu[] a = new Menu[0];
        List list=new ArrayList<>();
        String[][] r=new  String[5][2];
        Menu[] rs= userDao.getUserROleMenu(name);

//        Menu menu=new Menu(rs[i].getMenuName(),rs[i].getUrl());

            for (int i = 0; i < rs.length; i++) {
                for (int j=0;j<2;j++){
                    if(j==0){
                        r[i][j]=rs[i].getMenuName();
                    }else {
                        r[i][j]=rs[i].getUrl();
                    }


                }


            }


        return r;
    }

    //查询学生作业提交列表
    @Override
    public String[][] getUserTjBiao(String id,String role) {
        long before = System.currentTimeMillis();

        Date date=new Date();

        int number= userDao.getstu_tj_List(id).length;
        String[][] r=new  String[number][5];
        Stu_emit[] rs= userDao.getstu_tj_List(id);

//        Menu menu=new Menu(rs[i].getMenuName(),rs[i].getUrl());

        for (int i = 0; i < rs.length; i++) {
            for (int j=0;j<6;j++){
                if(j==0){
                    r[i][j]= rs[i].getBiao_id();

                }
                if(j==1){
                    r[i][j]= rs[i].getId();

                } if(j==2){
                    r[i][j]= rs[i].getDescribe();

                } if(j==3){

                    r[i][j]=rs[i].getStu_name();

                } if(j==4){
                    r[i][j]=rs[i].getStu_time();

                }


            }


        }


        return r;
    }

    @Override
    public String[][] getUserList() {
       int number= userDao.getUserList().length;
        String[][] r=new  String[number][6];
        Teacher_task[] rs= userDao.getUserList();

//        Menu menu=new Menu(rs[i].getMenuName(),rs[i].getUrl());
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        String time = format0.format();//这个就是把时间戳经过处理得到期望格式的时间
        for (int i = 0; i < rs.length; i++) {
            for (int j=0;j<6;j++){
                if(j==0){
                    r[i][j]= rs[i].getId();

                } if(j==1){
                    r[i][j]= rs[i].getDescribe();

                } if(j==2){

                    r[i][j]= format0.format(rs[i].getStart_time());

                } if(j==3){
                    r[i][j]= format0.format(rs[i].getEnd_time());

                }
                if(j==4) {
                    r[i][j]=rs[i].getBuilder();

                }if(j==5) {
                    r[i][j]=rs[i].getAlready();

                }


            }


        }
        return  r;
    }
    @Override
    public String[][] getSysList() {
        int number= userDao.getSysList().length;
        String[][] r=new  String[number][6];
        Sys[] rs= userDao.getSysList();

//        Menu menu=new Menu(rs[i].getMenuName(),rs[i].getUrl());
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        String time = format0.format();//这个就是把时间戳经过处理得到期望格式的时间
        for (int i = 0; i < rs.length; i++) {
            for (int j=0;j<6;j++){
                if(j==0){
                    r[i][j]= rs[i].getId();

                } if(j==1){
                    r[i][j]= rs[i].getOperate();

                } if(j==2){

                    r[i][j]= rs[i].getWaste_time();

                } if(j==3){
                    r[i][j]= rs[i].getUrl();

                }
                if(j==4) {
                    r[i][j]=rs[i].getOperate_name();

                }if(j==5) {

                    r[i][j]= format0.format(rs[i].getStart_time());
                }


            }


        }
        return  r;
    }

    @Override
    public List<User> getPageListUser(PageHelper pageHelper) {
        int rowCont = userDao.getRowCountUser();
        System.out.println(rowCont);
        pageHelper.setRowCount(rowCont);
        pageHelper.setStartRow(pageHelper.getPageSize()*pageHelper.getCurrentPageNumber() -2);
        pageHelper.setPageCount( (rowCont + pageHelper.getPageSize()-1)/pageHelper.getPageSize());
        return userDao.getPageListUser(pageHelper);
    }
}
