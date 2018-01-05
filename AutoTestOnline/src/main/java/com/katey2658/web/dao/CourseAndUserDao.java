package com.katey2658.web.dao;

import java.util.Collection;

/**
 * Created by 11456 on 2016/12/11.
 */
public interface CourseAndUserDao {

    /**
     * 根据课程号来查询班上同学的Id集合
     * @param courseId
     * @return
     */
    public Collection<String> findUserIdsByCourseId(String courseId);


    /**
     * 根据用户号来查询有选择了的课程的集合
     * @param userId
     * @return
     */
    public Collection<String> findCourseIdsByUserId(String userId);



}
