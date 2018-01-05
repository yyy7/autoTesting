package com.katey2658.web.dao;

import com.katey2658.web.entity.TestInfo;

import java.util.Collection;

/**
 * Created by 11456 on 2016/12/11.
 */
public interface TestInfoDao {

    /**
     * 通过课程编号来查询测试信息
     * @param courseId
     * @return
     */
    public Collection<TestInfo> findTestsByCourseId(String courseId);

    /**
     * 通过测试编号来查询测试信息
     * @param testId
     * @return
     */
    public Collection<TestInfo> findTestsByTestId(String testId);

    /**
     * 添加一门测试
     * @param testInfo
     * @return
     */
    public boolean addTestInfo(TestInfo testInfo);

    /**
     * 根据教师编号来查询相关课程考试的信息状态已经过了时间限制的
     * @param tecId
     * @return
     */
    public Collection<TestInfo> findTestInfosOverTimeByTecId(String tecId);


    /**
     * 根据教师编号来查询所有课程，全部学生已经参与（时间没有到的）
     * @param tecId
     * @return
     */
    public Collection<TestInfo> findTestInfosNumIsAllByTecId(String tecId);


    /**
     * 查询所有正在进行中的测试
     * @param tecId
     * @return
     */
    public Collection<TestInfo> findTestInfosIsEndByTecId(String tecId);

    /**
     * 根据教师编号来查询所有正在进行的考试
     * @param tecId
     * @return
     */
    public Collection<TestInfo> findTestInfosNowByTecId(String tecId);


    /**
     * 根据课程编号和测试编号来查询
     * @param courseId
     * @param testId
     * @return
     */
    public TestInfo findTestInfoByIds(String courseId,String testId);


}
