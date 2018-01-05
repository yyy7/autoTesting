package com.katey2658.web.entity;

import java.util.Date;

/**
 * Created by 11456 on 2016/11/27.
 */
public class Score {
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
     * 用户号
     */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    /**
     * 成绩
     */
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
     * 结束时间
     */
    public Date endTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 使用时间
     */
    private int useTime;

    public int getUseTime() {
        return useTime;
    }

    public void setUseTime(int useTime) {
        this.useTime = useTime;
    }
}
