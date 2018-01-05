package com.katey2658.web.dao.impl;

import com.katey2658.web.dao.CourseAndUserDao;
import com.katey2658.web.util.DBPool;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by 11456 on 2016/12/11.
 */
public class CourseAndUserDaoImpl implements CourseAndUserDao {

    /**
     * 根据课程号来查询班上同学的Id集合
     * @param courseId
     * @return
     */
    @Override
    public Collection<String> findUserIdsByCourseId(String courseId) {

        Collection<String> userIds=new Vector<>();
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        String sql=String.format("SELECT user_id from course_user where course_id=%s",courseId);

        try {
            conn= DBPool.getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);

            while (rs.next()){
                userIds.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBPool.release(conn,st,rs);
        }

        return userIds;
    }


    /**
     * 根据用户号来查询有选择了的课程的集合
     * @param userId
     * @return
     */
    @Override
    public Collection<String> findCourseIdsByUserId(String userId) {

        Collection<String> courseIds=new Vector<>();
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        String sql=String.format("SELECT course_id from course_user where user_id=%s",userId);

        try {
            conn= DBPool.getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);

            while (rs.next()){
                courseIds.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBPool.release(conn,st,rs);
        }

        return courseIds;
    }
}
