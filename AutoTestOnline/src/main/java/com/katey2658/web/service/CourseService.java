package com.katey2658.web.service;


import com.katey2658.web.entity.Course;

import java.util.Collection;

/**
 * Created by 11456 on 2016/12/4.
 */
public interface CourseService {

    /**
     * 根据页码来显示课程
     * @param page
     * @return
     */
    public Collection<Course> getCourseList(int page);

    /**
     * 添加一门课程
     * @param course
     * @return
     */
    public int addCourse(Course course);

    /**
     * 根据课程id来删除一门课的信息（实际并不删除）
     * @param courseId
     * @return
     */
    public int deleteCourse(String courseId);

    /**
     * 批量删除课程信息
     * @param courses
     * @return
     */
    public int deleteCourses(Collection<Course> courses);

    /**
     * 修改一门课的信息
     * @param course
     * @return
     */
    public int updateCourse(Course course);

    /**
     * 通过课程号来查找课程
     * @param courseId
     * @return
     */
    public Course findCourseById(String courseId);

    /**
     * 根据课程名字查找
     * @return
     */
    public Collection<Course> findCourseByName();

    /**
     * 获取课程信息的表头
     * @return
     */
    public Collection<String> getCourseHeader();


}
