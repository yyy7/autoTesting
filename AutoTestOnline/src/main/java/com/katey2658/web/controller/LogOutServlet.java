package com.katey2658.web.controller;

import com.katey2658.web.entity.User;
import com.katey2658.web.service.UserService;
import com.katey2658.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 11456 on 2016/12/11.
 */
public class LogOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        //退出操作

        //用户
        User user=null;
        user= (User) session.getAttribute("user");

        //将用户信息改为离线状态
        UserService userService=new UserServiceImpl();
        userService.logOut(user.getUserId());

        //从session中移除
        session.removeAttribute("user");
        //使得当前会话无效
        session.invalidate();
        //从当前页面重定向到首页
        resp.sendRedirect("home.jsp");
    }
}
