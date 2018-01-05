package com.katey2658.web.dao.impl;

import com.katey2658.web.common.CollectionConvertTool;
import com.katey2658.web.dao.QuestionDao;
import com.katey2658.web.entity.Question;
import com.katey2658.web.util.DBPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * Created by 11456 on 2016/12/12.
 * question表的操作
 */

public class QuestionDaoImpl implements QuestionDao {
    /**
     * 根据课程Id查找题目
     * @return
     */
    @Override
    public Collection<Question> findQuestions(String courseId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Question question=null;
        Collection<Question>collection=new Vector<>();

        conn= DBPool.getConnection();
        try {
            ps=conn.prepareStatement(" SELECT ques_id,course_id,ques_score,ques_content,options,ques_answer" +
                    ",diff_degree,ques_weight,same_degree,test_point " +
                    " FROM question WHERE course_id=?");
            ps.setString(1,courseId);
            rs=ps.executeQuery();
            while(rs.next()){
                question=new Question();
                question.setQuesId(rs.getString(1));
                question.setCourseId(rs.getString(2));
                question.setQuesScore(rs.getInt(3));
                question.setQuesContent(rs.getString(4));
                question.setOptions((List<String>) CollectionConvertTool.StringConvertToCollection(rs.getString(5)));
                //System.out.println("+++++++++++"+question.getOptions().size());
                question.setQuesAnswer(rs.getString(6));
                question.setDiffDegree(rs.getInt(7));
                question.setQuesWeight(rs.getInt(8));
                question.setSameDegree(rs.getInt(9));
                question.setTestPoint(rs.getString(10));
                collection.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBPool.release(conn,ps,null);
        }
        return collection;
    }

    /**
     * 通过Id编号来查询一个题目
     * @param quesId
     * @return
     */
    @Override
    public Question findQuestionById(String quesId) {
        return null;
    }

    /**
     * 添加课程题目
     * @param collection
     */
    @Override
    public void addQuestions(Collection<Question> collection) {

    }

    /**
     * 添加一个题目
     * @param question
     */
    @Override
    public void addQuestion(Question question) {
        Connection conn=null;
        PreparedStatement ps=null;

        conn= DBPool.getConnection();
        try {
            ps=conn.prepareStatement("insert into question " +
                    "(ques_id,course_id,ques_score,ques_content,options,ques_answer" +
                    ",diff_degree,ques_weight,same_degree,test_point)" +
                    " values (?,?,?,?,?,?,?,?,?,?);");
            ps.setString(1,question.getQuesId());
            ps.setString(2,question.getCourseId());
            ps.setInt(3,question.getQuesScore());
            ps.setString(4,question.getQuesContent());
            ps.setString(5, CollectionConvertTool.CollectionConvertToString(question.getOptions()));
            ps.setString(6,question.getQuesAnswer());
            ps.setInt(7,question.getDiffDegree());
            ps.setInt(8,question.getQuesWeight());
            ps.setInt(9,question.getSameDegree());
            ps.setString(10,question.getTestPoint());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBPool.release(conn,ps,null);
        }
    }



    /**
     * 修改一个课程题的信息
     * @param question
     */
    @Override
    public void updateQuestion(Question question) {

    }

    /**
     * 批量修改
     * @param questions
     */
    @Override
    public void updateQuestions(Collection<Question> questions) {

    }

    /**
     * 根据题目Id删除
     * @param quesId
     */
    @Override
    public void deleteQuestionById(String quesId) {

    }

    /**
     * 根据Id批量删除
     * @param ids
     */
    @Override
    public void deleteQuestionsByIds(Collection<String> ids) {

    }
}
