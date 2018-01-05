package com.katey2658.web.dao;


import com.katey2658.web.entity.User;

import java.util.Collection;

/**
 * Created by 11456 on 2016/12/4.
 */
public interface UserDao {

    /**
     * 添加一个用户信息
     * @param user
     * @return
     */
    public boolean addUser(User user);

    /**
     * 通过用户Id删除一个用户
     * @param userId
     * @return
     */
    public boolean deleteUserById(String userId);

    /**
     * 更新一个用户的信息
     * @param user
     * @return
     */
    public boolean updateUser(User user);

    /**
     * 根据Id查询一个用户信息
     * @param userId
     * @return
     */
    public User findUserById(String userId);

    /**
     * 根据Id集合查询用户信息集合
     * @param ids
     * @return
     */
    public Collection<User> findUserByIds(Collection<String> ids);

    /**
     * 根据用户名查询用户集合
     * @param name
     * @return
     */
    public Collection<User> findUserByName(String name);

    /**
     * 根据用户邮箱查询用户信息
     * @param userMail
     * @return 用户信息
     */
    public Collection<User> findUserByMail(String userMail);

    /**
     * 根据年龄来查询用户集合
     * @param userAge 用户年龄
     * @param page 页码
     * @param size 每一页记录条数
     * @return 用户信息集合
     */
    public Collection<User> findUserByAge(int userAge, int page, int size);

    /**
     * 根据性别来查询用户集合
     * @param userSex 用户性别
     * @param page 页码
     * @param size 每一页的记录数
     * @return 用户信息集合
     */
    public Collection<User> findUserBySex(String userSex, int page, int size);

    /**
     * 根据地址来查询用户信息集合
     * @param userAddr
     * @param page
     * @param size
     * @return
     */
    public Collection<User> findUserByAddr(String userAddr, int page, int size);

    /**
     * 根据用户是否在线来查询用户
     * @param isOrNotOnline 是否在线
     * @param page 页码
     * @param size  每一页的记录条数
     * @return 返回查询的记录
     */
    public Collection<User> findUserOnline(boolean isOrNotOnline, int page, int size);


}
