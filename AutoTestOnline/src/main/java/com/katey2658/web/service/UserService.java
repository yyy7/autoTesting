package com.katey2658.web.service;


import com.katey2658.web.entity.User;

import java.util.Collection;

/**
 * Created by 11456 on 2016/12/4.
 *
 */
public interface UserService {

    /**
     * 根据用户号和密码登录
     * @param userId 用户名
     * @param userPwd 密码
     * @return 返回结果状态 -1 密码有误，-2账号错误，0登录成功
     */
    public int signIn(String userId, String userPwd);

    /**
     * 根据用户邮箱和密码登录
     * @param userMail
     * @param userPwd
     * @return
     */
    public int signInByMail(String userMail, String userPwd);

    /**
     * 注册一个用户，添加用户信息
     * @param user 用户对象，里面有新用户的信息
     * @return
     */
    public int signUp(User user);

    /**
     * 退出账号，就是不在线
     * @param userId
     * @return
     */
    public int logOut(String userId);


    /**
     * 申请冻结账号
     * @param userId
     * @return
     */
    public int closeUser(String userId);

    /**
     * 根据页码来显示用户信息
     * @param page
     * @return
     */
    public Collection<User> showUsersByPage(int page);

    /**
     * 根据用户Id来请求用户的详细信息
     * @param userId 用户Id都是唯一标识
     * @return 用户的详细信息
     */
    public User getUserInfo(String userId);

    /**
     * 更新用户信息
     * @param userInfo 修改后的用户信息
     * @return
     */
    public int updateUserInfo(User userInfo);

    /**
     * 根据用户id来查询一个用户
     * @param userId
     * @return
     */
    public User findUserById(String userId);


    /**
     * 重置账户密码
     * @param userId
     * @param oldUserPwd 原密码，新密码
     * @param newUserPwd
     * @return
     */
    public int resetUserPwd(String userId, String oldUserPwd, String newUserPwd);

    /**
     * 重置账户邮箱
     * @param userId 用户id
     * @param oldUserMail 原邮箱
     * @param newUserMail 新邮箱
     * @return 修改过的的邮箱信息
     */
    public User resetUserMail(String userId, String oldUserMail, String newUserMail);

}
