package com.katey2658.web.entity;

/**
 * Created by 11456 on 2016/12/13.
 */
public class Teacher{

    /**
     * 教师编号
     */
    public String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }



    /**
     * 教师姓名
     */
    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * 教师邮箱
     */
    private String techerMail;

    public String getTecherMail() {
        return techerMail;
    }

    public void setTecherMail(String techerMail) {
        this.techerMail = techerMail;
    }

    private String teacherPwd;

    /**
     * 用户密码
     * @return
     */
    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }

    /**
     * 教师年龄
     */

    private int teacherAge;
    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }

    /**
     * 教师性别
     */
    private String  teacherSex;

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    /**
     * 教师地址
     */
    private String teacherAddr;

    public String getTeacherAddr() {
        return teacherAddr;
    }

    public void setTeacherAddr(String teacherAddr) {
        this.teacherAddr = teacherAddr;
    }

    /**
     * 教师职称
     *
     */
    private String teacherRank;

    public String getTeacherRank() {
        return teacherRank;
    }

    public void setTeacherRank(String teacherRank) {
        this.teacherRank = teacherRank;
    }

    /**
     *返回教师ID
     * @return
     */
    public String getUserId(){
        return teacherId;
    }

    /**
     *返回教师名字
     * @return
     */
    public String getUserName(){
        return teacherName;
    }


}
