package com.katey2658.web.entity;

import java.util.Date;

/**
 * Created by 11456 on 2016/11/22.
 */
public class TestInfo {

    /**
     * 课程名
     */
    private String courseName;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    /**
     * 课程编号
     */
    private String courseId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    /**
     * 测试编号
     */
    private String testId;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    /**
     * 参与人数
     */
    private int joinNum;

    public int getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(int joinNum) {
        this.joinNum = joinNum;
    }

    /**
     * 实际参与人数
     */
    private int numActual;

    public void setNumActual(int numActual) {
        this.numActual = numActual;
    }

    public int getNumActual() {
        return numActual;
    }

    /**
     * 考试时间(分）
     */
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /**
     * 开始时间
     */
    private Date startTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 截止时间

     */
    private Date endTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
