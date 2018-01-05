package com.katey2658.web.service.impl;


import com.katey2658.web.dao.UserDao;
import com.katey2658.web.dao.impl.UserDaoImpl;
import com.katey2658.web.entity.User;
import com.katey2658.web.service.UserService;

import java.util.Collection;


/**
 * Created by 11456 on 2016/12/4.
 */

public class UserServiceImpl implements UserService {

    /**
     * 根据用户号和密码登录
     *
     * @param userId  用户名
     * @param userPwd 密码
     * @return 返回结果状态 -1 密码有误，-2账号错误，0登录成功
     */
    @Override
    public int signIn(String userId, String userPwd) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserById(userId);
        System.out.println("----------------"+user.getUserName());
        if (user != null) {
            if (user.getUserPwd().endsWith(userPwd)) {
                return 0;
            } else {
                return -1;
            }
        }
        return -2;
    }

    @Override
    public int signInByMail(String userMail, String userPwd) {
        return 0;
    }

    @Override
    public int signUp(User user) {
        UserDao userDao=new UserDaoImpl();
        userDao.addUser(user);
        return 0;
    }

    @Override
    public int logOut(String userId) {
        return 0;
    }

    @Override
    public int closeUser(String userId) {
        return 0;
    }

    @Override
    public Collection<User> showUsersByPage(int page) {
        return null;
    }

    @Override
    public User getUserInfo(String userId) {
        return null;
    }

    @Override
    public int updateUserInfo(User userInfo) {
        return 0;
    }

    @Override
    public User findUserById(String userId) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserById(userId);
        return user;
    }

    @Override
    public int resetUserPwd(String userId, String oldUserPwd, String newUserPwd) {
        return 0;
    }

    @Override
    public User resetUserMail(String userId, String oldUserMail, String newUserMail) {
        return null;
    }

}

