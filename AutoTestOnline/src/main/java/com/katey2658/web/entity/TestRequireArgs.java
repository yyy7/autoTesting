package com.katey2658.web.entity;

import java.util.Collection;
import java.util.Map;

/**
 * Created by 11456 on 2016/12/20.
 */
public class TestRequireArgs {

    /**
     * 测试课程编号
     */
    private String courseId;

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }


    /**
     * 测试编号
     */
    private String testId;

    public void setTestId(String testId) {
        this.testId = testId;
    }
    public String getTestId() {
        return testId;
    }


    /**
     * 考点
     */
    private Collection<String> testPoints;

    public void setTestPoints(Collection<String> testPoints) {
        this.testPoints = testPoints;
    }

    public Collection<String> getTestPoints() {
        return testPoints;
    }


    /**
     * 每一考试难度成分所占的百分比
     */
    private Map<Integer,Integer> diffcutyPercents;

    public void setDiffcutyPercents(Map<Integer, Integer> diffcutyPercents) {
        this.diffcutyPercents = diffcutyPercents;
    }

    public Map<Integer, Integer> getDiffcutyPercents() {
        return diffcutyPercents;
    }


}
