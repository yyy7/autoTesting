package com.katey2658.web.dao.impl;


import com.katey2658.web.dao.CourseDao;
import com.katey2658.web.entity.Course;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

/**
 * Created by 11456 on 2016/12/4.
 */
public class CourseDaoImpl implements CourseDao {

    /**
     * 添加一门课的信息
     * @param course
     * @return
     */
    @Override
    public boolean addCourse(Course course) {
        return false;
    }

    /**
     * 根据Id删除一门课的信息
     * @return
     */
    @Override
    public boolean deleteCourseById() {
        return false;
    }

    /**
     * 更新一门课的信息
     * @param course
     * @return
     */
    @Override
    public boolean updateCourse(Course course) {
        return false;
    }

    /**
     * 根据用户Id查询一门课的信息
     * @param courseId
     * @return
     */
    @Override
    public Course findCourseById(String courseId) {
        return null;
    }

    /**
     * 根据Id集合查询课程集合
     * @param ids
     * @return
     */
    @Override
    public Collection<Course> findCourseByIds(Collection<String> ids) {
        return null;
    }

    /**
     * 根据课程名字查询课程集合
     * @param courseName
     * @return
     */
    @Override
    public Collection<Course> findCourseByName(String courseName) {
        return null;
    }

    /**
     * 根据课时查询课程信息集合
     * @param courseHours
     * @return
     */
    @Override
    public Collection<Course> findCourseByHours(int courseHours) {
        return null;
    }

    /**
     * 根据学分查询课程集合
     * @param courseCredit
     * @return
     */
    @Override
    public Collection<Course> findCourseByCredit(float courseCredit) {
        return null;
    }

    /**
     * 根据老师名字查询课程集合
     * @param courseTeacher
     * @return
     */
    @Override
    public Collection<Course> findCourseByTeacher(String courseTeacher) {
        return null;
    }

    @Override
    public Collection<Course> findCourseByStartTime(java.util.Date courseStartTime) {
        return null;
    }

    @Override
    public Collection<Course> findCourseByEndTime(java.util.Date courseEndTime) {
        return null;
    }

//
//    /**
//     * 根据课程开始时间查询课程集合
//     * @param courseStartTime
//     * @return
//     */
//    @Override
//    public Collection<Course> findCourseByStartTime(Date courseStartTime) {
//        return null;
//    }
//
//    /**
//     * 根据课程结束时间查询课程集合
//     * @param courseEndTime
//     * @return
//     */
//    @Override
//    public Collection<Course> findCourseByEndTime(Date courseEndTime) {
//        return null;
//    }
//
//    /**
//     * 批量增加课程信息集合
//     * @param courses
//     * @return 成功添加的课程信息结果
//     */
    @Override
    public int addCourses(Collection<Course> courses) {
        Connection conn=null;
        Statement stat=null;
        String sql;
        try {
            for(Course course:courses){
                sql="";
                stat.addBatch(sql);
            }
            return stat.executeBatch()[0];
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
