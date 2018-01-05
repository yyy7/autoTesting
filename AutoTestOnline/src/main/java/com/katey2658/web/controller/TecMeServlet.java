package com.katey2658.web.controller;

import com.katey2658.web.entity.Score;
import com.katey2658.web.entity.Teacher;
import com.katey2658.web.entity.TestInfo;
import com.katey2658.web.entity.User;
import com.katey2658.web.service.TestService;
import com.katey2658.web.service.impl.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by 11456 on 2016/12/10.
 */
public class TecMeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取一个会话对象
        HttpSession session =req.getSession();

        //实例化一个TestService对象
        TestService testService=new TestServiceImpl();

        //获取当前对象
        Teacher teacher=null;
        teacher= (Teacher) session.getAttribute("user");
        String teacherId=teacher.getTeacherId();

        //获取正在进行考试的结果状态集
        Collection<TestInfo> testInfosNow=null;
        testInfosNow=testService.findTestNowByTecId(teacherId);
        System.out.println("-----+-="+testInfosNow.size());
        req.setAttribute("testInfosNow",testInfosNow);

        //获取正在已经结束的考试状态集
        Collection<TestInfo> testInfosPass=null;
        testInfosPass=testService.findTestPassByTecId(teacherId);
        System.out.println("-----+="+testInfosPass.size());
        req.setAttribute("testInfosPass",testInfosPass);

        //转到教师自我的主页
        req.getRequestDispatcher("tecMe.jsp").forward(req,resp);
    }
}
