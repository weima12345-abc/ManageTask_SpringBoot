package com.example.provider.dao;

import com.example.provider.entiy.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import java.util.Date;
import java.util.List;

public interface UserDao {


    @Select("select * from user where name = #{username1}")
    public  User query(String username);

    @Select("select * from user where email = #{email}")
    public  User queryYx(String eamil);

    @Insert("insert into user(name,address,roleID,email) values( #{name},#{address},0,#{email})")
    public void save(@Param("name") String name, @Param("address")  String address,@Param("email") String email);

    @Insert("INSERT into teacher_task(teacher_task.describe, start_time,end_time,builder,already) values(#{describe},#{start_time},#{end},#{builder},#{already} )")
    public void saveDescribe(@Param("describe") String describe, @Param("start_time") Date start_time, @Param("end") Date end,@Param("builder") String builder,@Param("already") int already);

//    @Insert("INSERT into sys(operate, waste_time,url,operate_name,start_time) values(#{operate},#{waste_time},#{url},#{operate_name},#{start_time} )")
//    public void saveSys( String operate,long waste_time,String url,String operate_name,Date start_time);

    @Insert("INSERT into tea_already_biao(id,tea_already_biao.describe,stu_name,stu_time) values(#{id},#{describe},#{stu_name},#{stu_time} )")
    public void emitDescribe(@Param("id") String id,@Param("describe") String describe,@Param("stu_name") String  stu_name,@Param("stu_time") Date stu_time);

    @Update("update teacher_task set already=already+1 where id=#{id}")
    public void updated_alreadyId(String id);


    @Select("select * from user  order by name limit #{startRow},#{pageSize}" )
    public List<User> getPageListUser(PageHelper pageHelper);

    @Select("select count(*) from user ")
    public int getRowCountUser();

    @Update("update user set address=#{address} where name=#{name}")
    public void updated(@Param("address") String pw,@Param("name") String name);


    @Update("update teacher_task  set teacher_task.describe=#{decribe} , end_time=#{end} where id=#{id}")
    public void updatedTask(@Param("id") String id,@Param("decribe") String decribe,@Param("end") String end);


    @Delete("delete from teacher_task  where id=#{id}")
    public void deleted( String id);

    @Select("SELECT roleName FROM user LEFT JOIN role on user.roleID=role.roleID WHERE id=#{id}")
    public String getUserid_role(String id);

    @Select("SELECT roleName FROM user LEFT JOIN role on user.roleID=role.roleID WHERE name=#{name}")
    public  String getUserROle(String name);

    @Select("SELECT roleName FROM user LEFT JOIN role on user.roleID=role.roleID WHERE email=#{name}")
    public  String getUserROleYx(String name);

    @Select("SELECT c.menuName,c.url FROM role a LEFT JOIN role_menu b on a.roleID=b.roleID LEFT JOIN menu c on b.menuid=c.menuid  WHERE a.roleName=#{role}")
    public Menu[] getUserROleMenu(String name);

    @Select("SELECT *from teacher_task")
    public  Teacher_task[] getUserList();

    @Select("SELECT *from sys")
    public  Sys[] getSysList();

    @Select("SELECT *from tea_already_biao where id=#{id}")
    public  Stu_emit[] getstu_tj_List(String id);

    @Select("SELECT *FROM teacher_task WHERE teacher_task.describe=#{describe} or builder=#{builder} or start_time>=#{start_time} AND end_time<=#{end_time}")
    public Teacher_task[] getUserSelectList(@Param("describe") String describe,@Param("builder") String builder,@Param("start_time") Date start_time,@Param("end_time") Date end_time);



}

