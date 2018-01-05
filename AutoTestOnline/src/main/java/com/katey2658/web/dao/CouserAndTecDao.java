package com.katey2658.web.dao;

import com.katey2658.web.entity.Course;

import java.util.Collection;

/**
 * Created by 11456 on 2016/12/13.
 */
public interface CouserAndTecDao {

    /**
     * 根据老师教工号来查找相对应对的所有的课程编号集合
     * @param tecId
     * @return
     */
    public Collection<String> findCourseIdsByTecId(String tecId);

    /**
     * 根据老师教工号来查找相对应对的所有的课程集合
     * @param tecId
     * @return
     */
    public Collection<Course> findCoursesByTecId(String tecId);
}
