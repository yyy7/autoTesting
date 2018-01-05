package com.katey2658.web.dao;

import com.katey2658.web.entity.Teacher;

/**
 * Created by 11456 on 2016/12/13.
 */
public interface TeacherDao {

    /**
     * 通过id来查询一门课程
     * @param tecId
     * @return
     */
    public Teacher findTeacherById(String tecId);

    /**
     * 添加一个教师的信息到数据库
     * @param teacher
     * @return
     */
    public boolean addTeacher(Teacher teacher);
}
