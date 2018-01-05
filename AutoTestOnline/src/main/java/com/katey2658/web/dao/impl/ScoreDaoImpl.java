package com.katey2658.web.dao.impl;

import com.katey2658.web.dao.ScoreDao;
import com.katey2658.web.entity.Score;
import com.katey2658.web.util.DBPool;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by 11456 on 2016/12/11.
 */
public class ScoreDaoImpl implements ScoreDao{

    /**
     * 通过学号来查询参加过的考试的成绩
     * @param userId
     * @return
     */
    @Override
    public Collection<Score> findScoresByStuId(String userId) {

        Connection conn;
        Statement st;
        ResultSet rs=null;
        Collection<Score> scores=new Vector<>();
        String sql=String.format(
                "SELECT score.course_id,course_name,test_id,time_start,time,score from score,course WHERE user_id=%s and course.course_id=score.course_id",userId);

        try {
            conn=DBPool.getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);

            Score score=null;
            while (rs.next()){
                score=new Score();
                score.setCourseId(rs.getString(1));
                score.setCourseName(rs.getString(2));
                score.setTestId(rs.getString(3));
                score.setStartTime(rs.getDate(4));
                score.setUseTime(rs.getInt(5));
                score.setScore(rs.getInt(6));
                scores.add(score);
            }
            DBPool.release(conn,st,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    /**
     * 添加一门考试的考试成绩情况
     * @param score
     */
    @Override
    public boolean addScore(Score score) {
        Connection conn=null;
        PreparedStatement ps=null;
        boolean flag=false;

        conn=DBPool.getConnection();
        try {
            ps=conn.prepareStatement("INSERT INTO score(course_id,test_id,user_id,score,time_start,time)VALUE (?,?,?,?,?,?)");
            ps.setString(1,score.getCourseId());
            ps.setString(2,score.getTestId());
            ps.setString(3,score.getUserId());
            ps.setInt(4,score.getScore());
            ps.setDate(5, new Date(score.getStartTime().getTime()));
            ps.setInt(6,score.getUseTime());
            ps.executeUpdate();
            flag=true;
        } catch (SQLException e) {
            flag=false;
            e.printStackTrace();
        }finally {
            DBPool.release(conn,ps,null);
        }
        return flag;
    }
}
