package com.katey2658.web.controller;


import com.katey2658.web.entity.Teacher;
import com.katey2658.web.entity.User;
import com.katey2658.web.service.TeacherService;
import com.katey2658.web.service.UserService;
import com.katey2658.web.service.impl.TeacherServiceImpl;
import com.katey2658.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 11456 on 2016/11/21.
 */
public class LoginIdentifyServlet extends HttpServlet {

    //执行Get方法提交的数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //执行Post方法提交的数据
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session对象
        HttpSession session = request.getSession();


        //获取输入请求用户名和密码
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        //System.out.println(userName+"::"+userPwd);

        //如果用户名非空就应该提示输入有空值就该返回提示
        if ((userName == null || userPwd == null) || (userName.isEmpty() || userPwd.isEmpty())) {
            //跳转到错误提示页面然后回到登录页面（）
            response.sendRedirect("login.jsp");
            return;
        } else {

            int resultCode=-2;
            if (userName.startsWith("T")) {

                TeacherService teacherService = new TeacherServiceImpl();
                //如果登录成功同时应该将该用户状态改为在线状态
                resultCode = teacherService.signIn(userName, userPwd);

                Teacher teacher = null;
                if (resultCode == 0) {
                    teacher = teacherService.findUserById(userName);
                    //学生
                    session.setAttribute("user", teacher);
                    response.sendRedirect("home.jsp");
                    return;
                }
            }else{
                UserService userService = new UserServiceImpl();
                //如果登录成功同时应该将该用户状态改为在线状态
                resultCode = userService.signIn(userName, userPwd);

                User user=null;
                if (resultCode == 0) {
                    user=userService.findUserById(userName);
                    //学生
                    session.setAttribute("user",user);
                    response.sendRedirect("home.jsp");
                    return;
                }
            }
            if(resultCode==-1){
                response.sendRedirect("login.jsp");
                return;
            }else{
                response.sendRedirect("login.jsp");
                return;
            }
        }
    }

}
