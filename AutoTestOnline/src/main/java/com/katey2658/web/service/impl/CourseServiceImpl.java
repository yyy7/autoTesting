package com.katey2658.web.service.impl;


import com.katey2658.web.entity.Course;
import com.katey2658.web.service.CourseService;

import java.util.Collection;

/**
 * Created by 11456 on 2016/12/4.
 */


public class CourseServiceImpl implements CourseService {

    @Override
    public Collection<Course> getCourseList(int page) {
        return null;
    }

    @Override
    public int addCourse(Course course) {
        return 0;
    }

    @Override
    public int deleteCourse(String courseId) {
        return 0;
    }

    @Override
    public int deleteCourses(Collection<Course> courses) {
        return 0;
    }

    @Override
    public int updateCourse(Course course) {
        return 0;
    }

    @Override
    public Course findCourseById(String courseId) {
        return null;
    }

    @Override
    public Collection<Course> findCourseByName() {
        return null;
    }

    @Override
    public Collection<String> getCourseHeader() {
        return null;
    }
}
