package com.katey2658.web.service;

import com.katey2658.web.entity.Question;
import com.katey2658.web.entity.Score;
import com.katey2658.web.entity.TestInfo;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by 11456 on 2016/11/27.
 */
public interface TestService {

    /**
     * 添加一个考试信息到数据库
     * @param courseId
     * @param testId
     * @param joinNum
     * @param time
     * @param startTime
     * @param endTime
     * @param testPoints
     * @param diffcutyPercents
     */
    public void addCourseTest(String courseId
            , String testId,int joinNum,int time,Date startTime,Date endTime
            , List<String> testPoints
            , Map<Integer,Integer> diffcutyPercents);

    /**
     * 根据课程号和考试好查找一门考试信息
     *
     * @param courseId
     * @param testId
     * @return
     */
    public TestInfo findTestById(String courseId, String testId);

    /**
     * 根据课程号和考试好查找一门考试题目
     *
     * @param courseId
     * @param testId
     * @return
     */
    public Collection<Question> getQuestionsById(String courseId, String testId);

    /**
     * 添加考试结果到数据库
     *
     * @param courseId  课程号
     * @param testId    考试号
     * @param userId    用户学号
     * @param timeBegin
     *@param time
     * @param testScore 考试成绩  @return
     */
    public boolean addTestScore(String courseId, String testId, String userId, Date timeBegin, int time, int testScore);

    /**
     * 根据用户学号来查询相关考试信息的集合
     *
     * @param userId 学生学号
     * @return
     */
    public Collection<TestInfo> findTestByStuId(String userId);

    /**
     * 根据学生学号查找过往考试结果
     *
     * @param userId
     * @return
     */
    public Collection<Score> findTestScoreByStuId(String userId);

    /**
     * 根据要参加的考试的课程编号和测试编号，在一定规则前提下，通过算法来提取相关题目
     *
     * @param couseId
     * @param testId
     * @return
     */
    public Collection<Question> findQuestionsByIds(String couseId, String testId);


    /**
     * 根据用户可以来查询相关已经发布
     * 正在进行的考试情况
     *
     * @param userId
     * @return
     */
    public Collection<TestInfo> findTestNowByTecId(String userId);

    /**
     * 根据用户可以来查询相关已经发布
     * 已经结束的考试情况
     *
     * @param userId
     * @return
     */
    public Collection<TestInfo> findTestPassByTecId(String userId);



}

