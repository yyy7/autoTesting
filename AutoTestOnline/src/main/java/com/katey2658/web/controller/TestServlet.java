package com.katey2658.web.controller;

import com.katey2658.web.dao.QuestionDao;
import com.katey2658.web.dao.impl.QuestionDaoImpl;
import com.katey2658.web.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 11456 on 2016/12/21.
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question question=new Question();
        QuestionDao questionDao=new QuestionDaoImpl();

        Random random=new Random();
        for (int i=1;i<500;i++){
            List<String> list=new ArrayList<>();
            int j=random.nextInt(10);
            j=j*10+random.nextInt(10);
            list.add(j+"a");
            list.add(j+"b");
            list.add(j+"c");
            list.add(j+"d");

            question.setQuesId((102500+i)+"");
            question.setCourseId("A000003");
            question.setQuesScore(random.nextInt(3)+2);
            question.setQuesContent("这是一题关于***的考试题目，现有**几个条件，如果***，求**,请选择**？");
            question.setOptions(list);
            String ans=list.get(random.nextInt(4));
            question.setQuesAnswer(ans);
            question.setDiffDegree(2+random.nextInt(6));
            question.setQuesWeight(5);
            question.setSameDegree(5);
            question.setTestPoint(i+"aaa"+i%100);

            questionDao.addQuestion(question);
        }
    }
}
