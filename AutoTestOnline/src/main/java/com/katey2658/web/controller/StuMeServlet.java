package com.katey2658.web.controller;

import com.katey2658.web.entity.Score;
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
public class StuMeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取一个会话对象
        HttpSession session =req.getSession();

        //实例化一个TestService对象
        TestService testService=new TestServiceImpl();

        //获取当前对象
        User user=null;
        user= (User) session.getAttribute("user");
        String userId=user.getUserId();

        //获取待考试的集合
        Collection<TestInfo> testInfos=null;
        testInfos=testService.findTestByStuId(userId);
        req.setAttribute("testInfos",testInfos);

        //获取已经参加的考试的结果
        Collection<Score> scores=null;
        scores=testService.findTestScoreByStuId(userId);
        req.setAttribute("scores",scores);

        //转到学生自我的主页
        req.getRequestDispatcher("stuMe.jsp").forward(req,resp);
    }
}
