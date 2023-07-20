package com.example.provider.controller;

import com.example.provider.entiy.pojo.User;
import com.example.provider.entiy.Result;
import com.example.provider.entiy.pojo.PageHelper;
import com.example.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//@RestController
//@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Value("${server.port}")
    private String port;


    @GetMapping("/toHtml")
    public String toHtml() {

        return  "a";
    }








    @Autowired
//    private MailClient mailClient;


    @RequestMapping("/index")
    public String index(){
        return "index";
    }



    @RequestMapping("/changePage")
    public String change(){
        return "change";
    }
    @RequestMapping("/showUserListPage")
    public String showUserListPage(){
        return "showUserList";
    }

    //获取作业提交列表
    @RequestMapping("/getUserList")
    @ResponseBody
    public String[][] showUserList(){
        String[][] list=userService.getUserList();
//        System.out.println(list);
        return list;

    }
    //获取系统日志列表
    @RequestMapping("/getSysList")
    @ResponseBody
    public String[][] getSysList(){
        String[][] list=userService.getSysList();
//        System.out.println(list);
        return list;

    }
    //获取当前点击的用户能否删除
    @RequestMapping("/getUserid_role")
    @ResponseBody
    public String getUserid_role(String id){
        String role=userService.getUserROleYx(id);

        return role;
    }
    //得到用户登录的权限
    @RequestMapping("/getUserROle")
    @ResponseBody
    public String getUserROle(String name){
        String role=userService.getUserROle(name);
        return role;
    }
    //获取邮箱登录之后的权限名，admin
    @RequestMapping("/getUserROleYx")
    @ResponseBody
    public String getUserROleYx(String name){
        String role=userService.getUserROleYx(name);

        return role;
    }

    //设置用户登录的权限session
    @RequestMapping("/setUserROleSession")
    @ResponseBody
    public void setUserROleSession(String role, HttpServletRequest request){
        HttpSession session= request.getSession();
        session.setAttribute("userRole",role);

        String userRole=(String) request.getSession().getAttribute("userRole");

    }

    //得到用户登录的权限session
    @RequestMapping("/getUserROleSession")
    @ResponseBody
    public String getUserROleSession( HttpServletRequest request){



        String userRole=(String) request.getSession().getAttribute("userRole");
        return userRole;
    }

    //设置用户登录的用户名session
    @RequestMapping("/setUserSession")
    @ResponseBody
    public void setUserSession(String userName, HttpServletRequest request){
        HttpSession session= request.getSession();
        session.setAttribute("userName",userName);

        String userRole=(String) request.getSession().getAttribute("userName");

    }

    //得到用户登录的用户名session
    @RequestMapping("/getUserSession")
    @ResponseBody
    public String getUserSession( HttpServletRequest request){

        String userName=(String) request.getSession().getAttribute("userName");
        return userName;
    }

    //设置邮箱登录的用户名session
    @RequestMapping("/setUser_yxSession")
    @ResponseBody
    public void setUser_yxSession(String userName, HttpServletRequest request){
        HttpSession session= request.getSession();
        session.setAttribute("useryx",userName);

        String userRole=(String) request.getSession().getAttribute("useryx");

    }

    //得到邮箱登录的用户名session
    @RequestMapping("/getUser_yxSession")
    @ResponseBody
    public String getUser_yxSession( HttpServletRequest request){

        String userName=(String) request.getSession().getAttribute("useryx");
        return userName;
    }

    //设置邮箱登录的权限session
    @RequestMapping("/setUserYxROleSession")
    @ResponseBody
    public void setUserYxROleSession(String role, HttpServletRequest request){
        HttpSession session= request.getSession();
        session.setAttribute("userYxRole",role);

        String userRole=(String) request.getSession().getAttribute("userYxRole");

    }

    //设置学生提交作业时，某个作业的id的session
    @RequestMapping("/setTaskIdSession")
    @ResponseBody
    public void setTaskIdSession(String id, HttpServletRequest request){
        HttpSession session= request.getSession();
        session.setAttribute("TaskId",id);



    }
    //得到邮箱登录的权限session
    @RequestMapping("/getTaskIdSession")
    @ResponseBody
    public String getTaskIdSession( HttpServletRequest request){


        String TaskId=(String) request.getSession().getAttribute("TaskId");
        return TaskId;
    }

    //得到邮箱登录的权限session
    @RequestMapping("/getUserYxROleSession")
    @ResponseBody
    public String getUserYxROleSession( HttpServletRequest request){



        String userRole=(String) request.getSession().getAttribute("userYxRole");
        return userRole;
    }


    //修改密码
    @RequestMapping("/changePersonPw")
    @ResponseBody
    public String changePersonPw(String address1,String name){
        try {
            String address =md5(address1);
            System.out.println(address);
            System.out.println(name);
            userService.updated(address,name);
            return "修改密码成功";
        }catch (Exception e){
            e.printStackTrace();
            return "修改密码失败";
        }

    }

    @RequestMapping("/changeTaskPage")

    public String changeTaskPage(){

        return "changeTask";
    }
    //修改作业信息
    @RequestMapping("/changeTask")
    @ResponseBody
    public String changeTask(String id,String describe,String end_time){
        try {

            userService.updatedTask(id,describe,end_time);
            return "修改作业信息成功";
        }catch (Exception e){
            e.printStackTrace();
            return "修改作业信息失败";
        }

    }
    //删除
    @RequestMapping("/deleted")
    @ResponseBody
    public String deleted(String id ,String role){
        try {
            userService.deleted(id,role);
            return "删除成功";
        }catch (Exception e){
            e.printStackTrace();
            return "删除失败!";
        }



    }

    //查询

    @RequestMapping("/selectd")
    @ResponseBody
    public String[][] selectd(String describe,String builder,String start_time1,String end_time1) throws ParseException {

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date start_time= simpleDateFormat.parse(start_time1);
            Date end_time= simpleDateFormat.parse(end_time1);

            if(start_time1==null&&end_time1==null){
                System.out.println(start_time1);
                System.out.println(start_time1.getClass());
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.YEAR, 1);
                Date oneYearLater = calendar.getTime();
                String[][] a=  userService.selectd(describe,builder,end_time,oneYearLater);
                return a;
            }else {
                String[][] a=  userService.selectd(describe,builder,start_time,end_time);
                return a;
            }


        }catch (Exception e){
            e.printStackTrace();
            String[][] b=new  String[2][2];
            return b;
        }



    }

    //查询学生提交作业记录
    @RequestMapping("/getUserTjBiao")
    @ResponseBody
    public String[][] getUserTjBiao(String id,String role) throws ParseException {

        try {
            String[][] a=  userService.getUserTjBiao(id,role);
            return a;
        }catch (Exception e){
            e.printStackTrace();
            String[][] b=new  String[2][2];
            return b;
        }



    }
    @RequestMapping("/getUser")
    @ResponseBody
    public String[] getUser(String name) throws SQLException {

        User u=userService.uquery(name);
//        System.out.println(list);
        String[] r=new  String[5];

        r[0]=u.getId();
        r[1]=u.getName();
        r[2]=u.getAddress();
        r[3]=u.getEmail();
        r[4]=u.getRoleName();


        return r;
    }
    @RequestMapping("/getUserYx")
    @ResponseBody
    public String[] getUserYx(String name) throws SQLException {

        User u=userService.uqueryYx(name);
//        System.out.println(list);
        String[] r=new  String[5];

        r[0]=u.getId();
        r[1]=u.getName();
        r[2]=u.getAddress();
        r[3]=u.getEmail();
        r[4]=u.getRoleName();


        return r;
    }
    @RequestMapping("/getUserROleMenu")
    @ResponseBody
    public String[][] getUserROleMenu(String role) throws SQLException {

        String[][] list=userService.getUserROleMenu(role);
//        System.out.println(list);

        return list;
    }

    @RequestMapping("/personal")

    public String personal() throws SQLException {

        return "person";
    }

    //权限控制

    /**
     * 进入管理用户列表页面
     * @return
     */



    @RequestMapping("/tologin")
    public String toLoginPage(){

        return "Login";
    }
    @RequestMapping("/man_registerPage")
    public String man_registerPage(){

        return "man_registerPage";
    }
    @RequestMapping("/man_emitTask")
    @ResponseBody
    public String man_emitTask(String id,String describe,String stu_name) throws SQLException {

        String rs=   userService.man_emitTask(id,describe,stu_name);
        return rs;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public boolean logout(HttpServletRequest httpServletRequest){

        try {
            httpServletRequest.getSession().invalidate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }

    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(User user, HttpServletRequest request) throws UnsupportedEncodingException {

        ModelAndView mv = new ModelAndView();
        PageHelper pageHelper = new PageHelper();
//        String code2 = (String) request.getSession().getAttribute("code1");
//        String name = (String) request.getSession().getAttribute("username");
//        String password = (String) request.getSession().getAttribute("password");
//        String code = (String) request.getSession().getAttribute("code");
        HttpSession session= request.getSession();
        session.setAttribute("login",user);
//        if(!r_code.equals(code) ){
//            mv.addObject("msg","验证码不对");
//            mv.setViewName("Login");
//            return  "验证码不正确";
//        }



        String password=user.getAddress();
        password=md5(password);

        user.setAddress(password);
        //根据用户名，从数据库里取用户信息

        User u = userService.uquery(user.getName());
        //取不到，用户名不存在
        if(u == null ){
            return  "用户名不存在";
        }
        //取到了，判断密码正确性
        if(!u.getAddress().equals(user.getAddress())){
            return "用户密码不正确";
        }
        return "登陆成功";
    }
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user,HttpServletRequest request) throws NoSuchAlgorithmException, SQLException, MessagingException {


        System.out.println("处理注册");

        //判断密码和确认密码是否相等
        //从数据库查数据，没有用户名就注册
        //插入数据

        ModelAndView mv = new ModelAndView();
//
//        if(!r_code.equals(code) ){
//            mv.addObject("msg","验证码不对");
//            mv.setViewName("Login");
//            return  "验证码不正确";
//        }
        //md5加密

        String password=user.getAddress();
        String str=md5(password);
        user.setAddress(str);



        //根据用户名，从数据库里取用户信息

        User u = userService.uquery(user.getName());
        //取到，用户名存在
        if(u != null ){
            return  "用户名存在";
        }


        else {

            String mess= userService.save(user.getName(),user.getAddress(),user.getEmail());
            if(mess=="添加用户成功"){
                return "注册成功";
            }else {
                return "邮箱已被注册过";
            }
        }

    }

    @RequestMapping("/man_register")
    @ResponseBody
    public String man_register(String name , String z_end,String builder, HttpServletRequest request) throws NoSuchAlgorithmException, SQLException, MessagingException, ParseException {
        System.out.println("处理教师布置作业操作");
        System.out.println(builder);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        2022-12-02T14:33
        Date end= simpleDateFormat.parse(z_end);
        Date start_time=new Date();
        int already=0;

//系统日志





        String mess= userService.saveDescribe(start_time,name,end,builder,already);
        return  mess;



    }
//    @InitBinder
//    public void initBinder(WebDataBinder binder, WebRequest request) {
//        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
//        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
//    }

    @RequestMapping("/login_yx")
    @ResponseBody
    public String loginyx(User user,String r_code, HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println("用户点击提交去登陆");
        ModelAndView mv = new ModelAndView();
        PageHelper pageHelper = new PageHelper();
//        String code2 = (String) request.getSession().getAttribute("code1");
//        String name = (String) request.getSession().getAttribute("username");
        String code = (String) request.getSession().getAttribute("code");
        HttpSession session= request.getSession();
        session.setAttribute("login_yx",user);
        if(!r_code.equals(code) ){
            mv.addObject("msg","验证码不对");
            mv.setViewName("Login");
            return  "验证码不正确";
        }



        String password=user.getAddress();

        password=md5(password);

        user.setAddress(password);
        //根据用户名，从数据库里取用户信息

        User u = userService.uqueryYx(user.getEmail());
        //取不到，用户名不存在
        if(u == null ){
            return  "邮箱不存在";
        }
        //取到了，判断密码正确性
        if(!u.getAddress().equals(user.getAddress())){
            return "用户密码不正确";
        }
        return "登陆成功";
    }



}
