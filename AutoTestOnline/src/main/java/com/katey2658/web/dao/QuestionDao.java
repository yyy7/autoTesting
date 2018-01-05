package com.katey2658.web.dao;

import com.katey2658.web.entity.Question;

import java.util.Collection;

/**
 * Created by 11456 on 2016/12/12.
 */
public interface QuestionDao {
    /**
     * 根据课程Id查找题目
     * @return
     */
    public Collection<Question> findQuestions(String courseId);

    /**
     * 通过Id编号来查询一个题目
     * @param quesId
     * @return
     */
    public Question findQuestionById(String quesId);

    /**
     * 添加课程题目
     * @param collection
     */
    public void addQuestions(Collection<Question> collection);

    /**
     * 添加一个题目
     * @param question
     */
    public void addQuestion(Question question);


    /**
     * 修改一个课程题的信息
     * @param question
     */
    public void updateQuestion(Question question);

    /**
     * 批量修改
     * @param questions
     */
    public void updateQuestions(Collection<Question> questions);

    /**
     * 根据题目Id删除
     * @param quesId
     */
    public void deleteQuestionById(String quesId);

    /**
     * 根据Id批量删除
     * @param ids
     */
    public void deleteQuestionsByIds(Collection<String> ids);


}
