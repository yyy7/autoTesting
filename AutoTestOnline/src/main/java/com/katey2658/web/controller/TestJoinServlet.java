package com.katey2658.web.controller;

import com.katey2658.web.entity.Question;
import com.katey2658.web.entity.TestInfo;
import com.katey2658.web.service.TestService;
import com.katey2658.web.service.impl.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

/**
 * Created by 11456 on 2016/12/10.
 */
public class TestJoinServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取课程号和考试编号
        String courseId=req.getParameter("courseId");
        String testId=req.getParameter("testId");

        //如果取不到就回到自己的页面
        if ((courseId==null)||(testId==null)){

            resp.sendRedirect("stuMe");
            return;
        }

        //考试服务层对象
        TestService testService=new TestServiceImpl();
        //会话对象
        HttpSession session=req.getSession();

        //查找和该次考试相关的信息

        System.out.println(courseId+"============="+testId);
        TestInfo testInfo=testService.findTestById(courseId,testId);
        if (testInfo==null){
            resp.sendRedirect("stuMe");
            return;
        }
        //将考试信息传到页面上
        session.setAttribute("testInfo",testInfo);

        //根据测试获取题目
        Collection<Question> questions=null;
        questions=testService.findQuestionsByIds(testInfo.getCourseId(),testInfo.getTestId());
        //将考试题目传到页面上
        if (questions==null){
            resp.sendRedirect("stuMe");
            return;
        }
        System.out.println("hhhhhhh+========"+questions.size());
        System.out.println(testInfo.getCourseId()+"testinfo"+testInfo.getCourseName());

        session.setAttribute("timeBegin",new Date());
        session.setAttribute("questions",questions);

        //跳转到页面
        req.getRequestDispatcher("TestGet.jsp").forward(req,resp);
    }
}