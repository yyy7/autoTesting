package com.katey2658.web.entity;

import java.util.List;

/**
 * 选择题
 * Created by 11456 on 2016/11/22.
 */
public class Question {

    /**
     * 题目的编号
     */
    private String quesId;
    public String getQuesId() {
        return quesId;
    }
    public void setQuesId(String quesId) {
        this.quesId = quesId;
    }


    /**
     * 课程编号
     */
    private String courseId;

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    /**
     * 题目的分数
     */
    private int quesScore;
    public int getQuesScore() {
        return quesScore;
    }

    public void setQuesScore(int quesScore) {
        this.quesScore = quesScore;
    }

    /**
     * 题目的内容
     */
    private String quesContent;

    public String getQuesContent() {
        return quesContent;
    }

    public void setQuesContent(String quesContent) {
        this.quesContent = quesContent;
    }


    /**
     * 选项
     */
    private List<String> options;

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }



    /**
     * 答案
     */
    private String quesAnswer;
    public String getQuesAnswer() {
        return quesAnswer;
    }

    public void setQuesAnswer(String quesAnswer) {
        this.quesAnswer = quesAnswer;
    }





    /**
     * 难度系数
     */
    private int diffDegree;


    public int getDiffDegree() {
        return diffDegree;
    }

    public void setDiffDegree(int diffDegree) {
        this.diffDegree = diffDegree;
    }

    /**

     * 相似度
     */
    private int sameDegree;

    public int getSameDegree() {
        return sameDegree;
    }

    public void setSameDegree(int sameDegree) {
        this.sameDegree = sameDegree;
    }



    /**
     * 权重
     */
    private int quesWeight;

    public int getQuesWeight() {
        return quesWeight;
    }

    public void setQuesWeight(int quesWeight) {
        this.quesWeight = quesWeight;
    }

    /**
     * 考点
     */
    private String testPoint;

    public void setTestPoint(String testPoint) {
        this.testPoint = testPoint;
    }

    public String getTestPoint() {
        return testPoint;
    }
}
