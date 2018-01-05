package com.katey2658.web.service;

import com.katey2658.web.entity.Teacher;


/**
 * Created by 11456 on 2016/12/13.
 */
public interface TeacherService {

    /**
     * 教师登录服务
     * @param tecId
     * @param tecPwd
     * @return
     */
    public int signIn(String tecId,String tecPwd);


    /**
     * 教师注册服务
     * @param teacher
     * @return
     */
    public boolean signUp(Teacher teacher);
    /**
     * 通过教师编号来查找一个用户
     * @param tecId
     * @return
     */
    public Teacher findUserById(String tecId);
}
