package com.katey2658.web.entity;

import java.sql.Date;

/**
 * Created by 11456 on 2016/11/21.
 */
public class Course {

    /**
     * 无参构造方法
     */
    public Course() {

    }

    /**
     * 课程号
     */
    private String courseId;

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }


    /**
     * 课程所属学院
     */
    private String college;

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollege(){
        return college;
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
     * 课时
     */
    private int courseHours;

    public void setCourseHours(int courseHours)
    {
        this.courseHours = courseHours;
    }
    public int getCourseHours() {
        return courseHours;
    }
    /**
     * 课程老师
     */
    private String courseTeacher;

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }
    /**
     * 学分
     */
    private float courseCredit;

    public void setCourseCredit(float courseCredit) {
        this.courseCredit = courseCredit;
    }

    public float getCourseCredit() {
        return courseCredit;
    }

    /**
     * 是否需要材料
     */
    private boolean needMaterial;

    public void setNeedMaterial(boolean needMaterial) {
        this.needMaterial = needMaterial;
    }

    public boolean isNeedMaterial() {
        return needMaterial;
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
    private Date endTime;

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
