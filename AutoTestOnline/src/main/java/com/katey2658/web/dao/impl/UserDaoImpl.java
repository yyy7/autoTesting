package com.katey2658.web.dao.impl;


import com.katey2658.web.dao.UserDao;
import com.katey2658.web.entity.User;
import com.katey2658.web.util.DBPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by 11456 on 2016/12/4.
 */
public class UserDaoImpl implements UserDao {

    /**
     * 添加一个用户信息
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        Connection conn=null;
        PreparedStatement ps=null;
        boolean flag=false;
        String sql="insert into user(user_id,user_name,user_pwd,user_mail,user_age,user_sex,user_addr,active) VALUES (?,?,?,?,?,?,?,?)";

        try {
            conn=DBPool.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUserId());
            ps.setString(2,user.getUserName());
            ps.setString(3,user.getUserPwd());
            ps.setString(4,user.getUserMail());
            ps.setInt(5,user.getUserAge());
            ps.setInt(6,user.getSex().equals("男")? 1:0);
            ps.setString(7,user.getAddress());
            ps.setInt(8,1);

            ps.executeUpdate();
            flag=true;
        } catch (SQLException e) {
            flag=false;
            e.printStackTrace();
        }finally{
            DBPool.release(conn,ps,null);
        }
        return flag;
    }

    /**
     * 通过用户Id删除一个用户
     * @param userId
     * @return
     */
    @Override
    public boolean deleteUserById(String userId) {
        return false;
    }

    /**
     * 更新一个用户的信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        return false;
    }

    /**
     * 根据Id查询一个用户信息
     * @param userId
     * @return
     */
    @Override
    public User findUserById(String userId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=null;
        try {
            conn= DBPool.getConnection();
            sql="SELECT user_id,user_name,user_pwd,user_mail,user_age,user_sex,user_addr FROM USER WHERE user_id= ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,userId);
            System.out.println(sql);
            rs=ps.executeQuery();

            if (rs!=null&&rs.next()){
                User user=new User();

                String  userName=rs.getString(2);
                String  userPwd=rs.getString(3);
                String userMail=rs.getString(4);
                int userAge=rs.getInt(5);
                String sex=rs.getInt(6)==1?"男":"女";
                String address=rs.getString(7);

                user.setUserId(userId);
                user.setUserName(userName);
                user.setUserPwd(userPwd);
                user.setUserMail(userMail);
                user.setUserAge(userAge);
                user.setSex(sex);
                user.setAddress(address);
                return user;
            }

            DBPool.release(conn,ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 根据Id集合查询用户信息集合
     * @param ids
     * @return
     */
    @Override
    public Collection<User> findUserByIds(Collection<String> ids) {
        return null;
    }

    /**
     * 根据用户名查询用户集合
     * @param name
     * @return
     */
    @Override
    public Collection<User> findUserByName(String name) {
        return null;
    }

    /**
     * 根据用户邮箱查询用户信息
     * @param userMail
     * @return 用户信息
     */
    @Override
    public Collection<User> findUserByMail(String userMail) {
        return null;
    }

    /**
     * 根据年龄来查询用户集合
     * @param userAge 用户年龄
     * @param page 页码
     * @param size 每一页记录条数
     * @return 用户信息集合
     */
    @Override
    public Collection<User> findUserByAge(int userAge, int page, int size) {
        return null;
    }

    /**
     * 根据性别来查询用户集合
     * @param userSex 用户性别
     * @param page 页码
     * @param size 每一页的记录数
     * @return 用户信息集合
     */
    @Override
    public Collection<User> findUserBySex(String userSex, int page, int size) {
        return null;
    }

    /**
     * 根据地址来查询用户信息集合
     * @param userAddr
     * @param page
     * @param size
     * @return
     */
    @Override
    public Collection<User> findUserByAddr(String userAddr, int page, int size) {
        return null;
    }

    /**
     * 根据用户是否在线来查询用户
     * @param isOrNotOnline 是否在线
     * @param page 页码
     * @param size  每一页的记录条数
     * @return 返回查询的记录
     */
    @Override
    public Collection<User> findUserOnline(boolean isOrNotOnline, int page, int size) {
        return null;
    }

}
