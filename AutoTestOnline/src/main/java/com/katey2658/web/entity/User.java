package com.katey2658.web.entity;


/**
 * Created by 11456 on 2016/11/21.
 */
public class User {

    /**
     * 无参构造
     */
    public User(){
    }
    /**
     * 有参数构造方法
     * @param userName
     * @param userPwd
     */
    public User(String userName, String userPwd){
        this(userName,userPwd,null);
    }

    public User(String userName, String userPwd, String userMail){
        this.userName=userName;
        this.userPwd=userPwd;
        this.userMail=userMail;
    }
    /**
     * 用户id
     */
    private String userId;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    /**
     * 用户名
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 用户密码
     */
    private String userPwd;

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 用户邮箱
     */
    private String userMail;

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserMail() {
        return userMail;
    }

    /**
     * 用户年龄
     */
    private int userAge;

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserAge() {
        return userAge;
    }

    /**
     * 性别
     */
    private String sex;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    /**
     * 用户信息：地址
     */
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    /**
     * 是否在线
     */
    private boolean online;

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isOnline() {
        return online;
    }

    /**
     * 账户是否可用，如果不可用，就是账户一般已经关闭
     */
    private boolean active;

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive(){
        return active;
    }
}
