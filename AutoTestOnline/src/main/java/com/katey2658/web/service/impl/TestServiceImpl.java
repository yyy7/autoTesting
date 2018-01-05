package com.katey2658.web.service.impl;


import com.katey2658.web.common.PSOAlgo;
import com.katey2658.web.dao.*;
import com.katey2658.web.dao.impl.*;
import com.katey2658.web.entity.Question;
import com.katey2658.web.entity.Score;
import com.katey2658.web.entity.TestInfo;
import com.katey2658.web.entity.TestRequireArgs;
import com.katey2658.web.service.TestService;

import java.util.*;
import java.util.Date;

/**
 * Created by 11456 on 2016/11/27.
 */
public class TestServiceImpl implements TestService {

    /**
     * 添加一个考试信息到数据库（应该做一个状态码）
     * @param courseId
     * @param testId
     * @param joinNum
     * @param time
     * @param startTime
     * @param endTime
     * @param testPoints
     * @param diffcutyPercents
     */
    @Override
    public void addCourseTest(String courseId
            , String testId, int joinNum, int time
            , Date startTime, Date endTime
            , List<String> testPoints, Map<Integer, Integer> diffcutyPercents) {

        TestInfo testInfo=null;
        TestRequireArgs testRequireArgs=null;

        if (courseId==null||testId==null||testPoints==null||diffcutyPercents==null){
            return ;
        }
        //将测试信息添加到测试测试表
        testInfo=new TestInfo();
        testInfo.setCourseId(courseId);
        testInfo.setTestId(testId);
        testInfo.setNumActual(0);
        testInfo.setJoinNum(joinNum);
        testInfo.setStartTime(startTime);
        testInfo.setEndTime(endTime);
        testInfo.setTime(time);
        TestInfoDao testInfoDao=new TestInfoDaoImpl();
        testInfoDao.addTestInfo(testInfo);

        //将测试信息表的相关要求参数添加到表中
        testRequireArgs=new TestRequireArgs();
        testRequireArgs.setCourseId(courseId);
        testRequireArgs.setTestId(testId);
        testRequireArgs.setTestPoints(testPoints);
        testRequireArgs.setDiffcutyPercents(diffcutyPercents);
        TestRequireArgsDao testRequireArgsDao=new TestRequireArgsDaoImpl();
        testRequireArgsDao.addTestRequireArgs(testRequireArgs);

    }

    /**
     * 根据课程号和考试好查找一门考试信息
     * @param courseId
     * @param testId
     * @return
     */
    @Override
    public TestInfo findTestById(String courseId, String testId) {
        TestInfo testInfo=null;
        TestInfoDao testInfoDao=new TestInfoDaoImpl();
        testInfo=testInfoDao.findTestInfoByIds(courseId,testId);
        return testInfo;
    }

    /**
     * 根据课程号和考试好查找一门考试题目
     * @param courseId
     * @param testId
     * @return
     */
    @Override
    public Collection<Question> getQuestionsById(String courseId, String testId) {
        Collection<Question> questions=null;

        return questions;
    }

    /**
     * 添加考试结果到数据库
     * @param courseId  课程号
     * @param testId   考试号
     * @param userId   用户学号
     * @param timeBegin
     *@param time
     * @param testScore 考试成绩  @return
     */
    @Override
    public boolean addTestScore(String courseId, String testId, String userId, Date timeBegin, int time, int testScore) {
        Score score =new Score();
        score.setCourseId(courseId);
        score.setTestId(testId);
        score.setUserId(userId);
        score.setStartTime(new Date());
        score.setScore(testScore);
        //将考试成绩加到数据库
        ScoreDao scoreDao=new ScoreDaoImpl();
        scoreDao.addScore(score);

        return false;
    }

    /**
     * 根据用户学号来查询相关考试信息的集合
     * @param userId
     * @return
     */
    @Override
    public Collection<TestInfo> findTestByStuId(String userId) {

        CourseAndUserDao courseAndUserDao=new CourseAndUserDaoImpl();
        Collection<String> courseIds=courseAndUserDao.findCourseIdsByUserId(userId);

        TestInfoDao testInfoDao=new TestInfoDaoImpl();

        Collection<TestInfo> testInfos=new Vector<>();
        for (String s:courseIds){
            testInfos.addAll(testInfoDao.findTestsByCourseId(s));
        }
        return testInfos;
    }

    /**
     * 根据学生学号查找过往考试结果
     * @param userId
     * @return
     */@Override
    public Collection<Score> findTestScoreByStuId(String userId) {
        Collection<Score> scores=null;
        ScoreDao scoreDao=new ScoreDaoImpl();
        scores=scoreDao.findScoresByStuId(userId);
        return scores;
    }

    /**
     * 根据要参加的考试的课程编号和测试编号，在一定规则前提下，通过算法来提取相关题目
     * @param couseId
     * @param testId
     * @return
     */
    @Override
    public Collection<Question> findQuestionsByIds(String couseId, String testId) {
        Collection<Question> questions=null;

        //先获取该分考试所需要的考试参数
        TestRequireArgsDao testRequireArgsDao=new TestRequireArgsDaoImpl();
        TestRequireArgs testRequireArgs=testRequireArgsDao.findTestRequireArgsById(couseId,testId);

        QuestionDao questionDao=new QuestionDaoImpl();
        questions=questionDao.findQuestions(testRequireArgs.getCourseId());

        PSOAlgo algo=new PSOAlgo(questions);
        questions=algo.getQuestions(testRequireArgs.getDiffcutyPercents(),testRequireArgs.getTestPoints());

        //通过规则和算法查找题库中的题目
        return questions;
    }

    /**
     * 根据用户可以来查询相关已经发布
     * 正在进行的考试情况
     * @param userId
     * @return
     */
    @Override
    public Collection<TestInfo> findTestNowByTecId(String userId) {
        TestInfoDao testInfoDao=new TestInfoDaoImpl();
        Collection<TestInfo> testInfos=null;
        testInfos=testInfoDao.findTestInfosNowByTecId(userId);
        return testInfos;
    }

    /**
     * 根据用户可以来查询相关已经发布
     * 已经结束的考试情况
     * @param userId
     * @return
     */
    @Override
    public Collection<TestInfo> findTestPassByTecId(String userId) {
        TestInfoDao testInfoDao=new TestInfoDaoImpl();
        Collection<TestInfo> testInfos=null;
        testInfos=testInfoDao.findTestInfosIsEndByTecId(userId);
        return testInfos;
    }
}
