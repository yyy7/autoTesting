package com.katey2658.web.dao.impl;

import com.katey2658.web.dao.CouserAndTecDao;
import com.katey2658.web.entity.Course;
import com.katey2658.web.util.DBPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by 11456 on 2016/12/13.
 */
public class CouserAndTecDaoImpl implements CouserAndTecDao {


    /**
     * 根据老师教工号来查找相对应对的所有的课程编号集合
     * @param tecId
     * @return
     */
    @Override
    public Collection<String> findCourseIdsByTecId(String tecId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Collection<String> courseIds = null;
        final String sql="SELECT course_id from course_teacher WHERE teacher_id=?";

        try{
            conn= DBPool.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,tecId);
            rs=ps.executeQuery();

            String id;
            courseIds=new Vector<>();
            while (rs.next()){
                courseIds.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBPool.release(conn,ps,rs);
        }

        return courseIds;
    }

    /**
     * 根据老师教工号来查找相对应对的所有的课程集合
     * @param tecId
     * @return
     */
    @Override
    public Collection<Course> findCoursesByTecId(String tecId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Collection<Course> courses = null;
        final String sql="SELECT course_id,course_name,colleage,course_hours,course_credit,material,date_start,date_end from course WHERE teacher_id=?";

        try{
            conn= DBPool.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,tecId);
            rs=ps.executeQuery();

            Course course=null;
            courses=new Vector<>();
            while (rs.next()){
                course=new Course();
                course.setCourseId(rs.getString(1));
                course.setCourseName(rs.getString(2));
                course.setCourseId(rs.getString(3));
                course.setCourseHours(rs.getInt(4));
                course.setCourseCredit(rs.getFloat(5));
                course.setNeedMaterial(rs.getInt(6)==1?true:false);
                course.setStartTime(rs.getDate(7));
                course.setEndTime(rs.getDate(8));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBPool.release(conn,ps,rs);
        }

        return courses;
    }
}
