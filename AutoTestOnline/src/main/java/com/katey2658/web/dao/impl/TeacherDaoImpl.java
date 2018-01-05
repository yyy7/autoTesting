package com.katey2658.web.dao.impl;

import com.katey2658.web.dao.TeacherDao;
import com.katey2658.web.entity.Teacher;
import com.katey2658.web.util.DBPool;

import java.sql.*;

/**
 * Created by 11456 on 2016/12/13.
 */
public class TeacherDaoImpl implements TeacherDao {

    /**
     * 通过id来查询一门课程
     * @param tecId
     * @return
     */
    @Override
    public Teacher findTeacherById(String tecId) {
        Connection conn = null;
        Statement st = null;
        Teacher teacher = null;
        ResultSet rs=null;
        final String sql =String.format("select teacher_id,teacher_name,teacher_mail,teacher_pwd,teacher_age,teacher_sex,teacher_addr,teacher_rank " +
                "from teacher where teacher_id='%s'",tecId);

        try {
            conn = DBPool.getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            System.out.println(sql);
            if (rs.next()){
                teacher=new Teacher();
                teacher.setTeacherId(rs.getString(1));
                teacher.setTeacherName(rs.getString(2));
                teacher.setTecherMail(rs.getString(3));
                teacher.setTeacherPwd(rs.getString(4));
                teacher.setTeacherAge(rs.getInt(5));
                teacher.setTeacherSex(rs.getInt(6)==1?"男":"女");
                teacher.setTeacherAddr(rs.getString(7));
                teacher.setTeacherRank(rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.release(conn,st,rs);
        }
        return teacher;
    }

    /**
     * 添加一个教师的信息到数据库
     * @param teacher
     * @return
     */
    @Override
    public boolean addTeacher(Teacher teacher) {
        return false;
    }
}
