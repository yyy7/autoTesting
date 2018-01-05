package com.katey2658.web.controller;

import com.katey2658.web.entity.User;
import com.katey2658.web.service.UserService;
import com.katey2658.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11456 on 2016/12/10.
 */
public class UserRegistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //教工号（学号，老师）唯一
        String userId=req.getParameter("userId");
        //邮箱 唯一
        String userMail=req.getParameter("userMail");
        //姓名
        String userName=req.getParameter("userName");
        //密码1
        String userPwd=req.getParameter("userPwd");
        //性别
        String userSex=req.getParameter("userSex");
        //年龄
        int userAge=Integer.valueOf(req.getParameter("userAge"));
        //家庭地址
        String userAddr=req.getParameter("userAddr");
        //级别（老师/学生）
        String userProfession=req.getParameter("userProfession");

        //获得一个用户服务对象
        UserService userService=new UserServiceImpl();

        System.out.println(userId+":"+userMail+":"+userName+":"+userPwd+":"+userSex+":"+userAge+":"+userAddr+":"+userProfession);

        //如果用户号，和用户邮箱，或者用户密码有一个没有填写，就应该退出让重新注册
        if ((userId==null)||(userMail==null)||(userPwd==null)){
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }

        //注册用户
        User user=new User();
        user.setUserId(userId);
        user.setUserMail(userMail);
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        user.setSex(userSex);
        user.setUserAge(userAge);
        user.setAddress(userAddr);
        user.setActive(true);

        userService.signUp(user);

        //返回页面
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }
}
