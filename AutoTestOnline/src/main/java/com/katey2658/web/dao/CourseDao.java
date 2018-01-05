package com.katey2658.web.dao;



import com.katey2658.web.entity.Course;

import java.util.Collection;
import java.util.Date;

/**
 * Created by 11456 on 2016/12/4.
 */
public interface CourseDao {


    /**
     * 添加一门课的信息
     * @param course
     * @return
     */
    public boolean addCourse(Course course);

    /**
     * 根据Id删除一门课的信息
     * @return
     */
    public boolean deleteCourseById();

    /**
     * 更新一门课的信息
     * @param course
     * @return
     */
    public boolean updateCourse(Course course);

    /**
     * 根据用户Id查询一门课的信息
     * @param courseId
     * @return
     */
    public Course findCourseById(String courseId);

    /**
     * 根据Id集合查询课程集合
     * @param ids
     * @return
     */
    public Collection<Course> findCourseByIds(Collection<String> ids);

    /**
     * 根据课程名字查询课程集合
     * @param courseName
     * @return
     */
    public Collection<Course> findCourseByName(String courseName);

    /**
     * 根据课时查询课程信息集合
     * @param courseHours
     * @return
     */
    public Collection<Course> findCourseByHours(int courseHours);

    /**
     * 根据学分查询课程集合
     * @param courseCredit
     * @return
     */
    public Collection<Course> findCourseByCredit(float courseCredit);

    /**
     * 根据老师名字查询课程集合
     * @param courseTeacher
     * @return
     */
    public Collection<Course> findCourseByTeacher(String courseTeacher);

    /**
     * 根据课程开始时间查询课程集合
     * @param courseStartTime
     * @return
     */
    public Collection<Course> findCourseByStartTime(Date courseStartTime);

    /**
     * 根据课程结束时间查询课程集合
     * @param courseEndTime
     * @return
     */
    public Collection<Course> findCourseByEndTime(Date courseEndTime);


    /**
     * 批量增加课程信息集合
     * @param courses
     * @return 成功添加的结果状态
     */
    public int addCourses(Collection<Course> courses);

}
