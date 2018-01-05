package com.katey2658.web.controller;

import com.katey2658.web.entity.Question;
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
import java.util.Date;
import java.util.Vector;

/**
 * Created by 11456 on 2016/12/10.
 */
public class TestPaperSubmitServlet extends HttpServlet{

    /**
     * 校验提交的表单和正确答案进行比较，将考试成绩输入数据库
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取session对象
        HttpSession session=req.getSession();

        //获取答案
        Vector<Question> questions=null;
        questions= (Vector<Question>) session.getAttribute("questions");
        if (questions==null){
            resp.sendRedirect("stume.jsp");
            return;
        }

        //返回的答案
        String feedBack;
        //总分
        int testScore=0;
        for (Question question:questions){
            feedBack=req.getParameter(question.getQuesId());
            //如果正确就加到总分成绩中
            if (feedBack.equalsIgnoreCase(question.getQuesAnswer())){
                testScore=testScore+question.getQuesScore();
            }
        }


        //考试信息
        TestInfo testInfo=null;
        testInfo= (TestInfo) session.getAttribute("testInfo");
        //学生信息
        User user=null;
        user= (User) session.getAttribute("user");

        //获取考试时间
        Date timeBegin= (Date) session.getAttribute("timeBegin");
        int time= (int) ((new Date().getTime()-timeBegin.getTime())/1000);

        //获取数据库对象，传入成绩
        TestService testService=new TestServiceImpl();
        testService.addTestScore(testInfo.getCourseId(),testInfo.getTestId(),user.getUserId(),timeBegin,time,testScore);


        //考试结束，回到学生主页面
        resp.sendRedirect("stuMe");

    }
}
