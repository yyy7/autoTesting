package com.katey2658.web.service.impl;

import com.katey2658.web.dao.TeacherDao;
import com.katey2658.web.dao.impl.TeacherDaoImpl;
import com.katey2658.web.entity.Teacher;
import com.katey2658.web.service.TeacherService;

/**
 * Created by 11456 on 2016/12/13.
 */
public class TeacherServiceImpl implements TeacherService{

    /**
     * 教师登录服务
     * @param tecId
     * @param tecPwd
     * @return
     */
    @Override
    public int signIn(String tecId, String tecPwd) {
        TeacherDao teacherDao=new TeacherDaoImpl();
        Teacher teacher=null;
        teacher=teacherDao.findTeacherById(tecId);

        if (teacher != null) {
            if (teacher.getTeacherPwd().equals(tecPwd)) {
                return 0;
            } else {
                return -1;
            }
        }
        return -2;
    }

    /**
     * 教师注册服务
     * @param teacher
     * @return
     */
    @Override
    public boolean signUp(Teacher teacher) {
        return false;
    }

    /**
     * 通过教师编号来查找一个用户
     * @param tecId
     * @return
     */
    @Override
    public Teacher findUserById(String tecId) {
        TeacherDao teacherDao=new TeacherDaoImpl();
        Teacher teacher=null;
        teacher=teacherDao.findTeacherById(tecId);
        return teacher;
    }
}
